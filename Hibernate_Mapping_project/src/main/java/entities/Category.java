package entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

// master class
@Entity
@Table
public class Category {
	@Id
	@Column
	int cid;
	@Column
	String cname;
	@Column
	String cdesc;
	
	@OneToMany(mappedBy = "cid") //cid - name of property for FK column
	@Cascade(value= CascadeType.ALL)
	Set<Product>p;
	
	
	
	public Category() {
	super();
	}
	public Category(int cid, String cname, String cdesc) {
		this.cid = cid;
		this.cname = cname;
		this.cdesc = cdesc;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCdesc() {
		return cdesc;
	}
	public void setCdesc(String cdesc) {
		this.cdesc = cdesc;
	}
	
	
	
	

}
