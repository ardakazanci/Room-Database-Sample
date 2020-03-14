package com.ardakazanci.roomdatabasecodelabs.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Veritabanı için bir tabloyu temsil eder.
 */
@Entity(tableName = "word_table")
data class Word(
    @PrimaryKey
    @ColumnInfo(name = "word")
    val word: String
)