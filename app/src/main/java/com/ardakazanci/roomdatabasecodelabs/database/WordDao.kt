package com.ardakazanci.roomdatabasecodelabs.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface WordDao {

    // Alfabetik Sıralama işlemi
    @Query("SELECT * FROM word_table ORDER BY word ASC")
    fun getAlphabetizedWords(): LiveData<List<Word>>

    // 1 Adet Word nesnesinin eklenmesi
    // onConflict : Çatışma stratejisi.
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Word)
    // word_table tablosunu temizler.
    @Query("DELETE FROM word_table")
    suspend fun deleteAll()


}