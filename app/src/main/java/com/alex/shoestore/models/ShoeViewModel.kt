package com.alex.shoestore.models

import android.R
import android.widget.LinearLayout
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber


class ShoeViewModel : ViewModel() {

    private val _shoeList = MutableLiveData<List<Shoe>>(mutableListOf())
    val shoeList: LiveData<List<Shoe>>
        get() = _shoeList

    private val _save = MutableLiveData<Boolean>()
    val save: LiveData<Boolean>
        get() = _save


    init {
        Timber.i("HERE IS shoelist size is ${_shoeList.value!!.size}")
        _shoeList.value = ArrayList()
    }

    fun addShoe(sName: String, sSize: Double, cName: String, sInfo: String) {
        Timber.i("HERE IS info seen in view model $sName, $sSize, $cName, $sInfo")

        (_shoeList.value as ArrayList<Shoe>).add(Shoe(sName, sSize, cName, sInfo))
        Timber.i("HERE IS shoe list size is ${_shoeList.value!!.size}")
    }

}