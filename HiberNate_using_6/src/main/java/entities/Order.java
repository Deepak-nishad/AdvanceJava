package entities;

import java.util.Set;



import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
	@Id
	int oid;
	//@Column
	String cname;
	
	//third property - optional
	@OneToMany(mappedBy="order")   //order - name of property for FK column
	@Cascade(value =  CascadeType.ALL)
	Set<OrderItem> items;
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(int oid, String cname) {
		super();
		this.oid = oid;
		this.cname = cname;
	}	
	
	public Order(int oid, String cname, Set<OrderItem> items) {
		super();
		this.oid = oid;
		this.cname = cname;
		this.items = items;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Set<OrderItem> getItems() {
		return items;
	}
	
	//collection - orderitems - pid,qty
	public void setItems(Set<OrderItem> items) {
		//for fk column null vale will not get inserted
		//only pid,qty
		for(OrderItem oi : items) {
			oi.setOrder(this);
		}
		//pid,qty,order
		this.items = items;
	}
	

}
