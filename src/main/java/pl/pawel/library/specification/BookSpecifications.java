package pl.pawel.library.specification;

import org.springframework.data.jpa.domain.Specification;

import pl.pawel.library.entity.Book;

public final class BookSpecifications {

	private BookSpecifications() {
	}

	public static Specification<Book> titleOrDescriptionOrAuthorContainsIgnoreCase(String searchTerm, String searchBy) {
		return (root, query, cb) -> {
			String containsLikePattern = getContainsLikePattern(searchTerm);

			if (searchBy != null) {
				String searchByToLowerCase= searchBy.toLowerCase();
				return cb.or(cb.like(cb.lower(root.get(searchByToLowerCase)), containsLikePattern));
			}
			return cb.or(cb.like(cb.lower(root.get("title")), containsLikePattern),
					cb.like(cb.lower(root.get("description")), containsLikePattern),
					cb.like(cb.lower(root.get("author")), containsLikePattern));
		};
	}

	private static String getContainsLikePattern(String searchTerm) {
		if (searchTerm == null || searchTerm.isEmpty()) {
			return "%";
		} else {
			return "%" + searchTerm.toLowerCase() + "%";
		}
	}

}
