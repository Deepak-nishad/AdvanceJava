package entities;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Students")
public class Students {
	@Id
	@Column(name = "sid")
	int sid;
	@Column(name = "ename")
	String ename;
	@Embedded
	Address address;

	public Students() {
		super();
	}

	public Students(int sid, String ename, Address address) {
		this.sid = sid;
		this.ename = ename;
		this.address = address;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Students [sid=" + sid + ", ename=" + ename + ", address=" + address + "]";
	}
	
	

}
