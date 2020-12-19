package com.mosjak.snackbar.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mosjak.snackbar.data.model.ListItem

@Dao
interface ItemDao {

  @Query(
    value = "SELECT * FROM list_item"
  )
  fun observeItems(): LiveData<ListItem>

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun saveItem(model: ListItem)

  @Delete
  suspend fun removeItem(entity: ListItem): Int

  @Query(
    value = "DELETE FROM list_item"
  )
  suspend fun clearTable()

}
