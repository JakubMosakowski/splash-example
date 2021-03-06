package com.mosjak.snackbar.presentation.main.list

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.mikepenz.fastadapter.adapters.GenericFastItemAdapter
import com.mosjak.snackbar.NavGraphDirections
import com.mosjak.snackbar.R
import com.mosjak.snackbar.data.model.ItemModel
import com.mosjak.snackbar.databinding.FragmentListBinding
import com.mosjak.snackbar.presentation.common.BaseFragment
import com.mosjak.snackbar.presentation.main.item.Item
import org.koin.androidx.viewmodel.ext.android.viewModel

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

    initializeRecyclerView()
    observeItems()
    observeClick()
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

  private fun observeClick() {

    viewModel
      .editRequested
      .observe(viewLifecycleOwner) { navigateToEdit() }
  }

  private fun navigateToEdit() {
    findNavController()
      .navigate(NavGraphDirections.actionEdit())
  }

  //endregion

  //region Recycler View

  private fun initializeRecyclerView() = with(binding.mainListRv) {

    // Assign adapter to recycler view.
    adapter = itemAdapter
  }

  //endregion
}
