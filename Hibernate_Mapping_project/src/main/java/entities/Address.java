package entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class Address {
	@Column
	String area;
	@Column
	String city;
	@Column
	int pincode;
	public Address() {
		super();
	}
	
	public Address(String area, String city, int pincode) {
		this.area = area;
		this.city = city;
		this.pincode = pincode;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	
	
}
