package city.view;

public class PersonResponse {
	private String firstName;
	private String patronymic;
	private boolean registered;
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getPatronymic() {
		return patronymic;
	}
	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}
	public boolean isRegistered() {
		return registered;
	}
	public void setRegistered(boolean registered) {
		this.registered = registered;
	}
	
	@Override
	public String toString() {
		return registered+" "+firstName+" "+patronymic;
	}
	
}
