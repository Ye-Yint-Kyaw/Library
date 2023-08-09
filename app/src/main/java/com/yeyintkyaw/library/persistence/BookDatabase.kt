package com.yeyintkyaw.library.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.yeyintkyaw.library.data.vos.BookListsVO
import com.yeyintkyaw.library.data.vos.BooksVO
import com.yeyintkyaw.library.persistence.daos.ListDao
import com.yeyintkyaw.library.persistence.typeconverters.BooksTypeConverter


@Database(
    entities = [
        BookListsVO::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(
    BooksTypeConverter::class
)

abstract class BookDatabase: RoomDatabase() {

    companion object{
        private const val DB_NAME = "BOOK_DB"
        var dbInstant: BookDatabase? = null

        fun getDBInstant(context: Context): BookDatabase?{
            when(dbInstant){
                null ->
                    dbInstant = Room.databaseBuilder(context, BookDatabase::class.java, DB_NAME)
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
            }
            return dbInstant
        }

    }
    abstract fun listDao(): ListDao
}