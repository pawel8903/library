package pl.pawel.library.service;

import java.io.IOException;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import pl.pawel.library.entity.Book;
import pl.pawel.library.entity.Type;

public interface BookTypeService {
	public void saveDataFile(MultipartFile filename) throws IOException;

	public List<Book> getBooks();

	public Book getBook(int theId);

	public void deleteBook(int theId);

	public void saveBook(Book book);

	public List<Type> getTypes();
}
