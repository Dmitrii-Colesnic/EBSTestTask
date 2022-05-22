package com.example.ebstesttask

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ebstesttask.databinding.ItemSmallDescriptionBinding

class ModelItemAdepter(
    private val items: ArrayList<MobileEntity>,
    private val imageHeartPressAction: (id: Int, toChange: Int) -> Unit,
    private val startActivity: (id: Int) -> Unit
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

        holder.imageModel.setImageResource(item.image)
        holder.nameModel.text = item.name
        holder.descriptionModel.text = item.characteristic
        holder.priceModel.text = item.price
        holder.isChecked.setImageResource(item.isChecked)

        holder.isChecked.setOnClickListener {
            imageHeartPressAction.invoke(item.id ,item.isChecked)
        }

        holder.nameModel.setOnClickListener {
                startActivity.invoke(item.id)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

}