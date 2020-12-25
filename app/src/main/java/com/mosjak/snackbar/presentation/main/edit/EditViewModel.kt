package com.mosjak.snackbar.presentation.main.edit

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.mosjak.snackbar.data.model.ItemModel
import com.mosjak.snackbar.data.repository.ItemRepository
import com.mosjak.snackbar.presentation.common.SingleLiveEvent
import kotlinx.coroutines.launch
import kotlin.random.Random

class EditViewModel @ViewModelInject constructor(
  private val repository: ItemRepository,
  @Assisted private val savedStateHandle: SavedStateHandle
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

  private val _snackbarRequested: SingleLiveEvent<ItemModel> =
    SingleLiveEvent()

  internal val snackbarRequested: LiveData<ItemModel> =
    _snackbarRequested
}
