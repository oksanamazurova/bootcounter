package com.bootcounter

import com.bootcounter.di.BootCounterComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class BootCounterApplication : DaggerApplication() {

    private val bootCounterComponent: BootCounterComponent = DaggerBootCounterComponent.builder()
        .application(this)
        .build()

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return bootCounterComponent
    }
}