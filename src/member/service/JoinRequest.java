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

	// ������ ģ �н����� �´��� Ȯ���ϴ� �޼���
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

	// ȸ������ �� �����ؾ��ϴ� ������ ����� �� ä���� �ִ��� Ȯ�� ���� ����ִ� ���� �ִٸ� �����߻�
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

	// ȸ�������� �� �ʿ��� ���� ����ִ��� Ȯ���ϴ� �޼���
	private void checkEmpty(Map<String, Boolean> errors, String value, String filedName) {
		if (value == null || value.isEmpty())
			errors.put(filedName, Boolean.TRUE);
	}

	// ��ȣ ����� �ƴѰ��(6~20��)
	private void checkPassword(Map<String, Boolean> errors, String value, String errorName) {

		if (value == null || value.isEmpty())
			return;

		if (value.length() < 6 || value.length() > 20) {
			errors.put(errorName, Boolean.TRUE);
		}
	}

	// �̸��� ����� �ƴѰ��
	private void checkEmail(Map<String, Boolean> errors, String value, String errorName) {

		if (value == null || value.isEmpty())
			return;

		// ����ǥ���� ���Ϲ��ڿ�(�̸�������)
		String regex = "\\w+@\\w+\\.\\w+(\\.\\w+)?";

		// ���ԽĿ� ��ġ
		boolean result = Pattern.matches(regex, value);

		if (result == false) {
			errors.put(errorName, Boolean.TRUE);
		}
	}

	// ��ȭ��ȣ ����� �ƴѰ��
	private void checkPhoneNumber(Map<String, Boolean> errors, String value1, String value2, String value3,
			String errorName) {

		if (value1 == null || value1.isEmpty() || value2 == null || value2.isEmpty() || value3 == null
				|| value3.isEmpty())
			return;

		// ����ǥ���� ���Ϲ��ڿ�(�޴�����ȣ)
		String regex = "^(010|011|016|017|018|019)[-\\s]?\\d{3,4}[-\\s]?\\d{4}$";

		// ��ȭ��ȣ
		String phone = value1 + "-" + value2 + "-" + value3;

		// ���ԽĿ� ��ġ
		boolean result = Pattern.matches(regex, phone);

		if (!result) {
			errors.put(errorName, Boolean.TRUE);
		}
	}

}
