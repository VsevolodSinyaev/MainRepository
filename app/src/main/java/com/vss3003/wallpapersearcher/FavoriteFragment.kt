package com.vss3003.wallpapersearcher

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.vss3003.wallpapersearcher.databinding.FragmentFavoriteBinding
import kotlinx.android.synthetic.main.fragment_favorite.*

class FavoriteFragment : Fragment() {
    private lateinit var charactersAdapter: CharacterListRecyclerAdapter
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
        val favoriteList: List<Character> = emptyList()

        AnimationHelper.performFragmentCircularRevealAnimation(favorite_fragment_root, requireActivity(),2)

        binding.favoriteRecycler.apply {
            charactersAdapter = CharacterListRecyclerAdapter(object : CharacterListRecyclerAdapter.OnItemClickListener {
                override fun click(character: Character) {
                    (requireActivity() as MainActivity).launchDetailsFragment(character)
                }
            })
            //Присваиваем адаптер
            adapter = charactersAdapter
            //Присвои layoutmanager
            layoutManager = LinearLayoutManager(requireContext())
            //Применяем декоратор для отступов
            val decorator = TopSpacingItemDecoration(8)
            addItemDecoration(decorator)
        }
        //Кладем нашу БД в RV
        charactersAdapter.addItems(favoriteList)
    }
}