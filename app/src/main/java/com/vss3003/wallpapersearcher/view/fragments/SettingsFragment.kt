package com.vss3003.wallpapersearcher.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.vss3003.wallpapersearcher.R
import com.vss3003.wallpapersearcher.databinding.FragmentSettingsBinding
import com.vss3003.wallpapersearcher.utils.AnimationHelper
import kotlinx.android.synthetic.main.fragment_settings.*

class SettingsFragment : Fragment() {
    private lateinit var binding: FragmentSettingsBinding

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        binding = FragmentSettingsBinding.inflate(inflater, container, true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        AnimationHelper.performFragmentCircularRevealAnimation(settings_fragment_root, requireActivity(),2)

        binding.icon.setOnClickListener {
            if () {
                binding.icon.setImageResource(R.drawable.ic_round_dark_mode)
            } else {
                binding.icon.setImageResource(R.drawable.ic_round_wb_sunny)
            }
        }

    }

}

