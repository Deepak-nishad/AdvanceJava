package apps;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import entities.Order;
import entities.OrderItem;

public class AssociationSave {

	public static void main(String[] args) {
		//create the service
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
						
		//read the info hibernate.cfg.xml file
		Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
						
		//actually conn to database
		SessionFactory sf = metadata.getSessionFactoryBuilder().build();
		
		//1 dialog with database
		Session session = sf.openSession();				// TODO Auto-generated method stub
		
		//saving new master - does not have child
		/*Order o1 = new Order(3, "Rahul");		
		Transaction tr = session.beginTransaction();
		session.save(o1);
		tr.commit(); */
		
		//save child for existing master
		/*Order o = session.get(Order.class, 3);
		OrderItem oi = new OrderItem();
		oi.setPid(3);
		oi.setQty(3);
		oi.setOrder(o);   //only id property will get saved
		Transaction tr = session.beginTransaction();
		session.save(oi);
		tr.commit();*/
		
		//save order with order items
		//having @Cascade is required on onetomany side
		Order o1 = new Order(5, "Disha");	  //new master
		OrderItem oi1= new OrderItem(2, 10);   //child1 - master's new entry
		OrderItem oi2 = new OrderItem(9, 1);   //child2
		Set<OrderItem> items = new HashSet<>();
		items.add(oi1);
		items.add(oi2);
		o1.setItems(items);
		Transaction tr = session.beginTransaction();
		session.save(o1);   //save order - save 2 order items
		tr.commit();
		
		session.close();
		sf.close();

			

	}

}
