package com.alex.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class ShoeViewModel : ViewModel() {

    private val _shoeList = MutableLiveData<List<Shoe>>(mutableListOf())
    val shoeList: LiveData<List<Shoe>>
        get() = _shoeList

    private val _saveData = MutableLiveData<Boolean>()
    val saveData: LiveData<Boolean>
        get() = _saveData

    private val _cancel = MutableLiveData<Boolean>()
    val cancel: LiveData<Boolean>
        get() = _cancel

    init {
        _shoeList.value = ArrayList()
    }

    fun addShoe(sName: String, sSize: Double, cName: String, sInfo: String) {
        (_shoeList.value as ArrayList<Shoe>).add(Shoe(sName, sSize, cName, sInfo))
        _saveData.value = true
       // _cancel.value = false
    }

    fun saveTheData() {
        _saveData.value = true
       // _cancel.value = false
    }

    fun cancelGoBack() {
        _saveData.value = false
        _cancel.value = true
    }
}