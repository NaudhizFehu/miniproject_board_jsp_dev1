package member.service;

import java.util.Date;
import java.util.Map;
//회원가입 정보기입 및 값이 비어있는지 확인
public class JoinRequest {
 
	private String id;
	private String name;
	private String password;
	private String confirmPassword;
	private String email;
	private String phoneNumber1;
	private String phoneNumber2;
	private String phoneNumber3;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	//앞전에 친 패스워드 맞는지 확인하는 메서드
	public boolean isPasswordEqualToConfirm() {
		return password !=null && password.equals(confirmPassword);
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber1() {
		return phoneNumber1;
	}
	public void setPhoneNumber1(String phoneNumber1) {
		this.phoneNumber1 = phoneNumber1;
	}
	public String getPhoneNumber2() {
		return phoneNumber2;
	}
	public void setPhoneNumber2(String phoneNumber2) {
		this.phoneNumber2 = phoneNumber2;
	}
	public String getPhoneNumber3() {
		return phoneNumber3;
	}
	public void setPhoneNumber3(String phoneNumber3) {
		this.phoneNumber3 = phoneNumber3;
	}
	//회원가입 시 기입해야하는 값들이 제대로 다 채워져 있는지 확인 값이 비어있는 것이 있다면 에러발생
	public void validate(Map<String, Boolean>errors) {
		checkEmpty(errors,id,"id");
		checkEmpty(errors,name,"name");
		checkEmpty(errors,password,"password");
		checkEmpty(errors,confirmPassword,"confirmPassword");
		checkEmpty(errors,email,"email");
		checkEmpty(errors,phoneNumber1,"phoneNumber1");
		checkEmpty(errors,phoneNumber2,"phoneNumber2");
		checkEmpty(errors,phoneNumber3,"phoneNumber3");
		
		if(!errors.containsKey("cofirmPassword")) {
			if(!isPasswordEqualToConfirm()) {
				errors.put("wrongCurPw", Boolean.TRUE);
			}
		}
	}
	//회원가입할 때 필요한 값이 비어있는지 확인하는 메서드
	private void checkEmpty(Map<String, Boolean>errors,String value,String filedName) {
		if(value==null ||value.isEmpty())
			errors.put(filedName, Boolean.TRUE);
	}

	
}
