package com.mosjak.snackbar.presentation.main.edit

import android.os.Bundle
import android.view.View
import com.mikepenz.fastadapter.adapters.GenericFastItemAdapter
import com.mosjak.snackbar.R
import com.mosjak.snackbar.data.model.ItemModel
import com.mosjak.snackbar.databinding.FragmentEditBinding
import com.mosjak.snackbar.presentation.common.BaseFragment
import com.mosjak.snackbar.presentation.main.item.Item
import com.mosjak.snackbar.presentation.main.item.ItemEventHook
import org.koin.androidx.viewmodel.ext.android.viewModel

class EditFragment : BaseFragment<FragmentEditBinding, EditViewModel>() {

  //region Ui

  override val layoutRes: Int
    get() = R.layout.fragment_edit

  //endregion

  //region View Model

  override val viewModel: EditViewModel
    by viewModel()

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
          viewModel::onUndoClicked,
          viewModel::onSnackbarDismissed
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
