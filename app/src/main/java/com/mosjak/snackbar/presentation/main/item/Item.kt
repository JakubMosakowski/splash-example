package com.mosjak.snackbar.presentation.main.item

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mikepenz.fastadapter.binding.ModelAbstractBindingItem
import com.mosjak.snackbar.R
import com.mosjak.snackbar.data.model.ItemModel
import com.mosjak.snackbar.databinding.ItemBinding

class Item(model: ItemModel) : ModelAbstractBindingItem<ItemModel, ItemBinding>(
  model) {

  //region Initialization

  init {

    // Define identifier.
    identifier = model.id
  }

  //endregion

  //region Type

  override val type: Int
    get() = R.id.item

  //endregion

  //region Binding

  override fun createBinding(inflater: LayoutInflater, parent: ViewGroup?)
    : ItemBinding = ItemBinding.inflate(inflater, parent, false)

  override fun bindView(binding: ItemBinding, payloads: List<Any>) {
    super.bindView(binding, payloads)

    // Update binding.
    updateBinding(binding)
  }

  private fun updateBinding(binding: ItemBinding) = with(binding) {

    itemText = model.name
    toBeDeleted = model.toBeDeleted
  }

  //endregion
}
