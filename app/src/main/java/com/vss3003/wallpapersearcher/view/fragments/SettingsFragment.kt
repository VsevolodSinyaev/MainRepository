package com.vss3003.wallpapersearcher.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.vss3003.wallpapersearcher.R

class SettingsFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_settings, container, false)
        //AnimationHelper.performFragmentCircularRevealAnimation(home_fragment_root, requireActivity(), 1)
    }

}

