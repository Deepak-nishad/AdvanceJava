//package entities;
//
//import java.util.List;
//
//public class Emp {
//	int empid;
//	Name name;
//	List<String>emails;
//	
//	public Emp() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//	
//	public Emp(int empid, Name name, List<String> emails) {
//		this.empid = empid;
//		this.name = name;
//		this.emails = emails;
//	}
//
//	public int getEmpid() {
//		return empid;
//	}
//	public void setEmpid(int empid) {
//		this.empid = empid;
//	}
//	public Name getName() {
//		return name;
//	}
//	public void setName(Name name) {
//		this.name = name;
//	}
//	public List<String> getEmails() {
//		return emails;
//	}
//	public void setEmails(List<String> emails) {
//		this.emails = emails;
//	}
//
//	@Override
//	public String toString() {
//		return "Emp [empid=" + empid + ", name=" + name + ", emails=" + emails + "]";
//	}
//	
//	
//	
//	
//	
//
//}

package entities;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Emp {
	int empid;
	Name name;
	Address address;
	List<String> emails;

//	public Emp() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//	
//	public Emp(int empid, Name name, List<String> emails) {
//		this.empid = empid;
//		this.name = name;
//		this.emails = emails;
//	}
//
//	public int getEmpid() {
//		return empid;
//	}
//	public void setEmpid(int empid) {
//		this.empid = empid;
//	}
//	public Name getName() {
//		return name;
//	}
//	public void setName(Name name) {
//		this.name = name;
//	}
//	public List<String> getEmails() {
//		return emails;
//	}
//	public void setEmails(List<String> emails) {
//		this.emails = emails;
//	}

//	@Override
//	public String toString() {
//		return "Emp [empid=" + empid + ", name=" + name + ", emails=" + emails + "]";
//	}
//	

}
