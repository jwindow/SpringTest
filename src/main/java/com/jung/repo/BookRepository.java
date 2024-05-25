package com.jung.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.jung.domain.Book;


@Repository
public class BookRepository {
	
	private final SessionFactory sessionFactory;
	
	public BookRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<Book> findAll(){
		
		EntityManager em=sessionFactory.createEntityManager();
		
		CriteriaBuilder cb=em.getCriteriaBuilder();
		CriteriaQuery<Book> cr = cb.createQuery(Book.class);
		
		Root<Book> root=cr.from(Book.class);
		
		cr.select(root);
		
		TypedQuery<Book> query=em.createQuery(cr);
		
		return query.getResultList();
	}
}
