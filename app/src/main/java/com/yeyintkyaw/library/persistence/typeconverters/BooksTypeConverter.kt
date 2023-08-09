package com.yeyintkyaw.library.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.yeyintkyaw.library.data.vos.BooksVO

class BooksTypeConverter {
    @TypeConverter
    fun toString(list: List<BooksVO>?): String{
        return Gson().toJson(list)
    }

    @TypeConverter
    fun toList(listGsonString: String): List<BooksVO>?{
        val listType = object : TypeToken<List<BooksVO>?>(){}.type
        return  Gson().fromJson(listGsonString, listType)
    }
}