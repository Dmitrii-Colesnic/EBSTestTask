package com.example.ebstesttask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ebstesttask.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Toolbar settings
        setSupportActionBar(binding.toolbar)

        supportActionBar?.setDisplayShowTitleEnabled(false)

        //////////////////

        //made images rounded
        binding.ivSortingHorizontal.clipToOutline = true
        binding.ivSortingVertical.clipToOutline = true

        val mobileDao = (application as MobileApp).bd.mobileDao()

        binding?.ivFavotites.setOnClickListener {
            startActivity(Intent(this, FavoritesActivity::class.java))
        }

        //костыль, проверка если сущности уже созданы
        lifecycleScope.launch {
            mobileDao.fetchMobileById(1).collect {
                if(it == null){
                    addRecords(mobileDao)
                }
            }
        }

        //костыль проверка если пользователь не закрыл выбранную модель
        lifecycleScope.launch {
            mobileDao.fetchMobileByIsSelected(true).collect {
                if(it != null){
                    mobileDao.updateIsSelectedById(it.id, false)
                }
            }
        }

        lifecycleScope.launch {
            mobileDao.fetchAllMobiles().collect {
                val listOfModels = ArrayList(it)
                setupListOfDateIntoRecyclerView(listOfModels, mobileDao)
            }
        }

    }

    private fun addRecords(mobileDao: MobileDao){

        lifecycleScope.launch{
            mobileDao.insert(Constants.phone1)
            mobileDao.insert(Constants.HDD)
            mobileDao.insert(Constants.phone2)
        }

    }

    private fun setupListOfDateIntoRecyclerView(
        listOfModels: ArrayList<MobileEntity>,
        mobileDao: MobileDao
    ){
        val itemAdepter = ModelItemAdepter(
            listOfModels,
            { id, toCheck -> changeCheckMark(id, toCheck, mobileDao) },
            { id -> isSelected(id, mobileDao)  }
        )

        binding.rvModels.layoutManager = LinearLayoutManager(this)
        binding.rvModels.adapter = itemAdepter
    }

    private fun changeCheckMark(id: Int, toCheck: Int, mobileDao: MobileDao){

        if (toCheck == R.drawable.ic_heart) {
            lifecycleScope.launch {
                mobileDao.updateIsCheckedById(id, R.drawable.ic_heart2)
                Toast.makeText(
                    this@MainActivity,
                    "You add to favourites",
                    Toast.LENGTH_SHORT
                ).show()
            }
        } else if (toCheck == R.drawable.ic_heart2) {
            lifecycleScope.launch {
                mobileDao.updateIsCheckedById(id, R.drawable.ic_heart)
            }
        }

    }

    private fun isSelected(id: Int, mobileDao: MobileDao){

        //TODO не работает запрос updateIsSelectedById()
        lifecycleScope.launch {
            mobileDao.updateIsSelectedById(id, true)
        }

        val intent = Intent(this,ExpandedModel::class.java)
        startActivity(intent)

    }

}