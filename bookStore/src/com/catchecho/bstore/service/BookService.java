package com.catchecho.bstore.service;

import java.util.List;

import com.catchecho.bstore.entity.Book;

public interface BookService {

	public List<Book> getAllBooks();
	public List<Book> getAllBooks(int start,int total);
	public Book getBookById(Integer bid);
	public void addBook(Book book);
	public void updateBook(Book book);
	public void deleteBook(Integer bid);
	public int getBookCount();
}
