package com.mosjak.snackbar.presentation.main.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.mosjak.snackbar.NavGraphDirections
import com.mosjak.snackbar.R
import com.mosjak.snackbar.databinding.FragmentHomeBinding
import com.mosjak.snackbar.presentation.common.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

  //region Ui

  override val layoutRes: Int
    get() = R.layout.fragment_home

  //endregion

  //region View Model

  override val viewModel: HomeViewModel
    by viewModels()

  //endregion

  //region Binding

  override fun bindView(binding: FragmentHomeBinding) {
    binding
      .also { it.viewModel = viewModel }
  }

  //endregion

  //region Lifecycle

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    observeClick()
  }

  //endregion

  //region Item

  private fun observeClick() {

    viewModel
      .listRequested
      .observe(viewLifecycleOwner) { navigateToList() }
  }

  private fun navigateToList() {
    findNavController()
      .navigate(NavGraphDirections.actionList())
  }

  //endregion
}
