package app;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import entities.Category;
import entities.Product;

public class Associationfetch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//create the service
				StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
								
				//read the info hibernate.cfg.xml file
				Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
								
				//actually conn to database
				SessionFactory sf = metadata.getSessionFactoryBuilder().build();
				
				//1 dialog with database
				Session session = sf.openSession();				// TODO Auto-generated method stub

				System.out.println("tabled created");
				
				
//				Category c=session.get(Category.class, 1);
//				if(c!=null) {
//					System.out.println(c.getCid());
//					System.out.println(c.getCdesc());
//					System.out.println(c.getCname());
//				}
				
				Product p=session.get(Product.class, 1);
				if(p!=null) {
					System.out.println(p.getEname());
					System.out.println(p.getPid());
					System.out.println(p.getPrice());
				}
				
				session.close();
				sf.close();
				
				
	}

}
