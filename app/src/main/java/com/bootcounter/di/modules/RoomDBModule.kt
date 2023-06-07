package com.bootcounter.di.modules

import android.app.Application
import androidx.room.Room
import com.bootcounter.database.BootCounterDB
import com.bootcounter.utils.Constants.DB_NAME
import dagger.Provides
import javax.inject.Singleton

class RoomDBModule {

    @Provides
    @Singleton
    fun syncedToolRoomDb(application: Application?): BootCounterDB? {
        return Room.databaseBuilder(application!!, BootCounterDB::class.java, DB_NAME)
            .build()
    }
}