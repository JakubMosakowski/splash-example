package com.mosjak.snackbar.presentation.main.edit

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.navGraphViewModels
import com.mikepenz.fastadapter.adapters.GenericFastItemAdapter
import com.mosjak.snackbar.R
import com.mosjak.snackbar.data.model.ItemModel
import com.mosjak.snackbar.databinding.FragmentEditBinding
import com.mosjak.snackbar.presentation.common.BaseFragment
import com.mosjak.snackbar.presentation.main.item.Item
import com.mosjak.snackbar.presentation.main.item.ItemEventHook
import com.mosjak.snackbar.presentation.main.shared.DeleteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EditFragment : BaseFragment<FragmentEditBinding, EditViewModel>() {

  //region Ui

  override val layoutRes: Int
    get() = R.layout.fragment_edit

  //endregion

  //region View Model

  override val viewModel: EditViewModel
    by viewModels()

  private val deleteViewModel: DeleteViewModel
    by navGraphViewModels(R.id.nested_graph) { defaultViewModelProviderFactory }

  //endregion

  //region Binding

  override fun bindView(binding: FragmentEditBinding) {
    binding
      .also { it.viewModel = viewModel }
  }

  //endregion

  //region Lifecycle

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    initializeRecyclerView()
    initializeEventHooks()
    observeItems()
    observeSnackbar()
  }

  //endregion

  //region Item

  private fun List<ItemModel>.items(): List<Item> =
    map(::Item)

  private val itemAdapter: GenericFastItemAdapter
    by lazy { GenericFastItemAdapter() }

  private fun showItems(result: List<ItemModel>) {
    itemAdapter.setNewList(result.items())
  }

  private fun observeItems() {

    // Observe result.
    viewModel
      .items
      .observe(viewLifecycleOwner, ::showItems)
  }

  //endregion

  //region Recycler View

  private fun initializeRecyclerView() = with(binding.editListRv) {

    // Assign adapter to recycler view.
    adapter = itemAdapter
  }

  //endregion

  //region Snackbar

  private fun observeSnackbar() {

    viewModel
      .snackbarRequested
      .observe(viewLifecycleOwner) {
        showUndoDeleteSnackbar(
          deleteViewModel::onUndoClicked,
          deleteViewModel::onSnackbarDismissed
        )
      }
  }

  //endregion

  //region Event Hook

  private fun initializeEventHooks() {

    val eventHook = ItemEventHook(viewModel::itemClicked)

    // Initialize event hooks.
    itemAdapter
      .addEventHook(eventHook)
  }

  //endregion
}
