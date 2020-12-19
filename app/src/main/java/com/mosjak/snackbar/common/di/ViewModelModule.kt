package com.mosjak.snackbar.common.di

import com.mosjak.snackbar.presentation.main.insert.InsertViewModel
import com.mosjak.snackbar.presentation.main.list.ListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

  viewModel { ListViewModel(get()) }
  viewModel { InsertViewModel(get()) }
}
