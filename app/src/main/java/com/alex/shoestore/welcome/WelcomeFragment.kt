package com.alex.shoestore.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.alex.shoestore.R
import com.alex.shoestore.databinding.WelcomeFragmentBinding

class WelcomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {

        val binding: WelcomeFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.welcome_fragment, container, false)

        binding.navToInstructionsButton.setOnClickListener {
            findNavController().navigate(WelcomeFragmentDirections
                .actionWelcomeDestinationToInstructionsDestination())
        }

        return binding.root
    }
}