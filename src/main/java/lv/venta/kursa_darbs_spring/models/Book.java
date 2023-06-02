package lv.venta.kursa_darbs_spring.models;

import java.time.LocalDate;

public class Book {
	private long generatedId;
	private static long idCounter = 0;
	private String title;
	private model.Author author;
	private BookGenre genre;
	private String description;
	private int quantity = 0;
	private LocalDate writingYear;
	
	// Constructors
	public Book(String title, model.Author author, BookGenre genre, String description, int quantity, LocalDate writingYear) throws Exception {
        setGeneratedId();
		setTitle(title);
		setAuthor(author);
		setGenre(genre);
		setDescription(description);
		setQuantity(quantity);
		setWritingYear(writingYear);
    }
	// Setters and Getters
	
	public long getGeneratedId() {
		return generatedId;
	}
	public void setGeneratedId() {
		this.generatedId = idCounter++;
	}

	public String getTitle() {
        return title;
    }
    public void setTitle(String title) throws Exception {
        if(title.length() > 0 && title.length() < 100){
            this.title = title;
        } else throw new Exception("Title cannot be empty");
    }
    
    public model.Author getAuthor() {
    	return author;
    }
    public void setAuthor(model.Author author) throws Exception {
        if(author != null)
            this.author = author;
        else throw new Exception("Invalid input author");
    }
    
    public BookGenre getGenre() {
        return genre;
    }
    public void setGenre(BookGenre genre) throws Exception {
        if(genre != null)
            this.genre = genre;
        else throw new Exception("Invalid input genre");
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) throws Exception {
        if(description.length() > 0 && description.length() < 1000){
            this.description = description;
        } else throw new Exception("Description cannot be empty");
    }
    
    public int getQuantity() {
    	return quantity;
    }
    public void setQuantity(int quantity) throws Exception {
    	if (quantity <= 99 && quantity > 0) {
            this.quantity = quantity;
        } else {
            throw new Exception("Invalid input quantity (it can be from 1 to 99)");
        }
    }

    public LocalDate getWritingYear() {
        return writingYear;
    }
    public void setWritingYear(LocalDate writingYear) throws Exception {
    	if (writingYear.isAfter(LocalDate.now())) {
            throw new Exception("Writing year cannot be in the future");
        }
        this.writingYear = writingYear;
    }

    @Override
    public String toString() {
        return "Book{" +
                " title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre=" + genre +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", writingYear=" + writingYear +
                '}';
    }
    
    
}
