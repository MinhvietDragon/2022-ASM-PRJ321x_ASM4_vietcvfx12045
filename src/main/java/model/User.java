package model;

/*
 * Dùng đối tượng user để xử lý đơn giản tài khoản nói chung
 * Còn xử lý đa dạng thì dùng AccountUser
 */
public class User {
	private String username;
	private String password;
	
	public User() {
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
