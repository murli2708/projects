package com.catchecho.bstore.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.catchecho.bstore.entity.Book;
import com.catchecho.bstore.service.BookService;

@Controller
@SessionAttributes("MyBookList")
public class BookController {

	@Autowired
	BookService bookService;
	
	int start=0;
	int end=5;
	int totalDisplay=5;
	int totalBooks;
	
	private void showFirstPage(Model model) {
		start=0;
		end=5;
		totalDisplay=5;
		totalDisplay=(int)bookService.getBookCount();
		
		model.addAttribute("FROM",start+1);
		model.addAttribute("TO",end);
		model.addAttribute("TotalBooks",totalBooks);
		
		model.addAttribute("ShowPrevious","FALSE");
		model.addAttribute("ShowNext","TRUE");
		
	}
	@GetMapping("/showAllBooks")
	public String showBookList(Model model) {
		System.out.println("showBookList()");
		
		List<Book> blist=bookService.getAllBooks(start,totalDisplay);
		model.addAttribute("MyBookList",blist);
		showFirstPage(model);
		return "bookList";
	}
	
	@GetMapping("/nextBooks")
	public String showNextBooks(Model model) {
		System.out.println("showNextBooks()");
		start=start+totalDisplay;
		if(start<=0) {
			start=0;
			model.addAttribute("ShowPrevious","FALSE");
		}
		else {
			model.addAttribute("ShowPrevious","TRUE");
		}
		model.addAttribute("FROM",start+1);
		
		end=end+totalDisplay;
		if(end>=totalBooks) {
			model.addAttribute("TO",totalBooks);
			model.addAttribute("ShowNext","FALSE");
		}else {
			model.addAttribute("TO",end);
			model.addAttribute("ShowNext","TRUE");
		}
		List<Book> blist=bookService.getAllBooks(start,totalDisplay);
		model.addAttribute("MyBookList",blist);
		model.addAttribute("TotalBooks",totalBooks);
		return "bookList";

	}
	
	
	@GetMapping("/previousBooks")
	public String showPreviousBooks(Model model) {
		System.out.println("showPreviousBooks()");
		start=start-totalDisplay;
		if(start<=0) {
			start=0;
			model.addAttribute("ShowPrevious","FALSE");
		}
		else {
			model.addAttribute("ShowPrevious","TRUE");
		}
		model.addAttribute("FROM",start+1);
		
		end=end-totalDisplay;
		if(end>=totalBooks) {
			model.addAttribute("TO",totalBooks);
			model.addAttribute("ShowNext","FALSE");
		}else {
			model.addAttribute("TO",end);
			model.addAttribute("ShowNext","TRUE");
		}
		List<Book> blist=bookService.getAllBooks(start,totalDisplay);
		model.addAttribute("MyBookList",blist);
		model.addAttribute("TotalBooks",totalBooks);
		return "bookList";
	}
	
	@PostMapping("/addEditBookForm")
	public String addBookForm(@RequestParam("bookId")Integer bookId,Model model) {
		System.out.println("addBookForm()");
		System.out.println(bookId);
		Book book=new Book();
		String opType="ADD";
		if(bookId!=0) {
			book=bookService.getBookById(bookId);
			opType="UPDATE";
		}
		model.addAttribute("mybook",book);
		model.addAttribute("OpType",opType);
		showFirstPage(model);
		
		return "addEditBook";
	}
	
	@PostMapping("/saveUpdateBook")
	public String saveUpdateBook(@ModelAttribute("mybook")Book book,BindingResult result,Model model,HttpServletRequest req) {
		System.out.println("saveUpdateBook()");
		String opType=req.getParameter("OpType");
		System.out.println(opType);
		if(opType.equals("ADD")) {
			bookService.addBook(book);
		}
		if(opType.equals("UPDATE")) {
			bookService.updateBook(book);
		}
		List<Book> blist=bookService.getAllBooks(start,totalDisplay);
		model.addAttribute("MyBookList",blist);
		showFirstPage(model);
		return "bookList";
	}
	
	@GetMapping("/viewBook")
	public String viewBook(@RequestParam("bookId")String bookId,Model model) {
		System.out.println("viewBook()");
		System.out.println(bookId);
		Book book=bookService.getBookById(Integer.parseInt(bookId));
		model.addAttribute("MyBook",book);
		showFirstPage(model);
		return "viewBook";
	}
	
}
