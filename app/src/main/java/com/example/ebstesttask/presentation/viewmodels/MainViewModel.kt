package com.example.ebstesttask.presentation.viewmodels

import android.app.Application
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Looper
import android.widget.ImageView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.usecase.GetProductListUseCase
import com.example.ebstesttask.databinding.FragmentMainBinding
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.concurrent.Executors
import javax.inject.Inject
import android.os.Handler
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.example.domain.models.Phone
import com.example.ebstesttask.App.MobileApp
import com.example.ebstesttask.adapter.ModelItemAdepter

@HiltViewModel
class MainViewModel @Inject constructor(
    application: Application,
    private val getProductListUseCase: GetProductListUseCase
) : AndroidViewModel(application) {

    private val context
        get() = getApplication<Application>()

    private var liveData = MutableLiveData<String>()
    val resultLiveData: LiveData<String> = liveData

    private val mobileDao = (application as MobileApp).bd.mobileDao()


    //============= Functions =============

    fun getListOfDateFromJson(
        binding: FragmentMainBinding
    ){
        val phones = getProductListUseCase.execute()
        Log.e("AAA", phones.toString())

/*
        val itemAdepter = ModelItemAdepter(
            phones,
//            { id, toCheck -> changeCheckMark(id, toCheck, mobileDao) },
//            { id -> isSelected(id, mobileDao)  },
            { imageView, imageURL -> downloadImageFromInternet(imageView, imageURL) }
        )

        binding.rvModels.layoutManager = LinearLayoutManager(context)
        binding.rvModels.adapter = itemAdepter*/
    }

    private fun downloadImageFromInternet(imageView: ImageView, imageURL: String) {

        val executor = Executors.newSingleThreadExecutor()

        val handler: Handler = Handler(Looper.getMainLooper())

        var image: Bitmap? = null

        executor.execute {
            try {
                val `in` = java.net.URL(imageURL).openStream()
                image = BitmapFactory.decodeStream(`in`)

                handler.post {
                    imageView.setImageBitmap(image)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
//    fun changeCheckMark(id: Int, toCheck: Int, mobileDao: MobileDao){
//
//        if (toCheck == R.drawable.ic_heart) {
//            lifecycleScope.launch {
//                mobileDao.updateIsCheckedById(id, R.drawable.ic_heart2)
//                Toast.makeText(
//                    this@MainActivity,
//                    "You add to favourites",
//                    Toast.LENGTH_SHORT
//                ).show()
//            }
//        } else if (toCheck == R.drawable.ic_heart2) {
//            lifecycleScope.launch {
//                mobileDao.updateIsCheckedById(id, R.drawable.ic_heart)
//            }
//        }
//
//    }
//
//    fun isSelected(id: Int, mobileDao: MobileDao){
//
//        //TODO не работает запрос updateIsSelectedById()
//        lifecycleScope.launch {
//            mobileDao.updateIsSelectedById(id, true)
//        }
//
//        val intent = Intent(this, ExpandedModelFragment::class.java)
//        startActivity(intent)
//
//    }



}