package com.mosjak.snackbar.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.mosjak.snackbar.data.model.ItemModel

@Dao
interface ItemDao {

  @Query(
    value = "SELECT * FROM list_item"
  )
  fun observeItems(): LiveData<List<ItemModel>>

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun saveItem(model: ItemModel)

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun saveItems(list: List<ItemModel>)

  @Query(
    value = "DELETE FROM list_item WHERE toBeDeleted = 1"
  )
  suspend fun removeItems(): Int

  @Update(onConflict = OnConflictStrategy.REPLACE)
  suspend fun update(entity: ItemModel): Int

  @Query(
    value = "UPDATE list_item SET toBeDeleted = 0"
  )
  suspend fun clearFlags(): Int

  @Query(
    value = "DELETE FROM list_item"
  )
  suspend fun clearTable()

}
