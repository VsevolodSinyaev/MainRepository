package com.vss3003.wallpapersearcher.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vss3003.wallpapersearcher.App
import com.vss3003.wallpapersearcher.domain.Heroes
import com.vss3003.wallpapersearcher.domain.Interactor
import java.util.concurrent.Executors
import javax.inject.Inject

class HomeFragmentViewModel : ViewModel() {
    val heroesListLiveData: MutableLiveData<List<Heroes>> = MutableLiveData()

    @Inject
    lateinit var interactor: Interactor

    init {
        App.instance.dagger.inject(this)
        interactor.getHeroesFromApi(1, object : ApiCallback {
            override fun onSuccess(heroes: MutableList<Heroes>) {
                Log.d("TAG", "onSuccess: $heroes")
                heroesListLiveData.postValue(heroes)
            }

            override fun onFailure() {
            }
        })
    }

    fun getHeroes() {
        interactor.getHeroesFromApi(1, object : ApiCallback {
            override fun onSuccess(heroes: MutableList<Heroes>) {
                heroesListLiveData.postValue(heroes)
            }

            override fun onFailure() {
                Executors.newSingleThreadExecutor().execute {
                    heroesListLiveData.postValue(interactor.getHeroesFromApi(1, object : ApiCallback))
                }
            }
        })
    }

    interface ApiCallback {
        fun onSuccess(heroes: MutableList<Heroes>)
        fun onFailure()
    }
}

