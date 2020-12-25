package com.mosjak.snackbar.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mosjak.snackbar.data.model.ItemModel

@Database(entities = [ItemModel::class], version = 1)
abstract class SnackbarDatabase : RoomDatabase() {
  abstract fun itemDao(): ItemDao
}
