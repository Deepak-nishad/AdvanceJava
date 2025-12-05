package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pid")
	Integer pid;
	@Column(name="ename")
	String ename;
	@Column(name="price")
	Float price;
	
	@ManyToOne
	@JoinColumn(name="catid") 
	Category cid;
	
	
	
	public Product() {
		super();
	}
	
	
	

	
	public Product(Integer pid, String ename, Float price, Category cid) {
		this.pid = pid;
		this.ename = ename;
		this.price = price;
		this.cid = cid;
	}





	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	
	
	
	

}
