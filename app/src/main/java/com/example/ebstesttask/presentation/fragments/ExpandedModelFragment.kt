package com.example.ebstesttask.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.ebstesttask.databinding.FragmentExpandedModelBinding
import com.example.ebstesttask.presentation.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ExpandedModelFragment : Fragment() {

    lateinit var binding: FragmentExpandedModelBinding

    private val viewModel: MainViewModel by activityViewModels()


//    var id: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentExpandedModelBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }


//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityExpandedModelBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        val mobileDao = (application as MobileApp).bd.mobileDao()
//
//        // Toolbar settings
//        setSupportActionBar(binding.toolbar)
//        supportActionBar?.setDisplayShowTitleEnabled(false);
//        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
//        binding?.toolbar?.setNavigationOnClickListener {
//
//            lifecycleScope.launch {
//                mobileDao.updateIsSelectedById(id, false)
//            }
//
//            onBackPressed()
//        }
//        //////////////////
//
//        lifecycleScope.launch{
//            mobileDao.fetchMobileByIsSelected(true).collect {
//                if(it != null){
//                    id = it.id
//                    binding.ivImageModel.setImageResource(it.image)
//                    binding.tvNameModel.text = it.name
//                    binding.tvDescriptionModel.text = it.characteristic
//                    binding.tvPriceModel.text = it.price
//                    binding.tvInformation.text = it.information
//
//                }
//            }
//        }
//
//    }


}