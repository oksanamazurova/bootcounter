package com.bootcounter.database

import androidx.room.Database
import androidx.room.InvalidationTracker
import androidx.room.RoomDatabase
import com.bootcounter.database.dao.BootsDao
import com.bootcounter.database.entities.BootEvent

@Database(entities = [BootEvent::class], version = 1)
abstract class BootCounterDB : RoomDatabase() {

    interface Tables {
        companion object {
            const val BootTable = "boots"
        }
    }

    abstract fun bootsDao(): BootsDao?

    override fun createInvalidationTracker(): InvalidationTracker {
        TODO("Not yet implemented")
    }

    override fun clearAllTables() {
        TODO("Not yet implemented")
    }
}