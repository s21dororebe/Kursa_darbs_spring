package lv.venta.kursa_darbs_spring.models;

import java.security.MessageDigest;

public class User extends Person {
	private String encodedPassword;
	private String email;
	private String username;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String inputUsername) {
		if(inputUsername != null && inputUsername.matches("[a-z0-9.]{8,20}")) {
			username = inputUsername;
		}
		else {
			username = "default.user";
		}
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String inputEmail) {
		if(inputEmail != null && inputEmail.matches("[a-z]+[0-9]{2}[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+[a-z$]")) {
			email = inputEmail;
		}
		else {
			
			email = "default.email";
		}
	}

	public String getEncodedPassword() {
		return encodedPassword;
	}
	public void setEncodedPassword(String inputEncodedPassword) {
		if(inputEncodedPassword != null && inputEncodedPassword.matches("[A-Za-z0-9]{8,20}")) {
			try {
				MessageDigest md = MessageDigest.getInstance("MD5");
				md.update(inputEncodedPassword.getBytes());
				encodedPassword = new String(md.digest());	
			}
			catch (Exception e) {
				encodedPassword = "defaultPassword";
				}
			}
		else {
			encodedPassword = "defaultPassword";
		}
	}
	
	public User() {
		super();
		setUsername("default.user");
		setEncodedPassword("defaultPassword");
		setEmail("default.email");
	}
	public User(String name, String surname, String username, String password) {
		super();
		setUsername(username);
		setEncodedPassword(password);
		setEmail(email);
	}
	public String toString() {
		return "" + super.toString() + " " + email + " " + username;
	}

/*	public void signUp() throws Exception {
		//check if user with the same email or username exists
		for(User temp : MainService.allUsers){
			if(temp.getUsername().equals(username)){
				throw new Exception("User with this username already exists");
			} else if (temp.getEmail().equals(email)){
				throw new Exception("User with this email already exists");
			}
		}

		if(username == null) {
			throw (new Exception("Username is required"));
		} else if(encodedPassword == null) {
			throw (new Exception("Password is required"));
		} else if(email == null) {
			throw (new Exception("Email is required"));
		} else createUser(username, encodedPassword, email);
	}
	public boolean login() {
		for(User temp: MainService.allUsers) {
			if(temp.getUsername().equals(username)
					&& temp.getEncodedPassword().equals(encodedPassword)) {
				return true;
			}
		}
		return false;
	//TODO bookABook()
	//TODO ExtendExpiringDate()
	}*/

}
