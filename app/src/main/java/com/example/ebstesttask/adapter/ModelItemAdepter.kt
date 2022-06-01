package com.example.ebstesttask.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.Phone
import com.example.ebstesttask.databinding.ItemSmallDescriptionBinding

import android.widget.ImageView

class ModelItemAdepter(
    private val items: ArrayList<Phone>,
//    private val imageHeartPressAction: (id: Int, toChange: Int) -> Unit,
//    private val startActivity: (id: Int) -> Unit,
    private val downloadImageFromInternet: (imageView: ImageView, imageURL: String) -> Unit
    )
    : RecyclerView.Adapter<ModelItemAdepter.ViewHolder>(){

        class ViewHolder(binding: ItemSmallDescriptionBinding)
            : RecyclerView.ViewHolder(binding.root){

                var imageModel = binding.ivImageModel
                var nameModel = binding.tvNameModel
                var descriptionModel = binding.tvDescriptionModel
                var priceModel = binding.tvPriceModel
                var isChecked = binding.ivIsCheckedModel

            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemSmallDescriptionBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        downloadImageFromInternet(holder.imageModel, item.image)
        holder.nameModel.text = item.name
        holder.descriptionModel.text = "${item.size} / ${item.colour}"
        holder.priceModel.text = item.price
        holder.isChecked.setImageResource(item.isChecked)

//        holder.isChecked.setOnClickListener {
//            imageHeartPressAction.invoke(item.id ,item.isChecked)
//        }
//
//        holder.nameModel.setOnClickListener {
//                startActivity.invoke(item.id)
//        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

}