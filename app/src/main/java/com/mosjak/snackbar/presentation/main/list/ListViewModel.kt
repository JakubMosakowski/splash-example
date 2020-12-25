package com.mosjak.snackbar.presentation.main.list

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.mosjak.snackbar.data.model.ItemModel
import com.mosjak.snackbar.data.repository.ItemRepository
import com.mosjak.snackbar.presentation.common.SingleLiveEvent

class ListViewModel @ViewModelInject constructor(
  repository: ItemRepository,
  @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

  val items: LiveData<List<ItemModel>> =
    repository.observeItems()

  private val _editRequested: SingleLiveEvent<Any> =
    SingleLiveEvent()

  internal val editRequested: LiveData<Any> =
    _editRequested

  fun onNavigateClicked() = _editRequested.post()

  private val _homeRequested: SingleLiveEvent<Any> =
    SingleLiveEvent()

  internal val homeRequested: LiveData<Any> =
    _homeRequested

  fun onHomeClicked() = _homeRequested.post()

}
