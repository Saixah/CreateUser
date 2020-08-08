package com.example.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.example.interfaces.NotesRepo;
import com.example.model.Note;

@Repository("notesDao")
public class NotesDao extends HibernateDao implements NotesRepo{

	@Override
	public void saveNote(Note note) {
		persist(note);
	}

	@Override
	public void deleteNoteById(int id) {
		Query query = getSession().createSQLQuery("DELETE FROM Note WHERE id = :id");
		query.setLong("id", id);
		query.executeUpdate();
		
	}

	@Override
	public List<Note> findAllNotes(int id) {
		Criteria criteria = getSession().createCriteria(Note.class);
		return (List<Note>) criteria.list();
	}

	@Override
	public Note findById(int id) {
		Criteria criteria = getSession().createCriteria(Note.class);
        criteria.add(Restrictions.eq("id",id));
        return (Note) criteria.uniqueResult();
	}

	@Override
	public void updateNote(Note note) {
		getSession().update(note);
		
	}

}
