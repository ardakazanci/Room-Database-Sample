package com.ardakazanci.roomdatabasecodelabs.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.ardakazanci.roomdatabasecodelabs.database.Word
import com.ardakazanci.roomdatabasecodelabs.database.WordRoomDatabase
import com.ardakazanci.roomdatabasecodelabs.repository.WordRepository
import kotlinx.coroutines.launch

class WordViewModel(application : Application) : AndroidViewModel(application){


    private val repository : WordRepository

    val allWords : LiveData<List<Word>>

    init {

        val wordDao = WordRoomDatabase.getDatabase(application).wordDao()
        repository = WordRepository(wordDao)
        allWords = repository.allwords
    }


    fun insert(word: Word) {

        viewModelScope.launch {
            repository.insert(word)
        }

    }

}