package com.example.notesapp.dao

import androidx.room.*
import com.example.notesapp.entities.Notes

@Dao
interface NoteDao {

    @Query("SELECT * FROM notes ORDER BY id DESC")
    suspend fun getAllNotes() : List<Notes>

    @Query("SELECT id FROM notes ORDER BY id DESC LIMIT 1")
    suspend fun getNoteId() : Int

    @Query("SELECT * FROM notes WHERE id =:id")
    suspend fun getSpecificNote(id:Int) : Notes

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNotes(note:Notes)

    @Delete
    suspend fun deleteNote(note:Notes)

    @Query("DELETE FROM notes WHERE id =:id")
    suspend fun deleteSpecificNote(id:Int)

    @Update
    suspend fun updateNote(note:Notes)
}