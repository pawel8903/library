package pl.pawel.library.contoller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pl.pawel.library.entity.Book;
import pl.pawel.library.service.StorageService;

@Controller("/admin")
public class FileUploadController {
	
	@Autowired
	private StorageService storeService;
	
	@PostMapping("/file")
	public String serveFile(@RequestParam("filename") MultipartFile filename, RedirectAttributes redirectAttributes) throws IOException {
		
		if(filename.isEmpty()) {
			redirectAttributes.addFlashAttribute("message","Please select file to upload");
			return "redirect:adminPage";
		}
		
		storeService.saveDataFile(filename);
		
		return "redirect:/admin/booksList";
	}
	
	@RequestMapping("/booksList")
	public String listBooks(Model theModel) {
		List<Book> books = storeService.getBooks();
		theModel.addAttribute("books", books);
		return "adminPage";
	}
}
