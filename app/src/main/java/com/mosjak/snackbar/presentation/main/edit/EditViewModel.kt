package com.mosjak.snackbar.presentation.main.edit

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mosjak.snackbar.data.model.ItemModel
import com.mosjak.snackbar.data.repository.ItemRepository
import com.mosjak.snackbar.presentation.common.SingleLiveEvent
import kotlinx.coroutines.launch
import kotlin.random.Random

class EditViewModel(
  private val repository: ItemRepository
) : ViewModel() {

  val items: LiveData<List<ItemModel>> =
    repository.observeItems()

  fun insertClicked() = viewModelScope.launch {
    repository.insertItem(ItemModel(0, "Item ${Random.nextLong()}"))
  }

  fun itemClicked(itemModel: ItemModel) = viewModelScope.launch {
    repository.setToBeDeleted(itemModel, true)
    _snackbarRequested.postValue(itemModel)
  }

  fun onUndoClicked() = viewModelScope.launch {
    repository.clearFlags()
  }

  fun onSnackbarDismissed() = viewModelScope.launch {
    repository.deleteItems()
  }

  private val _snackbarRequested: SingleLiveEvent<ItemModel> =
    SingleLiveEvent()

  internal val snackbarRequested: LiveData<ItemModel> =
    _snackbarRequested
}
