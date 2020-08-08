package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.NotesDao;
import com.example.interfaces.NotesRepo;
import com.example.model.Note;

@Service("noteService")
@Transactional
public class NoteService implements NotesRepo {

	@Autowired
	private NotesDao noteDao;

	@Override
	public void saveNote(Note note) {
		noteDao.saveNote(note);
	}

	@Override
	public void deleteNoteById(int id) {
		noteDao.deleteNoteById(id);
		
	}

	@Override
	public List<Note> findAllNotes(int id) {
		return noteDao.findAllNotes(id);
	}

	@Override
	public Note findById(int id) {
		return noteDao.findById(id);
	}

	@Override
	public void updateNote(Note note) {
		noteDao.updateNote(note);
		
	}
	
	
}
