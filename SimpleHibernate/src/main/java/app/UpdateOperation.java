package app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import entities.Emp;



public class UpdateOperation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
		SessionFactory sf = metadata.getSessionFactoryBuilder().build();

		Session session = sf.openSession();
		Emp e = session.get(Emp.class, 7654);   //one record
//		System.out.println(session.get(Emp.class, 7654));
		e.setSal(99099.0f);
		Transaction tr = session.beginTransaction();
		session.update(e);
		

		System.out.println("Emp updated");

		tr.commit();

		session.close();

		sf.close();

	}

}
