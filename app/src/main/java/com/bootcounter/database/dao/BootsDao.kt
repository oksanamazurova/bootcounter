package com.bootcounter.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.bootcounter.database.entities.BootEvent

@Dao
interface BootsDao {

    @Query(
        ("SELECT * " +
                "FROM boots " +
                "ORDER BY timestamp")
    )
    suspend fun getBootEvents(): List<BootEvent>
}