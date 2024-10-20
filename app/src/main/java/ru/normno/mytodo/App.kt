package ru.normno.mytodo

import android.app.Application
import ru.normno.mytodo.di.AppModule.initializeKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        initializeKoin(this@App)
    }
}