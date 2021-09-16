package fi.haagahelia.course.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import fi.haagahelia.course.domain.*;

@Controller
public class BookController
{
	@Autowired
	private BookRepository repository; 
	
	@Autowired
	private CategoryRepository cRepository; 
	
	// Show all books
    @RequestMapping(value= {"/", "/booklist"})
    public String bookList(Model model)
    {	
        model.addAttribute("book", repository.findAll());
        return "booklist";
    }

    // Add book
    @RequestMapping(value = "/add")
    public String addBook(Model model)
    {
    	model.addAttribute("book", new Book());
    	model.addAttribute("categories", cRepository.findAll());
        return "addbook";
    }     

    // Save book
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book)
    {
        repository.save(book);
        return "redirect:booklist";
    }    

    // Delete book
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long bookId, Model model)
    {
    	repository.deleteById(bookId);
        return "redirect:../booklist";
    }  
    
    // Edit book
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editBook(@PathVariable("id") Long bookId, Model model)
    {
    	model.addAttribute("book", repository.findById(bookId));
    	model.addAttribute("categories", cRepository.findAll());
    	return "editbook";
    }

}
