package lv.venta.kursa_darbs_spring.models;

public class Person {
	private String name;
	private String surname;
	private String personCode;

	public String getName() {
		return name;
	}
	
	public void setName(String inputName) {
		if(inputName != null && inputName.matches("[A-ZĒŪĪĀĻŅČŠŽ]{1}[a-zēīāūļžņš]+([ ][A-ZĒŪĪĀĻŅŠČŽ]{1}[a-zēīāūļžņš]+)?")) {
			name = inputName;
		}
		else {
			name = "Unknown";
		}
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String inputSurname) {
		if(inputSurname != null && inputSurname.matches("[A-ZĒŪĪĀĻŅČŠŽ]{1}[a-zēīāūļžņš]+([ ][A-ZĒŪĪĀĻŅŠČŽ]{1}[a-zēīāūļžņš]+)?")) {
			surname = inputSurname;
			}
		else {
			surname = "Unknown";
			}
	}
	
	public String getPersonCode() {
		return personCode;
	}
	
	public void setPersonCode(String inputPersonCode) {
		if(inputPersonCode != null && inputPersonCode.matches("[0-9]{6}[-][0-9]{5}")) {
			personCode = inputPersonCode;
		}
		else {
			personCode = "000000-00000";
		}
	}
	
	public Person() {
		setName("Unknown");
		setSurname("Unknown");
		setPersonCode("000000-00000");
	}
	
	public Person(String name, String surname, String personCode) {
		setName(name);
		setSurname(surname);
		setPersonCode(personCode);
	}

	public String toString() {
		return "" + name + " " + surname + " " + personCode;
	}
	
}
