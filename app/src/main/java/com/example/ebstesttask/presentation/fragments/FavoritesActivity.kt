package com.example.ebstesttask.presentation.fragments

import androidx.appcompat.app.AppCompatActivity

class FavoritesActivity : AppCompatActivity() {

//    lateinit var binding: ActivityFavoritesBinding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityFavoritesBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        val mobileDao = (application as MobileApp).bd.mobileDao()
//
//        // Toolbar settings
//        setSupportActionBar(binding.toolbar)
//        supportActionBar?.setDisplayShowTitleEnabled(false);
//        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
//        binding?.toolbar?.setNavigationOnClickListener {
//            onBackPressed()
//        }
//        //////////////////
//
//        lifecycleScope.launch {
//            mobileDao.fetchAllByIsChecked(R.drawable.ic_heart2).collect {
//                val arrayListIsChecked = ArrayList(it)
//                binding.tvAmountOfCheckedModels.text = it.size.toString()
//                setupListOfDateIntoRecyclerView(arrayListIsChecked, mobileDao)
//            }
//        }
//
//    }
//
//    private fun setupListOfDateIntoRecyclerView(
//        listOfModels: ArrayList<MobileEntity>,
//        mobileDao: MobileDao
//    ){
//        val itemAdepter = ModelItemAdepter(
//            listOfModels,
//            { id, toCheck -> changeCheckMark(id, toCheck, mobileDao) },
//            { id -> isSelected(id, mobileDao)  }
//        )
//
//        binding.rvModels.layoutManager = LinearLayoutManager(this)
//        binding.rvModels.adapter = itemAdepter
//    }
//
//    private fun changeCheckMark(id: Int, toCheck: Int, mobileDao: MobileDao){
//
//        if (toCheck == R.drawable.ic_heart) {
//            lifecycleScope.launch {
//                mobileDao.updateIsCheckedById(id, R.drawable.ic_heart2)
//            }
//        } else if (toCheck == R.drawable.ic_heart2) {
//            lifecycleScope.launch {
//                mobileDao.updateIsCheckedById(id, R.drawable.ic_heart)
//                val show = Toast.makeText(
//                    this@FavoritesActivity,
//                    "You delete from favourites",
//                    Toast.LENGTH_SHORT
//                ).show()
//            }
//        }
//
//    }
//
//    private fun isSelected(id: Int, mobileDao: MobileDao){
//
//        val intent = Intent(this, ExpandedModelFragment::class.java)
//
//        lifecycleScope.launch {
//            mobileDao.updateIsSelectedById(id, true)
//            startActivity(intent)
//        }
//
//    }

}