package com.mosjak.snackbar.presentation.main

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mosjak.snackbar.data.model.ItemModel
import com.mosjak.snackbar.data.repository.ItemRepository
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
  private val repository: ItemRepository,
  @Assisted private val savedStateHandle: SavedStateHandle
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
