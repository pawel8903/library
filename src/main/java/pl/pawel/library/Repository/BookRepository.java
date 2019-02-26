package pl.pawel.library.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import pl.pawel.library.entity.Book;

public interface BookRepository extends Repository<Book, Integer>{
	
	public List<Book> saveAll(Iterable<Book> list);

	public List<Book> findAll();
}