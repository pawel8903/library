package pl.pawel.library.contoller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pl.pawel.library.entity.Book;
import pl.pawel.library.entity.Type;
import pl.pawel.library.service.BookTypeService;

@Controller()
@RequestMapping("book")
public class BookTypeController {
	
	@Autowired
	private BookTypeService bookTypeService;
	
	@RequestMapping("readFileForm")
	public String readFileForm() {
		return "read-file-form";
	}
	
	@PostMapping("/file")
	public String serveFile(@RequestParam("filename") MultipartFile filename, RedirectAttributes redirectAttributes) throws IOException {
		
		if(filename.isEmpty()) {
			redirectAttributes.addFlashAttribute("message","Please select file to upload");
			return "redirect:book-list";
		}
		
		bookTypeService.saveDataFile(filename);
		
		return "redirect:/book/booksList";
	}
	
	@RequestMapping("/booksList")
	public String listBooks(Model theModel) {
		List<Book> books = bookTypeService.getBooks();
		theModel.addAttribute("books", books);
		theModel.addAttribute("searchTerm", "");
		theModel.addAttribute("searchBy", "");
		return "book-list";
	}
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Book book = new Book();
		theModel.addAttribute("book", book);
		
		List<Type> types= bookTypeService.getTypes();
		theModel.addAttribute("types", types);
		
		return "book-form";
	}
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("bookId") int theId, Model theModel) {
			
			Book book = bookTypeService.getBook(theId);
			theModel.addAttribute("book",book);
			
			List<Type> types= bookTypeService.getTypes();
			theModel.addAttribute("types", types);
			
		return "book-form";
	}
	
	@GetMapping("/delete")
	public String deleteBook(@RequestParam("bookId") int theId) {
		bookTypeService.deleteBook(theId);
		return "redirect:/book/booksList";
	}
	
	@GetMapping("/saveBook")
	public String saveBook(@ModelAttribute("book") Book book,@RequestParam(value="type",required=false)List<Integer> typesId) {
		if(typesId != null) {
			for (Integer type : typesId) {
				Type typ = bookTypeService.getType(type);
				typ.addBook(book);
			}
		}
		
		bookTypeService.saveBook(book);
		return "redirect:/book/booksList";
	}
	
	@GetMapping("/search")
	public String searchBooksList(@RequestParam("searchTerm")String searchTerm,@RequestParam("searchBy")String searchBy,Model theModel) {
		
		List<Book> booksList = bookTypeService.findBySearchTerm(searchTerm,searchBy);
		theModel.addAttribute("books", booksList);
		theModel.addAttribute("searchTerm", searchTerm);
		theModel.addAttribute("searchBy", searchBy);
		return "book-list";
	}
}
