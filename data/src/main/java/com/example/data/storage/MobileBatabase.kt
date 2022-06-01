package com.example.data.storage

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MobileEntity::class], version = 2)
abstract class MobileDatabase : RoomDatabase() {

    abstract fun mobileDao(): MobileDao

    companion object{

        @Volatile
        private var INSTANCE: MobileDatabase? = null

        fun getInstance(context: Context): MobileDatabase {

            synchronized(this){
                var instance = INSTANCE

                if (instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MobileDatabase::class.java,
                        "models-mobile"
                    ).fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }
                return instance

            }
        }

    }
}