package com.mosjak.snackbar.presentation.main.home

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.mosjak.snackbar.presentation.common.SingleLiveEvent

class HomeViewModel @ViewModelInject constructor(
  @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

  private val _listRequested: SingleLiveEvent<Any> =
    SingleLiveEvent()

  internal val listRequested: LiveData<Any> =
    _listRequested

  fun onNavigateClicked() = _listRequested.post()

}
