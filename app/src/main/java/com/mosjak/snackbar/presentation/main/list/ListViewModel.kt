package com.mosjak.snackbar.presentation.main.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.mosjak.snackbar.data.model.ItemModel
import com.mosjak.snackbar.data.repository.ItemRepository
import com.mosjak.snackbar.presentation.common.SingleLiveEvent

class ListViewModel(
  repository: ItemRepository
) : ViewModel() {

  val items: LiveData<List<ItemModel>> =
    repository.observeItems()

  private val _editRequested: SingleLiveEvent<Any> =
    SingleLiveEvent()

  internal val editRequested: LiveData<Any> =
    _editRequested

  fun onNavigateClicked() = _editRequested.post()

}
