package apps;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import entities.Order;
import entities.OrderItem;

public class AssociationFetch {

	public static void main(String[] args) {
		//create the service
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
						
		//read the info hibernate.cfg.xml file
		Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
						
		//actually conn to database
		SessionFactory sf = metadata.getSessionFactoryBuilder().build();
		
		//1 dialog with database
		Session session = sf.openSession();				// TODO Auto-generated method stub

		//fetching child with master
		
		OrderItem oi = session.get(OrderItem.class, 3);
		
		if(oi != null) {
			System.out.println("Order item id : "+oi.getOiid());
			System.out.println("product id : "+oi.getPid());
			System.out.println("Qty : "+oi.getQty());
			System.out.println("cust name : "+oi.getOrder().getCname());
		}
		else {
			System.out.println("does not exist");
		}
		
		//fetching master with child
		Order order= session.get(Order.class, 1);
		if(order != null ) {
			 System.out.println("id : "+order.getOid());
			 System.out.println("cust name : "+order.getCname());
			 System.out.println("no of items : "+order.getItems().size());
		}
		session.close();
		sf.close();
		
	}

}
