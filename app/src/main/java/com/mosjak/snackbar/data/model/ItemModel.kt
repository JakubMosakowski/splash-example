package com.mosjak.snackbar.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "list_item")
data class ItemModel(
  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "id")
  val id: Long,

  val name: String,
  val toBeDeleted: Boolean = false
)
