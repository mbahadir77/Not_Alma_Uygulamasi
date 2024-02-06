package com.yildirimtechnologies.not_alma_uygulamas

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable

@Dao
interface UserDao {
    @Query("Select * From Notlar")
    fun getAll(): Flowable <List<Notlar>>

    @Insert
    fun insert(notlar: Notlar) : Completable

    @Delete
    fun delete(notlar: Notlar) : Completable
}