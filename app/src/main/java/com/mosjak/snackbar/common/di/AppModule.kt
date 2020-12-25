package com.mosjak.snackbar.common.di

import android.content.Context
import androidx.room.Room
import com.mosjak.snackbar.data.db.ItemDao
import com.mosjak.snackbar.data.db.SnackbarDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideItemDao(appDatabase: SnackbarDatabase): ItemDao =
        appDatabase.itemDao()

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): SnackbarDatabase {
        return Room.databaseBuilder(
            appContext,
            SnackbarDatabase::class.java,
            "item_db"
        ).build()
    }
}
