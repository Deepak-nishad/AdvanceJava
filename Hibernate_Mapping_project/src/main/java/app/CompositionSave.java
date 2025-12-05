package app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import entities.Address;
import entities.Students;

public class CompositionSave {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		
		//read the info hibernate.cfg.xml file
		Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
						
		//actually conn to database
		SessionFactory sf = metadata.getSessionFactoryBuilder().build();
		
		//1 dialog with database
		Session session = sf.openSession();	
		
		
		Students  s= new Students(1, "Deepak", new Address("Deccan","Pune",411029));
		Transaction tr = session.beginTransaction();
		session.save(s);
		tr.commit();
		session.close();
		
		sf.close();

	}

}
