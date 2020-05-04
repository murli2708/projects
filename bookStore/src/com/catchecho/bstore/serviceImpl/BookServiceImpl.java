package com.catchecho.bstore.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catchecho.bstore.dao.BookDAO;
import com.catchecho.bstore.entity.Book;
import com.catchecho.bstore.service.BookService;
@Service
public class BookServiceImpl implements BookService{

	@Autowired
	BookDAO bookDao;
	
	
	
	@Override
	public List<Book> getAllBooks() {
		System.out.println("BookServiceImpl--getAllBooks");
		return bookDao.getAllBooks();
	}

	@Override
	public List<Book> getAllBooks(int start, int total) {
		System.out.println("BookServiceImpl--getAllBooks(start,total)");
		return bookDao.getAllBooks(start, total);
	}

	@Override
	public Book getBookById(Integer bid) {
		System.out.println("BookServiceImpl--getBookById");
		return bookDao.getBookById(bid);
	}

	@Override
	public void addBook(Book book) {
		System.out.println("BookServiceImpl--addBook");
		bookDao.addBook(book);
		
		
		
		
	}

	@Override
	public void updateBook(Book book) {
		System.out.println("BookServiceImpl--updateBook");
		bookDao.addBook(book);
	}

	@Override
	public void deleteBook(Integer bid) {
		System.out.println("BookServiceImpl--deleteBook");
		bookDao.deleteBook(bid);
	}

	@Override
	public int getBookCount() {
		System.out.println("BookServiceImpl--getBookCount");
		return bookDao.getBookCount();
	}

}
