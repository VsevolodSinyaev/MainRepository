package com.vss3003.wallpapersearcher

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide

class DetailsFragment : Fragment() {
    private lateinit var character: Character
    private lateinit var binding: FragmentDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setFilmsDetails()

        binding.detailsFabFavorites.setOnClickListener {
            if (!character.isInFavorites) {
                binding.detailsFabFavorites.setImageResource(R.drawable.ic_round_favorite)
                character.isInFavorites = true
            } else {
                binding.detailsFabFavorites.setImageResource(R.drawable.ic_round_favorite_border)
                character.isInFavorites = false
            }
        }

        binding.detailsFabShare.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(
                Intent.EXTRA_TEXT,
                "Check out this film: ${character.name} \n\n ${character.description}"
            )
            intent.type = "text/plain"
            startActivity(Intent.createChooser(intent, "Share To:"))
        }
    }

    private fun setFilmsDetails() {
        character = arguments?.get("film") as Character

        binding.detailsToolbar.title = character.name
        Glide.with(this)
            .load(ApiConstants.IMAGE_URL + character.id + "standard_medium")
            .centerCrop()
            .into(binding.detailsPoster)
        binding.detailsDescription.text = character.description

        binding.detailsFabFavorites.setImageResource(
            if (character.isInFavorites) R.drawable.ic_round_favorite
            else R.drawable.ic_round_favorite_border
        )
    }
}