package com.melfouly.shoestore.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.melfouly.shoestore.R
import com.melfouly.shoestore.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding = FragmentWelcomeBinding.inflate(inflater, container, false)

        binding.nextBtn.setOnClickListener {
            findNavController().navigate(R.id.action_welcomeFragment_to_instructionsFragment)
        }

        return binding.root
    }
}