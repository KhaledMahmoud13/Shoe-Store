package com.udacity.shoestore.viewModel

import android.graphics.Movie
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel() {

    private val _shoeDataList = MutableLiveData<MutableList<Shoe>>(mutableListOf())
    val shoeDataList : LiveData<MutableList<Shoe>>
        get() = _shoeDataList

    var newAddedShoe = Shoe()

    private var shoeList = mutableListOf<Shoe>()

    fun addShoe(shoe: Shoe) {
        _shoeDataList.value?.add(shoe)
        _shoeDataList.value = _shoeDataList.value
    }
}