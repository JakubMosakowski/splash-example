package com.mosjak.snackbar.common.di

import com.mosjak.snackbar.presentation.main.MainViewModel
import com.mosjak.snackbar.presentation.main.edit.EditViewModel
import com.mosjak.snackbar.presentation.main.list.ListViewModel
import com.mosjak.snackbar.presentation.main.shared.DeleteViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

  viewModel { MainViewModel(get()) }
  viewModel { ListViewModel(get()) }
  viewModel { EditViewModel(get()) }
  viewModel { DeleteViewModel(get()) }
}
