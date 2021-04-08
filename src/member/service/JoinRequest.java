package member.service;

import java.util.Date;
import java.util.Map;
import java.util.regex.Pattern;

//ȸ������ �������� �� ���� ����ִ��� Ȯ��
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

	// 비밀번호와 확인 비빌번호의 내용이 같은지 검사 
	public boolean isPasswordEqualToConfirm() {
		return password != null && password.equals(confirmPassword);
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

	// 정보입력구간의 오류검사
	public void validate(Map<String, Boolean> errors) {
		checkEmpty(errors, id, "blankId");
		checkEmpty(errors, name, "blankName");
		checkEmpty(errors, password, "blankPassword");
		checkPassword(errors, password, "notPassword");
		checkEmpty(errors, confirmPassword, "blankConfirmPassword");
		checkEmpty(errors, email, "blankEmail");
		checkEmail(errors, email, "notEmail");
		checkEmpty(errors, phoneNumber1, "blankPhoneNumber1");
		checkEmpty(errors, phoneNumber2, "blankPhoneNumber2");
		checkEmpty(errors, phoneNumber3, "blankPhoneNumber3");
		checkPhoneNumber(errors, phoneNumber1, phoneNumber2, phoneNumber3, "notPhoneNumber");

		if (!errors.containsKey("confirmPassword")) {
			if (!isPasswordEqualToConfirm()) {
				errors.put("notMatch", Boolean.TRUE);
			}
		}
	}

	// 입력내용중 빈공간이 있는지 검사
	private void checkEmpty(Map<String, Boolean> errors, String value, String filedName) {
		if (value == null || value.isEmpty())
			errors.put(filedName, Boolean.TRUE);
	}

	// 비밀번호 양식 검사(6~20자)
	private void checkPassword(Map<String, Boolean> errors, String value, String errorName) {

		if (value == null || value.isEmpty())
			return;

		if (value.length() < 6 || value.length() > 20) {
			errors.put(errorName, Boolean.TRUE);
		}
	}

	// 이메일 양식 검사
	private void checkEmail(Map<String, Boolean> errors, String value, String errorName) {

		if (value == null || value.isEmpty())
			return;

		// 정규식 - 이메일 양식(구조)검사(유효한 이메일인지는 검사하지 않음)
		String regex = "\\w+@\\w+\\.\\w+(\\.\\w+)?";

		// 양식에 맞는지 검사
		boolean result = Pattern.matches(regex, value);

		if (result == false) {
			errors.put(errorName, Boolean.TRUE);
		}
	}

	// 전화번호 양식 검사
	private void checkPhoneNumber(Map<String, Boolean> errors, String value1, String value2, String value3,
			String errorName) {

		if (value1 == null || value1.isEmpty() || value2 == null || value2.isEmpty() || value3 == null
				|| value3.isEmpty())
			return;

		// 정규식 - 전화번호 양식 검사(휴대전화 기준으로 작성)
		String regex = "^(010|011|016|017|018|019)[-\\s]?\\d{3,4}[-\\s]?\\d{4}$";

		// 검사할 value값을 하나로 합침
		String phone = value1 + "-" + value2 + "-" + value3;

		// 양식에 맞는지 검사
		boolean result = Pattern.matches(regex, phone);

		if (result == false) {
			errors.put(errorName, Boolean.TRUE);
		}
	}

}
