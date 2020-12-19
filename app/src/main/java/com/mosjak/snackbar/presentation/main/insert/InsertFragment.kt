package com.mosjak.snackbar.presentation.main.insert

import android.os.Bundle
import android.view.View
import com.mosjak.snackbar.R
import com.mosjak.snackbar.databinding.FragmentInsertBinding
import com.mosjak.snackbar.presentation.common.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class InsertFragment : BaseFragment<FragmentInsertBinding, InsertViewModel>() {

  //region Ui

  override val layoutRes: Int
    get() = R.layout.fragment_insert

  //endregion

  //region View Model

  override val viewModel: InsertViewModel
    by viewModel()

  //endregion

  //region Binding

  override fun bindView(binding: FragmentInsertBinding) {
    binding
      .also { it.viewModel = viewModel }
  }

  //endregion

  //region Lifecycle

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
  }
}
