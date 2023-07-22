package guru.springframework.spring5webapp.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String title;
	private String isbn;
	
	@ManyToMany
	@JoinTable(name="author_book", joinColumns= @JoinColumn(name="book_id"), 
			inverseJoinColumns = @JoinColumn(name="author_id"))
	private Set<Author> authors;

	public Book(String title, String isbn){
		this.title = title;
		this.isbn = isbn;
		this.authors = new HashSet<>();
	}
}
