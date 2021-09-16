package fi.haagahelia.course;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.course.domain.*;

@SpringBootApplication
public class BookListApplication 
{
	private static final Logger log = LoggerFactory.getLogger(BookListApplication.class);

	public static void main(String[] args) 
	{
		SpringApplication.run(BookListApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository bRepository, CategoryRepository cRepository)
	{
		return (args) -> 
		{
			log.info("save a couple of books");
			cRepository.save(new Category("Category 1"));
			cRepository.save(new Category("Category 2"));
			cRepository.save(new Category("Category 3"));
			
			bRepository.save(new Book("Ernest Hemingway", "A Farawell to Arms", "1232323-21", "1929", cRepository.findByName("Category 1").get(0)));
			bRepository.save(new Book("George Orwell", "Animal Farm", "2212343-5", "1945", cRepository.findByName("Category 2").get(0) ));	
			
			log.info("fetch all books");
			for (Book book : bRepository.findAll())
			{
				log.info(book.toString());
			}
		};
	}
}
