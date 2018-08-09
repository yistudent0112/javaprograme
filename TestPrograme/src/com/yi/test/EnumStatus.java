package com.yi.test;

public enum EnumStatus {
	SUCCESS("1", "³É¹¦"), FAIL("2", "Ê§°Ü");
	private String number;
	private String value;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	private EnumStatus(String number, String value) {
		this.number = number;
		this.value = value;
	}

	public static void main(String[] args) {
		System.out.println(EnumStatus.SUCCESS.number);
		System.out.println(EnumStatus.SUCCESS.value);
		System.out.println(EnumStatus.FAIL.number);
		System.out.println(EnumStatus.FAIL.value);
	}
}
