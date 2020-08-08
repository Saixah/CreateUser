package com.example.interfaces;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.model.Note;

public interface NotesRepo {

	void saveNote(Note note);
	
	void deleteNoteById(int id);
	
	List<Note> findAllNotes(int id);
	
	Note findById(int id);
	
	void updateNote(Note note);
}
