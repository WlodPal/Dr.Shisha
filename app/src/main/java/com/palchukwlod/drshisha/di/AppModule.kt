package com.palchukwlod.drshisha.di

import android.app.Application
import androidx.room.Room
import com.palchukwlod.drshisha.data.database.MainDB
import com.palchukwlod.drshisha.data.repositories.CustomMixRepository
import com.palchukwlod.drshisha.data.repositories.CustomMixRepositoryImpl
import com.palchukwlod.drshisha.data.repositories.PartOfCustomMixRepository
import com.palchukwlod.drshisha.data.repositories.PartOfCustomMixRepositoryImpl
import com.palchukwlod.drshisha.utils.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMainDB(app: Application): MainDB {
        return Room.databaseBuilder(
            app,
            MainDB::class.java,
            DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideCustomMixRepo(db: MainDB): CustomMixRepository{
        return CustomMixRepositoryImpl(db.customMixDao)
    }

    @Provides
    @Singleton
    fun providePartOfCustomMixRepo(db: MainDB): PartOfCustomMixRepository{
        return PartOfCustomMixRepositoryImpl(db.partOfCustomMixDao)
    }

}