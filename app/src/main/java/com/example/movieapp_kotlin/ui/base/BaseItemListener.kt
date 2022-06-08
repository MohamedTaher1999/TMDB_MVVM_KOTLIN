package com.example.movieapp_kotlin.ui.base

import android.view.View

interface BaseItemListener<T> {
    fun onItemClick(view: View, item: T)
}