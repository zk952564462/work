package com.example.work.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.work.entity.Book;
import com.example.work.repository.ReadingListRepository;



@Controller
@RequestMapping(value="/")
public class ReadingController {
	private ReadingListRepository r;
	@Autowired
	public ReadingController(ReadingListRepository r) {
		this.r=r;
	}
	
	@RequestMapping(value="/{reader}",method = RequestMethod.GET)
	public String readersBooks(@PathVariable("reader") String reader,Model model) {
		List<Book> list = r.findByReader(reader);
		if(list != null) {
			model.addAttribute("books",list);
		}
		return "readingList";
	}
	
	@RequestMapping(value="/{reader}",method = RequestMethod.POST)
	public String addBook(@PathVariable("reader") String reader,Book book) {
		book.setReader(reader);
		r.save(book);
		return "redirect:/{reader}";
	}
}
