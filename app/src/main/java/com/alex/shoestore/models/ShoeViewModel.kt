package com.alex.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class ShoeViewModel : ViewModel() {

    private val _shoeList = MutableLiveData<List<Shoe>>(mutableListOf())
    val shoeList: LiveData<List<Shoe>>
        get() = _shoeList

    private val _shoeName = MutableLiveData<String>()
    val shoeName: LiveData<String>
        get() = _shoeName

    private val _shoeSize = MutableLiveData<Double>()
    val shoeSize: LiveData<Double>
        get() = _shoeSize

    private val _companyName = MutableLiveData<String>()
    val companyName: LiveData<String>
        get() = _companyName

    private val _shoeInfo = MutableLiveData<String>()
    val shoeInfo: LiveData<String>
        get() = _shoeInfo

    private val _saveInfo = MutableLiveData<Boolean>()
    val saveInfo: LiveData<Boolean>
        get() = _saveInfo


    init {
        _shoeList.value = ArrayList()
        _saveInfo.value = true
    }

    fun saveTheInfo() {
        _saveInfo.value = true
        (_shoeList.value as ArrayList<Shoe>).add(
            Shoe(
                _shoeName.toString(),
                _shoeSize.toString().toDouble(),
                _companyName.toString(),
                _shoeInfo.toString()
            )
        )
    }

}