package com.vss3003.wallpapersearcher.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vss3003.wallpapersearcher.App
import com.vss3003.wallpapersearcher.domain.Heroes
import com.vss3003.wallpapersearcher.domain.Interactor
import javax.inject.Inject

class CharacterViewModel : ViewModel() {
    val charactersListLiveData:  MutableLiveData<List<Heroes>> = MutableLiveData()
    @Inject
    lateinit var interactor: Interactor

    init {
        App.instance.dagger.inject(this)
        interactor.getCharactersFromApi(1, object : ApiCallback {
            override fun onSuccess(heroes: List<Heroes>) {
                Log.d("TAG", "onSuccess: $heroes")
                charactersListLiveData.postValue(heroes)
            }

            override fun onFailure() {
            }
        })
    }

    interface ApiCallback {
        fun onSuccess(heroes: List<Heroes>)
        fun onFailure()
    }
}