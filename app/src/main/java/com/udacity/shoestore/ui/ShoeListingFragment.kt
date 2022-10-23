package com.udacity.shoestore.ui

import android.os.Bundle
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListingBinding
import com.udacity.shoestore.databinding.ItemviewBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewModel.ShoeViewModel

class ShoeListingFragment : Fragment() {

    lateinit var binding: FragmentShoeListingBinding
    lateinit var viewModel: ShoeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_listing, container, false)
        viewModel =ViewModelProvider(requireActivity()).get(ShoeViewModel::class.java)

        binding.lifecycleOwner = this

        viewModel.shoeDataList.observe(viewLifecycleOwner, Observer{
            for (i in it){
                val shoeItem = ItemviewBinding.inflate(layoutInflater)
                shoeItem.shoe = i
                binding.container.addView(shoeItem.root)
                shoeItem.imgDel.setOnClickListener {
                    binding.container.removeView(shoeItem.root)
                }
            }
        })
//      Click listener to navigate to the ShoeDetailsFragment
        binding.btnAdd.setOnClickListener {
            val action = ShoeListingFragmentDirections.actionShoeListingFragmentToShoeDetailFragment()
            findNavController().navigate(action)
        }
        setHasOptionsMenu(true)
        return binding.root
    }

//    Create optionMenu
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.logout_menu, menu)

        super.onCreateOptionsMenu(menu, inflater)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(requireView().findNavController()) || super.onOptionsItemSelected(item)
    }
}