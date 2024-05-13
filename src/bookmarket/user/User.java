package bookmarket.user;

public abstract class User {
	private String id = "asd8449";
	private String pw = "asd8449";
	
	public boolean login(String id, String pw) {
		return this.id.equals(id) && this.pw.equals(pw);
	}
}