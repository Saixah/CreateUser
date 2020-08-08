package com.example.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.example.interfaces.CategoryRepo;
import com.example.model.Category;

@Repository("categoryDao")
public class CategoryDao extends HibernateDao implements CategoryRepo {

	@Override
	public void saveCategory(Category category) {
		persist(category);
		
	}

	@Override
	public void deleteCategoryById(int id) {
		Query query = getSession().createSQLQuery("DELETE FROM Category WHERE id = :id");
		query.setLong("id", id);
		query.executeUpdate();
		
	}

	@Override
	public List<Category> findAllCategory(int id) {
		Criteria criteria = getSession().createCriteria(Category.class);
		return (List<Category>) criteria.list();
	}

	@Override
	public Category findById(int id) {
		Criteria criteria = getSession().createCriteria(Category.class);
        criteria.add(Restrictions.eq("id",id));
        return (Category) criteria.uniqueResult();
	}

	@Override
	public void updateCategory(Category category) {
		getSession().update(category);
		
	}

}
