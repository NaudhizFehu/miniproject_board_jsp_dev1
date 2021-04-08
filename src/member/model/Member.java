package member.model;

import java.util.Date;

public class Member {

	private String id;
	private String name;
	private String password;
	private Date regDate;
	private String email;
	private String phoneNumber1;
	private String phoneNumber2;
	private String phoneNumber3;

	public Member(String id, String name, String password, Date regDate, String email, String phoneNumber1,
			String phoneNumber2, String phoneNumber3) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.regDate = regDate;
		this.email = email;
		this.phoneNumber1 = phoneNumber1;
		this.phoneNumber2 = phoneNumber2;
		this.phoneNumber3 = phoneNumber3;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public Date getRegDate() {
		return regDate;
	}

	public String getEmail() {
		return email;
	}

	public String getPhoneNumber1() {
		return phoneNumber1;
	}

	public String getPhoneNumber2() {
		return phoneNumber2;
	}

	public String getPhoneNumber3() {
		return phoneNumber3;
	}

	public boolean matchPassword(String pwd) {
		return password.equals(pwd);
	}

	public void changePassword(String newPwd) {
		this.password = newPwd;
	}

	public void changeEmail(String newEmail) {
		this.email = newEmail;
	}

	public void changePhoneNumber1(String newPhoneNumber1) {
		this.phoneNumber1 = newPhoneNumber1;
	}

	public void changePhoneNumber2(String newPhoneNumber2) {
		this.phoneNumber2 = newPhoneNumber2;
	}

	public void changePhoneNumber3(String newPhoneNumber3) {
		this.phoneNumber3 = newPhoneNumber3;
	}
}
