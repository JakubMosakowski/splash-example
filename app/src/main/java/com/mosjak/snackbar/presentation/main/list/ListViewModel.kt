package com.mosjak.snackbar.presentation.main.list

import androidx.lifecycle.ViewModel
import com.mosjak.snackbar.data.repository.ItemRepository

class ListViewModel(
  private val repository: ItemRepository
) : ViewModel()
