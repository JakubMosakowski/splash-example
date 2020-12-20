package com.mosjak.snackbar.presentation.main.item

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.viewbinding.ViewBinding
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.binding.BindingViewHolder
import com.mikepenz.fastadapter.listeners.ClickEventHook
import com.mosjak.snackbar.data.model.ItemModel
import com.mosjak.snackbar.databinding.ItemBinding

class ItemEventHook(
  private val listener: (ItemModel) -> Unit) : ClickEventHook<Item>() {

  //region Bind

  inline fun <reified T : ViewBinding> ViewHolder.asBinding(): T? =
    when (this is BindingViewHolder<*> && binding is T) {
      true -> binding as T
      false -> null
    }

  override fun onBind(viewHolder: ViewHolder): View? =
    viewHolder
      .asBinding<ItemBinding>()
      ?.title

  //endregion

  //region Click

  override fun onClick(v: View, position: Int, fastAdapter: FastAdapter<Item>,
    item: Item) {

    // Invoke listener.
    listener.invoke(item.model)
  }

  //endregion
}

