package com.yildirimtechnologies.not_alma_uygulamas

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Notlar")
data class Notlar(
    @ColumnInfo(name = "Baslik")
    val baslik: String,

    @ColumnInfo(name = "Not")
    val not: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}