package com.mosjak.snackbar.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mosjak.snackbar.data.model.ItemModel

@Database(entities = [ItemModel::class], version = 1)
abstract class SnackbarDatabase : RoomDatabase() {

  abstract fun itemDao(): ItemDao

  companion object {

    @Volatile
    private var INSTANCE: SnackbarDatabase? = null

    fun getDatabase(context: Context): SnackbarDatabase {
      return INSTANCE ?: synchronized(this) {
        val db = Room.databaseBuilder(
          context.applicationContext,
          SnackbarDatabase::class.java,
          "item_db"
        ).build()

        INSTANCE = db

        return db
      }
    }
  }
}
