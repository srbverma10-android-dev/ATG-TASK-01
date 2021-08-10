package com.example.atginterntask1.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.atginterntask1.R
import com.example.atginterntask1.adapters.RecyclerViewAdapter.MyViewHolder
import com.example.atginterntask1.databinding.RecyclerViewBinding
import com.example.atginterntask1.pojo.Photo

class RecyclerViewAdapter : RecyclerView.Adapter<MyViewHolder>() {

    private lateinit var items : List<Photo>

    fun setDataList(data: List<Photo>){
        this.items = data
    }

    class MyViewHolder(private val binding: RecyclerViewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data : Photo){
            binding.resultItem = data
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RecyclerViewBinding.inflate(layoutInflater, parent, false)
        return MyViewHolder(binding)    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        items[position].let {
            holder.bind(it)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    companion object{
        @BindingAdapter("loadImage")
        @JvmStatic
        fun loadImage(imageView: ImageView, url: String){
            Glide.with(imageView)
                .load(url)
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(imageView)
        }

    }

}