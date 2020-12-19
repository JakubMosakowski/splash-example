package com.mosjak.snackbar.data.repository

import androidx.lifecycle.LiveData
import com.mosjak.snackbar.data.db.ItemDao
import com.mosjak.snackbar.data.model.ListItem

class ItemRepository(
  private val dao: ItemDao
) {

  fun observeItems(): LiveData<ListItem> =
    dao.observeItems()

  suspend fun insertItem(item: ListItem) =
    dao.saveItem(item)

  suspend fun removeItem(item: ListItem) =
    dao.removeItem(item)

  suspend fun clear() =
    dao.clearTable()
}
