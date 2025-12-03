package app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import entities.Emp;

public class SaveOperation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Emp e = new Emp();
		e.setEmpno(13000);
		e.setEname("Chirag");
		e.setJob("Manager");
		e.setSal(34000.0f);

		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
		SessionFactory sf = metadata.getSessionFactoryBuilder().build();

		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		session.save(e);

		System.out.println("Emp saved");

		tr.commit();

		session.close();

		sf.close();

	}

}
