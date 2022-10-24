package com.udacity.shoestore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private val action = LoginFragmentDirections.actionLoginFragmentToWelcomeFragment()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

//        Click listener to check if the EditTexts is Empty or not and navigate to the WelcomeFragment
        binding.btnLogin.setOnClickListener {
            if (binding.etEmail.text.toString().isNotEmpty()){
                if (binding.etPass.text.toString().isNotEmpty()){
                    findNavController().navigate(action)
                }else{
                    binding.etPass.error = "Required"
                }
            }else{
                binding.etEmail.error = "Required"
            }
        }

        //        Click listener to check if the EditTexts is Empty or not and navigate to the WelcomeFragment
        binding.btnJoin.setOnClickListener {
            if (binding.etEmail.text.toString().isNotEmpty()){
                if (binding.etPass.text.toString().isNotEmpty()){
                    findNavController().navigate(action)
                }else{
                    binding.etPass.error = "Required"
                }
            }else{
                binding.etEmail.error = "Required"
            }
        }

        return binding.root
    }


}