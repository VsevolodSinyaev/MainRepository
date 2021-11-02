package com.vss3003.wallpapersearcher.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.vss3003.wallpapersearcher.databinding.FragmentHomeBinding
import com.vss3003.wallpapersearcher.domain.Hero
import com.vss3003.wallpapersearcher.utils.AnimationHelper
import com.vss3003.wallpapersearcher.view.rv_adapter.HeroListRecyclerAdapter
import com.vss3003.wallpapersearcher.view.MainActivity
import com.vss3003.wallpapersearcher.view.rv_adapter.TopSpacingItemDecoration
import com.vss3003.wallpapersearcher.viewmodel.HeroViewModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    private val viewModel by lazy {
        ViewModelProvider.NewInstanceFactory().create(HeroViewModel::class.java)
    }
    private lateinit var heroesAdapter: HeroListRecyclerAdapter
    private lateinit var binding: FragmentHomeBinding
    private var heroesDataBase = listOf<Hero>()
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

        initRecyckler()
        viewModel.heroesListLiveData.observe(viewLifecycleOwner, {
            heroesDataBase = it
        })

    }


    private fun initRecyckler() {
        main_recycler.apply {
            heroesAdapter =
                HeroListRecyclerAdapter(object : HeroListRecyclerAdapter.OnItemClickListener {
                    override fun click(hero: Hero) {
                        (requireActivity() as MainActivity).launchDetailsFragment(hero)
                    }
                })
            adapter = heroesAdapter
            layoutManager = LinearLayoutManager(requireContext())
            val decorator = TopSpacingItemDecoration(8)
            addItemDecoration(decorator)
        }
    }

}