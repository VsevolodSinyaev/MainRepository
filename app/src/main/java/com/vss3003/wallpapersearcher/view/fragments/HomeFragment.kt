package com.vss3003.wallpapersearcher.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.vss3003.wallpapersearcher.databinding.FragmentHomeBinding
import com.vss3003.wallpapersearcher.domain.Heroes
import com.vss3003.wallpapersearcher.utils.AnimationHelper
import com.vss3003.wallpapersearcher.view.MainActivity
import com.vss3003.wallpapersearcher.view.rv_adapter.CharacterListRecyclerAdapter
import com.vss3003.wallpapersearcher.view.rv_adapter.TopSpacingItemDecoration
import com.vss3003.wallpapersearcher.viewmodel.CharacterViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import java.util.*

class HomeFragment : Fragment() {
    private val viewModel by lazy {
        ViewModelProvider.NewInstanceFactory().create(CharacterViewModel::class.java)
    }
    private lateinit var charactersAdapter: CharacterListRecyclerAdapter
    private lateinit var binding: FragmentHomeBinding

    private var charactersDataBase = listOf<Heroes>()
        set(value) {
            if (field == value) return
            field = value
            charactersAdapter.addItems(field)
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

        initRecyckler()

        viewModel.charactersListLiveData.observe(viewLifecycleOwner, {
            charactersAdapter.addItems(it)
        })

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
                    charactersAdapter.addItems(charactersDataBase)
                    return true
                }
                //Фильтруем список на поискк подходящих сочетаний
                val result = charactersDataBase.filter {
                    //Чтобы все работало правильно, нужно и запроси и имя фильма приводить к нижнему регистру
                    it.name.toLowerCase(Locale.getDefault()).contains(newText.toLowerCase(Locale.getDefault()))
                }
                //Добавляем в адаптер
                charactersAdapter.addItems(result)
                return true
            }
        })
    }

    private fun initRecyckler() {
        main_recycler.apply {
            charactersAdapter =
                    CharacterListRecyclerAdapter(object : CharacterListRecyclerAdapter.OnItemClickListener {
                        override fun click(heroes: Heroes) {
                            (requireActivity() as MainActivity).launchDetailsFragment(heroes)
                        }
                    })
            adapter = charactersAdapter
            layoutManager = LinearLayoutManager(requireContext())
            val decorator = TopSpacingItemDecoration(8)
            addItemDecoration(decorator)
        }
    }

}