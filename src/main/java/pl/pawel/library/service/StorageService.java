package pl.pawel.library.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import pl.pawel.library.entity.Book;

public interface StorageService {
	public void saveDataFile(MultipartFile filename) throws IOException;

	public List<Book> getBooks();
}
