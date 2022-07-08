package com.example.movieapp_kotlin.data.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.movieapp_kotlin.data.model.Moviedata
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import io.reactivex.android.schedulers.AndroidSchedulers

class DatabaseRepository
constructor( val appDatabase: MyAppDatabase){

    fun getLiveFavoriteMovies() : LiveData<MutableList<Moviedata>> {
        return appDatabase.moviesDAO.loadAll()
    }

     fun addFavoriteMovie(movie: Moviedata){
        appDatabase.moviesDAO.insert(movie)
    }

     fun deleteFavoriteMovie(movieID : Int){
        appDatabase.moviesDAO.delete(movieID)
    }

    fun checkFavoriteMovie(movieID: Int) : MutableLiveData<Boolean>{
        val isFavorite : MutableLiveData<Boolean> = MutableLiveData()
        appDatabase.moviesDAO.isExist(movieID).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                if (it == 0){
                    isFavorite.postValue(false)
                }else
                    isFavorite.postValue(true)
            },{

            })
        return isFavorite
    }
}