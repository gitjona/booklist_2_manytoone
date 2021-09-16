package fi.haagahelia.course.domain;

import javax.persistence.*;

@Entity
public class Book
{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String author;
    private String title;
    private String isbn;
    private String year;
    
    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;

    public Book() {}

	public Book(String author, String title, String isbn, String year, Category category) 
	{
		super();
		this.author = author;
		this.title = title;
		this.isbn = isbn;
		this.year = year;
		this.category = category;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getAuthor()
	{
		return author;
	}

	public void setAuthor(String author)
	{
		this.author = author;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getIsbn()
	{
		return isbn;
	}

	public void setIsbn(String isbn)
	{
		this.isbn = isbn;
	}
	
	public String getYear()
	{
		return year;
	}

	public void setYear(String year)
	{
		this.year = year;
	}
	
	public Category getCategory()
	{
		return category;
	}

	public void setCategory(Category category)
	{
		this.category = category;
	}

	@Override
	public String toString()
	{
		if (this.category != null)
			return "Book [id=" + id + ", author=" + author + ", title=" + title + ", isbn=" + isbn + ", year=" + year + " category =" + this.getCategory() + "]";
		else
			return "Book [id=" + id + ", author=" + author + ", title=" + title + ", isbn=" + isbn + ", year=" + year + "]";
	}
}
