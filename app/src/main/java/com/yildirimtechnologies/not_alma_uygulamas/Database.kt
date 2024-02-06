package com.yildirimtechnologies.not_alma_uygulamas

import com.yildirimtechnologies.not_alma_uygulamas.Notlar

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Notlar::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}