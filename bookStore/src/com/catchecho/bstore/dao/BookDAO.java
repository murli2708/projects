package com.catchecho.bstore.dao;

import java.util.List;

import com.catchecho.bstore.entity.Book;

public interface BookDAO {

	public List<Book> getAllBooks();
	public List<Book> getAllBooks(int start,int total);
	public Book getBookById(Integer bid);
	public void addBook(Book book);
	public void updateBook(Book book);
	public void deleteBook(Integer bid);
	public int getBookCount();
}
