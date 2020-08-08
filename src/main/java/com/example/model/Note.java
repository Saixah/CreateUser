package com.example.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "Note")
public class Note {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private long id;
	@Column
	private String title;
	@Column
	private String body;
	
	@OneToOne(fetch=FetchType.EAGER, targetEntity=Category.class, cascade=CascadeType.ALL)
	private Category category;
	
	public Note() {
		super();
	}
	public Note(long id, String title, String body, Category category) {
		super();
		this.id = id;
		this.title = title;
		this.body = body;
		this.category = category;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
}
