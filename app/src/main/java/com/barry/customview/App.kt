package com.barry.customview

import android.app.Application
import androidx.core.content.res.ResourcesCompat

class App : Application() {
        companion object {
        lateinit var instance: App
        val sColors: List<Int> by lazy {
        listOf(
            ResourcesCompat.getColor(instance.resources, R.color.color_red, null),
            ResourcesCompat.getColor(instance.resources, R.color.color_yellow, null),
            ResourcesCompat.getColor(instance.resources, R.color.color_green, null)
        )
        }
        }
        override fun onCreate() {
            super.onCreate()
            instance = this
        }
    }