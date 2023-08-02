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

    private val m = ArrayList<Shoe>()


    init {
        Timber.i("HERE IS init for shoeViewModel")
        //_shoeList.value = mutableListOf()
        Timber.i("HERE IS shoelist size is ${_shoeList.value!!.size}")
        //Timber.i("HERE IS shoelist size is ${_shoeList.value!![0]}")

    }

    fun addShoe(sName: String, cName: String, sSize: Double, sInfo: String) {
        Timber.i("HERE IS info seen in view model $sName, $cName, $sSize, $sInfo")
        Timber.i("HERE IS shoelist size is ${_shoeList.value!!.size}")

        //_shoeList.value?.toMutableList()?.add(Shoe(sName, sSize, cName, sInfo))
        //(_shoeList.value as?MutableList<Shoe>)?.add(Shoe(sName, sSize, cName, sInfo))
    }

    /*fun addShoeVM(name: String, size: Double, company: String, info: String) {
        val shoe = Shoe(name, size, company, info)
        _shoeList.value?.add(shoe)
    }*/
}