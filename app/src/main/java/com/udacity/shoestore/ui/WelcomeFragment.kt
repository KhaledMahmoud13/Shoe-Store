package com.udacity.shoestore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {
    private lateinit var binding: FragmentWelcomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_welcome, container, false)

//        Click listener to navigate to the InstructionFragment
        binding.btnToInstruction.setOnClickListener {
            val action = WelcomeFragmentDirections.actionWelcomeFragmentToInstructionsFragment()
            findNavController().navigate(action)
        }
        return binding.root
    }
}