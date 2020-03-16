package com.ardakazanci.roomdatabasecodelabs.repository

import androidx.lifecycle.LiveData
import com.ardakazanci.roomdatabasecodelabs.database.Word
import com.ardakazanci.roomdatabasecodelabs.database.WordDao

class WordRepository(private val wordDao: WordDao) {

    val allwords: LiveData<List<Word>> = wordDao.getAlphabetizedWords()

    suspend fun insert(word: Word) {
        wordDao.insert(word)
    }


}