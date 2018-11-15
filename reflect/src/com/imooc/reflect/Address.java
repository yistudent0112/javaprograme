package com.imooc.reflect;

import java.util.Objects;

public class Address {
	private int AddressId;
	private String AddressName;
	private String AddressLocation;
	private int AddressTel;

	public Address() {

	}

	public Address(int addressId, String addressName, String addressLocation, int addressTel) {
		super();
		AddressId = addressId;
		AddressName = addressName;
		AddressLocation = addressLocation;
		AddressTel = addressTel;
	}

	@Override
	public String toString() {
		return "Address [AddressId=" + AddressId + ", AddressName=" + AddressName + ", AddressLocation="
				+ AddressLocation + ", AddressTel=" + AddressTel + "]";
	}

	public int getAddressId() {
		return AddressId;
	}

	public void setAddressId(int addressId) {
		AddressId = addressId;
	}

	public String getAddressName() {
		return AddressName;
	}

	public void setAddressName(String addressName) {
		AddressName = addressName;
	}

	public String getAddressLocation() {
		return AddressLocation;
	}

	public void setAddressLocation(String addressLocation) {
		AddressLocation = addressLocation;
	}

	public int getAddressTel() {
		return AddressTel;
	}

	public void setAddressTel(int addressTel) {
		AddressTel = addressTel;
	}
    
	public void display() {
		System.out.println("this is an address");
	}
	private void info() {
		System.out.println("I am a private method");
	}
	private void equalsAddress(String name) {
		if(Objects.equals(name, AddressName)) {
			System.out.println("the address is same");
		}else {
			System.out.println("the address is not same");
		}
	}
}
