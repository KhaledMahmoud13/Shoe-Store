package com.udacity.shoestore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewModel.ShoeViewModel

class ShoeDetailFragment : Fragment() {
    lateinit var binding: FragmentShoeDetailBinding
    lateinit var viewModel: ShoeViewModel
    private val newShoe: Shoe = Shoe("",0.0, "","")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(ShoeViewModel::class.java)

//       Click listener to check if the EditTexts is Empty or not and navigate to the WelcomeFragment
        binding.btnAdd.setOnClickListener {
            if (binding.etName.text!!.isNotEmpty()){
                if (binding.etSize.text!!.isNotEmpty()){
                    if (binding.etCompany.text!!.isNotEmpty()){
                        if (binding.etDescription.text!!.isNotEmpty()){
                            viewModel.shoeDataList.value?.add(
                                Shoe(
                                    binding.etName.text.toString(),
                                    binding.etSize.text.toString().toDouble(),
                                    binding.etCompany.text.toString(),
                                    binding.etDescription.text.toString()
                                ))
                            binding.etName.setText("")
                            binding.etSize.setText("")
                            binding.etCompany.setText("")
                            binding.etDescription.setText("")
                            Toast.makeText(context, "Shoe Added", Toast.LENGTH_SHORT).show()
                        }else{ binding.etDescription.error = "Required" }
                    }else{ binding.etCompany.error = "Required" }
                }else{ binding.etSize.error = "Required" }
            }else{ binding.etName.error = "Required" }
        }

        binding.btnCancel.setOnClickListener {
            val action = ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListingFragment()
            findNavController().navigate(action)
        }
        return binding.root
    }
}