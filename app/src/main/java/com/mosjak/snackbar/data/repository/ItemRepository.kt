package com.mosjak.snackbar.data.repository

import androidx.lifecycle.LiveData
import com.mosjak.snackbar.data.db.ItemDao
import com.mosjak.snackbar.data.model.ItemModel

class ItemRepository(
  private val dao: ItemDao
) {

  fun observeItems(): LiveData<List<ItemModel>> =
    dao.observeItems()

  suspend fun insertItem(item: ItemModel) =
    dao.saveItem(item)

  suspend fun insertItems(list: List<ItemModel>) =
    dao.saveItems(list)

  suspend fun deleteItems() =
    dao.removeItems()

  suspend fun clearFlags() =
    dao.clearFlags()

  suspend fun setToBeDeleted(item: ItemModel, toBeDeleted: Boolean) =
    dao.update(item.copy(toBeDeleted = toBeDeleted))

  suspend fun clear() =
    dao.clearTable()
}
