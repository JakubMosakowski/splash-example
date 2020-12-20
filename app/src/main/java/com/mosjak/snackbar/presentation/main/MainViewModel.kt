package com.mosjak.snackbar.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mosjak.snackbar.data.model.ItemModel
import com.mosjak.snackbar.data.repository.ItemRepository
import kotlinx.coroutines.launch

class MainViewModel(
  private val repository: ItemRepository
) : ViewModel() {

  fun reinitializeDatabase() = viewModelScope.launch {
    repository.clear()
    repository.insertItems(INITIAL_DATA)
  }

  companion object {
    private val INITIAL_DATA = (0..9L).map {
      ItemModel(it, "Item$it")
    }
  }

}
