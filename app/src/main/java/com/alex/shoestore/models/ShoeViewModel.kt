package com.alex.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class ShoeViewModel : ViewModel() {

    private val _shoeList = MutableLiveData<List<Shoe>>(mutableListOf())
    val shoeList: LiveData<List<Shoe>>
        get() = _shoeList

    init {
        _shoeList.value = ArrayList()
    }

    fun addShoe(sName: String, sSize: Double, cName: String, sInfo: String) {
        (_shoeList.value as ArrayList<Shoe>).add(Shoe(sName, sSize, cName, sInfo))
    }
}