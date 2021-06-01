package gogogo.entity;

/**
 * @author 86155
 */
public class User {
	private String userName;
	private String userPwd;
	private String userTel;
	private String userEmail;
	private String userHead;
	
	public User(){}
	
	public User(String userName, String userPwd) {
		this.userName = userName;
		this.userPwd = userPwd;
	}
	
	
	public User(String userName, String userPwd, String userTel, String userEmail) {
		this.userName = userName;
		this.userPwd = userPwd;
		this.userTel = userTel;
		this.userEmail = userEmail;
	}
	
	public User(String userName, String userPwd, String userTel, String userEmail, String userHead) {
		this.userName = userName;
		this.userPwd = userPwd;
		this.userTel = userTel;
		this.userEmail = userEmail;
		this.userHead = userHead;
	}
	

	public String getUserHead() {
		return userHead;
	}

	public void setUserHead(String userHead) {
		this.userHead = userHead;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	
}
