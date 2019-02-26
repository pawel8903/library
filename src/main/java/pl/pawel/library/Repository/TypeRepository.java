package pl.pawel.library.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import pl.pawel.library.entity.Type;

public interface TypeRepository extends Repository<Type, Integer> {

	public List<Type> saveAll(Iterable<Type> types);

}
