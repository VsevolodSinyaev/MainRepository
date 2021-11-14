package com.vss3003.wallpapersearcher.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.vss3003.wallpapersearcher.databinding.FragmentFavoriteBinding
import com.vss3003.wallpapersearcher.domain.Heroes
import com.vss3003.wallpapersearcher.utils.AnimationHelper
import com.vss3003.wallpapersearcher.view.MainActivity
import com.vss3003.wallpapersearcher.view.rv_adapter.HeroListRecyclerAdapter
import com.vss3003.wallpapersearcher.view.rv_adapter.TopSpacingItemDecoration
import kotlinx.android.synthetic.main.fragment_favorite.*

class FavoriteFragment : Fragment() {
    private lateinit var heroesAdapter: HeroListRecyclerAdapter
    private lateinit var binding: FragmentFavoriteBinding
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Получаем список при транзакции фрагмента
        val favoriteList: List<Heroes> = emptyList()

        AnimationHelper.performFragmentCircularRevealAnimation(favorite_fragment_root, requireActivity(),2)

        binding.favoriteRecycler.apply {
            heroesAdapter = HeroListRecyclerAdapter(object : HeroListRecyclerAdapter.OnItemClickListener {
                override fun click(heroes: Heroes) {
                    (requireActivity() as MainActivity).launchDetailsFragment(heroes)
                }
            })
            //Присваиваем адаптер
            adapter = heroesAdapter
            //Присвои layoutmanager
            layoutManager = LinearLayoutManager(requireContext())
            //Применяем декоратор для отступов
            val decorator = TopSpacingItemDecoration(8)
            addItemDecoration(decorator)
        }
        //Кладем нашу БД в RV
        heroesAdapter.addItems(favoriteList)
    }
}