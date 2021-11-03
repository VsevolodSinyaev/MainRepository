package com.vss3003.wallpapersearcher.view.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.vss3003.wallpapersearcher.R
import com.vss3003.wallpapersearcher.data.ApiConstants
import com.vss3003.wallpapersearcher.databinding.FragmentDetailsBinding
import com.vss3003.wallpapersearcher.domain.Heroes

class DetailsFragment : Fragment() {
    private lateinit var heroes: Heroes
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
            if (!heroes.isInFavorites) {
                binding.detailsFabFavorites.setImageResource(R.drawable.ic_round_favorite)
                heroes.isInFavorites = true
            } else {
                binding.detailsFabFavorites.setImageResource(R.drawable.ic_round_favorite_border)
                heroes.isInFavorites = false
            }
        }

        binding.detailsFabShare.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(
                    Intent.EXTRA_TEXT,
                    "Check out this film: ${heroes.name} \n\n ${heroes.description}"
            )
            intent.type = "text/plain"
            startActivity(Intent.createChooser(intent, "Share To:"))
        }
    }

    private fun setFilmsDetails() {
        heroes = arguments?.get("film") as Heroes

        binding.detailsToolbar.title = heroes.name
        Glide.with(this)
                .load(ApiConstants.IMAGE_URL + heroes.id + "standard_medium")
                .centerCrop()
                .into(binding.detailsPoster)
        binding.detailsDescription.text = heroes.description

        binding.detailsFabFavorites.setImageResource(
                if (heroes.isInFavorites) R.drawable.ic_round_favorite
                else R.drawable.ic_round_favorite_border
        )
    }
}