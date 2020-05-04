package com.catchecho.bstore.daoImpl;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.catchecho.bstore.dao.BookDAO;
import com.catchecho.bstore.entity.Book;

@Repository
@Transactional
public class BookDAOImpl implements BookDAO {

	@Autowired
	HibernateTemplate htemp;
	
	@Override
	public List<Book> getAllBooks() {
		System.out.println("getAllBooks()");
		return htemp.loadAll(Book.class);
	}

	@Override
	public List<Book> getAllBooks(int start, int total) {
		System.out.println("getAllBooks(start,total)");
		DetachedCriteria dc=DetachedCriteria.forClass(Book.class);
		return (List<Book>)htemp.findByCriteria(dc, start, total);
	}

	@Override
	public Book getBookById(Integer bid) {
		System.out.println("getBookById()");
		return htemp.load(Book.class,bid,LockMode.READ);
	}

	@Override
	public void addBook(Book book) {
		System.out.println("addBook()");
		htemp.save(book);
	}

	@Override
	public void updateBook(Book book) {
		System.out.println("updateBook()");
		htemp.update(book);
	}

	@Override
	public void deleteBook(Integer bid) {
		System.out.println("deleteBook()");
		Book book=htemp.get(Book.class,bid);
		if(book!=null)
		htemp.delete(book);
	}

	@Override
	public int getBookCount() {
		System.out.println("getBookCount()");
		SessionFactory sf=htemp.getSessionFactory();
		Session session=sf.openSession();
		String sql="select count(*) from mybooks";
		BigInteger big=(BigInteger)session.createNativeQuery(sql).uniqueResult();
		return big.intValue();
	}

	
}
