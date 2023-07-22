package guru.springframework.spring5webapp.domain;

import java.util.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Author {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String firstName;
	private String lastName;
	
	@ManyToMany(mappedBy="authors")
	private Set<Book> books;

	public Author(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
		this.books = new HashSet<>();
	}
}
