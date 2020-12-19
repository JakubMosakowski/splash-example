package com.mosjak.snackbar.common.di

import com.mosjak.snackbar.data.db.SnackbarDatabase
import com.mosjak.snackbar.data.repository.ItemRepository
import org.koin.dsl.module

val repositoryModule = module {

  single { ItemRepository(get()) }
  single { SnackbarDatabase.getDatabase(get()).itemDao() }
}
