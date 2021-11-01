package com.vss3003.wallpapersearcher

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.vss3003.wallpapersearcher.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    private val viewModel by lazy {
        ViewModelProvider.NewInstanceFactory().create(CharacterViewModel::class.java)
    }
    private lateinit var charactersAdapter: CharacterListRecyclerAdapter
    private lateinit var binding: FragmentHomeBinding
    private var charactersDataBase = listOf<Character>()
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
            charactersDataBase = it
        })

    }


    private fun initRecyckler() {
        main_recycler.apply {
            charactersAdapter =
                CharacterListRecyclerAdapter(object : CharacterListRecyclerAdapter.OnItemClickListener {
                    override fun click(character: Character) {
                        (requireActivity() as MainActivity).launchDetailsFragment(character)
                    }
                })
            adapter = charactersAdapter
            layoutManager = LinearLayoutManager(requireContext())
            val decorator = TopSpacingItemDecoration(8)
            addItemDecoration(decorator)
        }
    }

}