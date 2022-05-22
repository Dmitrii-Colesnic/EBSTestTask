package com.example.ebstesttask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.ebstesttask.databinding.ActivityExpandedModelBinding
import com.example.ebstesttask.databinding.ActivityFavoritesBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ExpandedModel : AppCompatActivity() {

    lateinit var binding: ActivityExpandedModelBinding

    var id: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExpandedModelBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mobileDao = (application as MobileApp).bd.mobileDao()

        // Toolbar settings
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false);
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        binding?.toolbar?.setNavigationOnClickListener {

            lifecycleScope.launch {
                mobileDao.updateIsSelectedById(id, false)
            }

            onBackPressed()
        }
        //////////////////

        lifecycleScope.launch{
            mobileDao.fetchMobileByIsSelected(true).collect {
                if(it != null){
                    id = it.id
                    binding.ivImageModel.setImageResource(it.image)
                    binding.tvNameModel.text = it.name
                    binding.tvDescriptionModel.text = it.characteristic
                    binding.tvPriceModel.text = it.price
                    binding.tvInformation.text = it.information

                }
            }
        }

    }


}