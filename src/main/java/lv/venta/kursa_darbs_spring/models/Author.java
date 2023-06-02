package lv.venta.kursa_darbs_spring.models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Author {
	private long generatedId;
	private static long idCounter = 0;
	private String name;
	private String surname;
	private LocalDate dateOfBirth;
	private LocalDate dateOfDeath;
	private ArrayList<Book> books;

	// Constructors
	public Author(String name, String surname, LocalDate dateOfBirth, LocalDate dateOfDeath, ArrayList<Book> books) throws Exception {
        setGeneratedId();
		setName(name);
        setSurname(surname);
        setDateOfBirth(dateOfBirth);
        setDateOfDeath(dateOfDeath);
        setBooks(books);
    }
	
	// Setters and Getters
	public long getGeneratedId() {
		return generatedId;
	}
	public void setGeneratedId() {
		this.generatedId = idCounter++;
	}
	
	public String getName() {
        return name;
    }
    public void setName(String name) throws Exception {
    	if (name != null && name.matches("^[A-Z][a-zA-Z]{2,49}$")) {
            this.name = name;
        } else throw new Exception("Invalid input name");
    }
    
    public String getSurname() {
        return name;
    }
    public void setSurname(String surname) throws Exception {
    	if (surname != null && surname.matches("^[A-Z][a-zA-Z]{2,49}$")) {
            this.surname = surname;
        } else throw new Exception("Invalid input name");
    }
    
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(LocalDate dateOfBirth) throws Exception {
        if (dateOfBirth != null && dateOfBirth.isBefore(LocalDate.now())) {
            this.dateOfBirth = dateOfBirth;
        } else throw new Exception("Invalid input date of birth");
    }

    public LocalDate getDateOfDeath() {
        return dateOfDeath;
    }
    public void setDateOfDeath(LocalDate dateOfDeath) throws Exception {
        if (dateOfDeath != null && dateOfDeath.isBefore(LocalDate.now())) {
            this.dateOfDeath = dateOfDeath;
        } else throw new Exception("Invalid input date of birth");
    }
    
    public ArrayList<Book> getBooks() {
        return books;
    }
    public void setBooks(ArrayList<Book> books) throws Exception {
        if(books != null)
            this.books = books;
        else throw new Exception ("Invalid input books array list");
    }
    
    @Override
    public String toString() {
        return "Author{" +
                " name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", dateOfDeath=" + dateOfDeath +
                ", books=" + books +
                '}';
    }
    
}
