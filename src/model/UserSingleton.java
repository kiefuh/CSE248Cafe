package model;

public class UserSingleton {
	private static UserSingleton user;
	private static String username;
	
	private UserSingleton(String username) {
		this.username=username;
	}
	
	public static UserSingleton makeTheUser(String name) {
		if(user==null) {
			user= new UserSingleton(name);
		}
		else {
			UserSingleton.username=name;
		}
		return user;
	}
	
	public static String getUsername() {
		return username;
	}
	
	public static void setUsername(String username) {
		UserSingleton.username=username;
	}
	
}
