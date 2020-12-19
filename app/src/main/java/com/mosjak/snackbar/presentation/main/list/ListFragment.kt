package com.mosjak.snackbar.presentation.main.list

import android.os.Bundle
import android.view.View
import com.mosjak.snackbar.R
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.mosjak.snackbar.databinding.FragmentListBinding
import com.mosjak.snackbar.presentation.common.BaseFragment

class ListFragment : BaseFragment<FragmentListBinding, ListViewModel>() {

  //region Ui

  override val layoutRes: Int
    get() = R.layout.fragment_list

  //endregion

  //region View Model

  override val viewModel: ListViewModel
    by viewModel()

  //endregion

  //region Binding

  override fun bindView(binding: FragmentListBinding) {
    binding
      .also { it.viewModel = viewModel }
  }

  //endregion

  //region Lifecycle

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
  }
}
