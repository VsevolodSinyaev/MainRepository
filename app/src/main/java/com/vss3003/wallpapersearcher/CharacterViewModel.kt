package com.vss3003.wallpapersearcher

import Interactor
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CharacterViewModel : ViewModel() {
    val charactersListLiveData:  MutableLiveData<List<Character>> = MutableLiveData()
    private var interactor: Interactor = App.instance.interactor

    init {
        App.instance.dagger.inject(this)
        interactor.getCharactersFromApi(1, object : ApiCallback {
            override fun onSuccess(characters: List<Character>) {
                charactersListLiveData.postValue(characters)
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