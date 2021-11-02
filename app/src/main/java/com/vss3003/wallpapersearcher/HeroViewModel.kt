package com.vss3003.wallpapersearcher

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class HeroViewModel : ViewModel() {
    val heroesListLiveData:  MutableLiveData<List<Hero>> = MutableLiveData()
    @Inject
    lateinit var interactor: Interactor

    init {
        App.instance.dagger.inject(this)
        interactor.getHeroesFromApi(1, object : ApiCallback {
            override fun onSuccess(heroes: List<Hero>) {
                heroesListLiveData.postValue(heroes)
            }

            override fun onFailure() {
            }
        })
    }

    interface ApiCallback {
        fun onSuccess(heroes: List<Hero>)
        fun onFailure()
    }
}