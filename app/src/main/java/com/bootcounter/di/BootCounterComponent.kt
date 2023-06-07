package com.bootcounter.di

import android.app.Application
import com.bootcounter.BootCounterApplication
import com.bootcounter.BootWorkManager
import com.bootcounter.di.modules.RoomDBModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidInjectionModule::class, RoomDBModule::class]
)
interface BootCounterComponent: AndroidInjector<BootCounterApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): BootCounterComponent
    }

    override fun inject(application: BootCounterApplication)

    fun injectBootWorker(bootWorkManager: BootWorkManager)
}