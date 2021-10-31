package com.vss3003.wallpapersearcher

import Interactor
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CharacterViewModel : ViewModel() {
    val filmsListLiveData:  MutableLiveData<List<Character>> = MutableLiveData()
    private var interactor: Interactor = App.instance.interactor

    init {
        interactor.getFilmsFromApi(1, object : ApiCallback {
            override fun onSuccess(characters: List<Character>) {
                filmsListLiveData.postValue(characters)
            }

            override fun onFailure() {
            }
        })
    }

    interface ApiCallback {
        fun onSuccess(characters: List<Character>)
        fun onFailure()
    }
}