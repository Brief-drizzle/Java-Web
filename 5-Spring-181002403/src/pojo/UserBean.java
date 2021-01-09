package pojo;


public class UserBean {
	private String username;
	private String password;
	private String email;
	private String telephone;
	private int    state;

	public UserBean() {
	}

	@Override
	public String toString() {
		return "UserBean{" +
				"username='" + username + '\'' +
				", pwd='" + password + '\'' +
				", email='" + email + '\'' +
				", telephone='" + telephone + '\'' +
				", state=" + state +
				'}';
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

}
