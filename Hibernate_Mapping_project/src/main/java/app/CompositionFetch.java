package app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import entities.Students;

public class CompositionFetch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//create the service
				StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
								
				//read the info hibernate.cfg.xml file
				Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
								
				//actually conn to database
				SessionFactory sf = metadata.getSessionFactoryBuilder().build();
				
				//1 dialog with database
				Session session = sf.openSession();	
				
				Students s=session.get(Students.class,1);
				System.out.println(s.getEname());
				System.out.println(s.getSid());
				System.out.println(s.getAddress().getArea());
				System.out.println(s.getAddress().getCity());
				System.out.println(s.getAddress().getPincode());
				session.close();
				
				sf.close();
		

	}

}
