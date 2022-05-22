package com.example.ebstesttask

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MobileDao {

    @Insert
    suspend fun insert(mobileEntity: MobileEntity)

    @Query("UPDATE `models-mobile` SET isChecked=:isChecked WHERE id=:id")
    suspend fun updateIsCheckedById(id: Int, isChecked: Int)

    //TODO не работает запрос updateIsSelectedById()
    @Query("UPDATE `models-mobile` SET isSelected=:isSelected WHERE id=:id")
    suspend fun updateIsSelectedById(id: Int, isSelected: Boolean)

    @Query("select * from `models-mobile`")
    fun fetchAllMobiles(): Flow<List<MobileEntity>>

    @Query("select * from `models-mobile` where id=:id")
    fun fetchMobileById(id: Int): Flow<MobileEntity>

    @Query("select * from `models-mobile` where isChecked=:isChecked")
    fun fetchAllByIsChecked(isChecked: Int):  Flow<List<MobileEntity>>

    @Query("select * from `models-mobile` where isSelected=:isSelected")
    fun fetchMobileByIsSelected(isSelected: Boolean): Flow<MobileEntity>

}