package com.example.androidavanzado.list

import android.app.LauncherActivity.ListItem
import android.os.Binder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidavanzado.databinding.ListItemBinding
import com.example.androidavanzado.model.Model
import com.squareup.picasso.Picasso


class ItemAdapter : RecyclerView.Adapter <ItemAdapter.ViewHolder>(){

    private lateinit var binder : ListItemBinding
    private var itemList : MutableList<Model> = mutableListOf()

    inner class ViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        // REFACTOR WITH 'LET'
        fun bind(item : Model) = binding.let {
            it.tvName.text = item.name
            Glide.with(it.root)
                .load(item.photo)
                .into(it.ivPhoto)
        }
        //- with VersiÓn
        /*
            with(binding) {
                tvName.text = item.dummy().name
                // INSERCIÓN DEL URI IMAGE EN LA IMAGEVIEW MEDIANTE LA CONVERSIÓN DEL GLIDE
                Glide.with(root)
                    .load(item.dummy().photo)
                    .into(ivPhoto)
            }
        }*/

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.ViewHolder {

        return ViewHolder(ListItemBinding
                            .inflate(
                                LayoutInflater.from(parent.context),
                                parent,
                                false
                            ))
    }

    override fun onBindViewHolder(holder: ItemAdapter.ViewHolder, position: Int){ holder.bind(itemList[position])}


    override fun getItemCount(): Int = itemList.size

    fun setItems(models : List<Model>) {
        itemList = models.toMutableList()
        notifyDataSetChanged()
    }
}