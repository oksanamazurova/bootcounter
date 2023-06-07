package com.bootcounter.database.entities

import android.provider.BaseColumns
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bootcounter.database.BootCounterDB

@Entity(tableName = BootCounterDB.Tables.BootTable)
class BootEvent {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = BaseColumns._ID)
    var bootNumber: Int? = null

    @JvmField
    @ColumnInfo(name = "timestamp")
    var timestamp: Long? = null
}