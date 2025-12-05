package entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Table(name="emp")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Emp {
	@Id
	int id;
	
	String ename;
	
	public Emp() {
		
	}
	public Emp(int id, String ename) {
		this.id = id;
		this.ename = ename;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	

	
}
