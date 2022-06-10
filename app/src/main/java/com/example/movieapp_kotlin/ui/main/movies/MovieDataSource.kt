package com.example.movieapp_kotlin.ui.main.movies

import android.util.Log
import android.widget.Toast
import androidx.paging.PageKeyedDataSource
import androidx.paging.PagedList
import com.example.movieapp_kotlin.data.model.Moviedata



class MovieDataSource(val category: String) : PageKeyedDataSource<Int, Moviedata>()
{
    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Moviedata>
    ) {
        val x: MutableList<Moviedata> = arrayListOf()
        var genres:ArrayList<String>?=null
        genres?.add("1")
        x.add(Moviedata("dsd","dsd","dsd","dsd","dsd","dsd","dsd","dsd","dsd",genres,"dsd","dsd","dsd","dsd"))
        x.add(Moviedata("dsd","dsd","dsd","dsd","dsd","dsd","dsd","dsd","dsd",genres,"dsd","dsd","dsd","dsd"))
        x.add(Moviedata("dsd","dsd","dsd","dsd","dsd","dsd","dsd","dsd","dsd",genres,"dsd","dsd","dsd","dsd"))
        x.add(Moviedata("dsd","dsd","dsd","dsd","dsd","dsd","dsd","dsd","dsd",genres,"dsd","dsd","dsd","dsd"))

       callback.onResult(x,null,1)

    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Moviedata>) {
        TODO("Not yet implemented")
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Moviedata>) {
        
    }

}