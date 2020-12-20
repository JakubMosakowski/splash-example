package com.mosjak.snackbar.presentation.main.shared

import androidx.lifecycle.viewModelScope
import com.mosjak.snackbar.data.repository.ItemRepository
import kotlinx.coroutines.launch

class DeleteViewModel(
  private val repository: ItemRepository
) : SharedViewModel() {

  fun onUndoClicked() = viewModelScope.launch {
    repository.clearFlags()
  }

  fun onSnackbarDismissed() = viewModelScope.launch {
    repository.deleteItems()
  }
}
