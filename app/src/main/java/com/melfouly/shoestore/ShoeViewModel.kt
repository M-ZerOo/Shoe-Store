package com.melfouly.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.melfouly.shoestore.model.Shoe

class ShoeViewModel : ViewModel() {

    private var _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>> get() = _shoeList

    init {
        // Declare the shoeList and add some items to it once initialized
        _shoeList.value = mutableListOf()
        _shoeList.value?.add(Shoe("Niko", 36.0, "Nike", "Good"))
        _shoeList.value?.add(Shoe("Pumi", 37.0, "Puma", "Fine"))

    }

    // To add a new shoe
    fun addNewShoe(shoe: Shoe) {
        _shoeList.value?.add(shoe)
    }

    // To reset the shoe list
    fun resetTheList() {
        _shoeList.value?.clear()
    }

}