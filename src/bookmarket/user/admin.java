package bookmarket.user;

public class admin extends User {
	String code = "1234";
	
	
	public boolean access(String code) {
		return this.code.equals(code);
	}
}