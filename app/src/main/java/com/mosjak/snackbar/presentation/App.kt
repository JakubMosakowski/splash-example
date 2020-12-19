package com.mosjak.snackbar.presentation

import android.app.Application
import com.mosjak.snackbar.common.di.repositoryModule
import com.mosjak.snackbar.common.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

  override fun onCreate() {
    super.onCreate()

    startKoin {
      androidContext(this@App)
      modules(listOf(repositoryModule, viewModelModule))
    }
  }
}
