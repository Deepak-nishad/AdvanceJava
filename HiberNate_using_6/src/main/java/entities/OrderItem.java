package entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="orderitems")
public class OrderItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int oiid;
	//@Column
	int pid;
	//@Column
	int qty;
	
	@ManyToOne
	@JoinColumn(name="oid")   //from order entity save only id property
	//fk column
	Order  order;

	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public OrderItem(int pid, int qty) {
		super();
		this.pid = pid;
		this.qty = qty;
	}



	public OrderItem(int oiid, int pid, int qty, Order order) {
		super();
		this.oiid = oiid;
		this.pid = pid;
		this.qty = qty;
		this.order = order;
	}

	public int getOiid() {
		return oiid;
	}

	public void setOiid(int oiid) {
		this.oiid = oiid;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	
	

}
