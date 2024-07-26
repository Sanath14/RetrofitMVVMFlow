package com.appynitty.retrofitexample.presentation

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.appynitty.retrofitexample.databinding.EachItemBinding
import com.appynitty.retrofitexample.model.PhotoData
import com.squareup.picasso.Picasso

class PhotoAdapter : ListAdapter<PhotoData, PhotoAdapter.PhotoViewHolder>(DiffCallBack()) {

    inner class PhotoViewHolder(private val binding: EachItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: PhotoData) {
            Log.i("imageUr434l", "bind: ${data.url}")
            Picasso.get().load(data.url).into(binding.imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val binding =
            EachItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhotoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

class DiffCallBack : DiffUtil.ItemCallback<PhotoData>() {
    override fun areItemsTheSame(oldItem: PhotoData, newItem: PhotoData) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(
        oldItem: PhotoData,
        newItem: PhotoData
    ) = oldItem == newItem
}