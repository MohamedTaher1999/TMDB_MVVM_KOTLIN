package com.example.movieapp_kotlin.ui.base

import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.movieapp_kotlin.data.model.Moviedata

abstract class BasePagedListAdapter : PagedListAdapter<Moviedata,BaseViewHolder>(MovieDiffCallback()) {

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.onBind(position)
    }

    override fun getItemCount(): Int {
        return if (currentList != null && currentList!!.size >  0) currentList!!.size else 1
    }

    class MovieDiffCallback : DiffUtil.ItemCallback<Moviedata>() {
        override fun areItemsTheSame(oldItem: Moviedata, newItem: Moviedata): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Moviedata, newItem: Moviedata): Boolean {
            return oldItem.id == newItem.id
        }
    }

}