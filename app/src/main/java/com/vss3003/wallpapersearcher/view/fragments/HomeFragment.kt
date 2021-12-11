package com.vss3003.wallpapersearcher.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vss3003.wallpapersearcher.databinding.FragmentHomeBinding
import com.vss3003.wallpapersearcher.domain.Heroes
import com.vss3003.wallpapersearcher.domain.Interactor
import com.vss3003.wallpapersearcher.utils.AnimationHelper
import com.vss3003.wallpapersearcher.view.MainActivity
import com.vss3003.wallpapersearcher.view.rv_adapter.HeroListRecyclerAdapter
import com.vss3003.wallpapersearcher.view.rv_adapter.TopSpacingItemDecoration
import com.vss3003.wallpapersearcher.viewmodel.HomeFragmentViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import java.util.*

class HomeFragment : Fragment() {
    private val viewModel by lazy {
        ViewModelProvider.NewInstanceFactory().create(HomeFragmentViewModel::class.java)
    }
    private lateinit var heroesAdapter: HeroListRecyclerAdapter
    private lateinit var heroesInteractor: Interactor
    private lateinit var binding: FragmentHomeBinding

    private var heroesDataBase = listOf<Heroes>()
        set(value) {
            if (field == value) return
            field = value
            heroesAdapter.addItems(field)
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        AnimationHelper.performFragmentCircularRevealAnimation(home_fragment_root, requireActivity(), 1)

        initRecycler()
        initSearchView()

        viewModel.heroesListLiveData.observe(viewLifecycleOwner, {
            heroesAdapter.addItems(it)
        })

    }

    private fun initRecycler() {
        main_recycler.apply {
            heroesAdapter =
                    HeroListRecyclerAdapter(object : HeroListRecyclerAdapter.OnItemClickListener {
                        override fun click(heroes: Heroes) {
                            (requireActivity() as MainActivity).launchDetailsFragment(heroes)
                        }
                    })
            adapter = heroesAdapter
            layoutManager = LinearLayoutManager(requireContext())
            val decorator = TopSpacingItemDecoration(8)
            addItemDecoration(decorator)
        }

    }

    private fun initSearchView() {

        search_view.setOnClickListener {
            search_view.isIconified = false
        }

        //Подключаем слушателя изменений введенного текста в поиска
        search_view.setOnQueryTextListener(object : SearchView.OnQueryTextListener, androidx.appcompat.widget.SearchView.OnQueryTextListener {
            //Этот метод отрабатывает при нажатии кнопки "поиск" на софт клавиатуре
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            //Этот метод отрабатывает на каждое изменения текста
            override fun onQueryTextChange(newText: String): Boolean {
                //Если ввод пуст то вставляем в адаптер всю БД
                if (newText.isEmpty()) {
                    heroesAdapter.addItems(heroesDataBase)
                    return true
                }
                //Фильтруем список на поискк подходящих сочетаний
                val result = heroesDataBase.filter {
                    //Чтобы все работало правильно, нужно и запроси и имя фильма приводить к нижнему регистру
                    it.name.toLowerCase(Locale.getDefault())
                            .contains(newText.toLowerCase(Locale.getDefault()))
                }
                //Добавляем в адаптер
                heroesAdapter.addItems(result)
                return true
            }
        })
    }

    fun doSearchPagination(
        visibleItemCount: Int,
        totalItemCount: Int,
        pastVisibleItemCount: Int,
        query: String
    ) {
        //Выясняем через переменную, нужна ли загрузка
        if (heroesInteractor.needLoading) {
            //Если у нас при скролле список подходит к концу, то загружем еще порцию
            if ((visibleItemCount + pastVisibleItemCount) >= totalItemCount - 5) {
                heroesInteractor.needLoading = false

                val page = currentlyLoadedSearchPage++
                if (page > totalPagersFromSearch) return

                showProgressBarLiveData.postValue(true)
                //Метод для получения фильмов с API, как видите, мы явно указываем, какую страницу
                //нужно загружать
                getDataFromSearch(query, page)
            }
        }
    }

    private fun RecyclerView.initSearchPagination() {
        //Добавляем слушатель для скролла нашего RV
        addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                //Если по оси Y есть изменение
                if (dy > 0) {
                    //Получаем количество видимых элементов
                    val visibleItemCount = recyclerView.layoutManager!!.childCount
                    //Получаем количесвто общих элементов
                    val totalItemCount = recyclerView.layoutManager!!.itemCount
                    //Находим первый видиимый элемент при скролле
                    val pastVisibleItemCount =
                        (recyclerView.layoutManager as GridLayoutManager).findFirstVisibleItemPosition()
                    //Совсем этим вызываем метод для пагинации
                    viewModel.doSearchPagination(
                        visibleItemCount,
                        totalItemCount,
                        pastVisibleItemCount,
                        query
                    )
                }
            }
        })
    }
}