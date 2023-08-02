package com.alex.shoestore.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.alex.shoestore.R
import com.alex.shoestore.databinding.LoginFragmentBinding

class LoginFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {

        val binding: LoginFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.login_fragment, container, false)
        binding.loginFragment.background.alpha = 75
        binding.signInButton.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections
                .actionLoginDestinationToWelcomeDestination())
        }

        binding.signUpButton.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections
                .actionLoginDestinationToWelcomeDestination())
        }

        return binding.root
    }
}