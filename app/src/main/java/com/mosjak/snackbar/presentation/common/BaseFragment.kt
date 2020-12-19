package com.mosjak.snackbar.presentation.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel

abstract class BaseFragment<Binding : ViewDataBinding, VM : ViewModel> :
  Fragment(), SnackbarTrait {

  //region Traits

  override var snackbarTrait: View? = null

  //endregion

  //region UI

  @get:LayoutRes
  abstract val layoutRes: Int

  //endregion

  //region View Model

  abstract val viewModel: VM

  //endregion

  //region Binding

  protected open lateinit var binding: Binding

  abstract fun bindView(binding: Binding)

  //endregion

  //region Lifecycle

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

    // Create data binding component.

    // Inflate binding.
    binding = DataBindingUtil.inflate(
      inflater, layoutRes, container, false, null)

    // Attach lifecycle owner.
    binding.lifecycleOwner = this

    // Initialize binding.
    bindView(binding)

    // Return bound view.
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    // Search for snackbar trait view.
    snackbarTrait =
      view.findViewById(snackbarTraitViewId)
  }

  //endregion
}
