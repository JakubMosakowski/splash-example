package com.mosjak.snackbar.presentation.main.shared

import android.util.Log
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.mosjak.snackbar.data.repository.ItemRepository
import kotlinx.coroutines.launch

class DeleteViewModel @ViewModelInject constructor(
  private val repository: ItemRepository,
  @Assisted private val savedStateHandle: SavedStateHandle
) : SharedViewModel() {

  init {
    Log.v("KUBA", "ON INIT DeleteViewModel")
  }

  fun onUndoClicked() = viewModelScope.launch {
    repository.clearFlags()
  }

  fun onSnackbarDismissed() = viewModelScope.launch {
    repository.deleteItems()
  }

  override fun onCleared() {
    Log.v("KUBA", "ON CLEARED DeleteViewModel")
    super.onCleared()
  }
}
