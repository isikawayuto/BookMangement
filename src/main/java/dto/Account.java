package dto;

public class Account {
	private String mail;
	private String name;
	private String salt;
	private String password;
	
	public Account(String mail, String name, String salt, String password) {
		super();
		this.name = name;
		this.mail = mail;
		this.salt = salt;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
