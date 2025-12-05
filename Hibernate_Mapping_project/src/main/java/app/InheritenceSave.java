package app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import entities.PerEmp;
import entities.TempEmp;
import entities.Emp;
public class InheritenceSave {

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
//				Emp e=new PerEmp(1, "Deepak", 500.0f, 600.0f, 200.0f);
//				Transaction tr=session.beginTransaction();
//				session.save(e);
//				tr.commit();
				
//				Emp e=new TempEmp(2, "Deepak", 400.25f, 150.0f);
//				Transaction tr=session.beginTransaction();
//				session.save(e);
//				tr.commit();
				
				
				
				Transaction tr=session.beginTransaction();
				Emp e1=session.get(Emp.class, 1);
//			
						e1.setEname("vishal");
//						session.update(e1); 
						session.flush(); // same as update
					
//						session.close();
						session.evict(e1);
						
						session.delete(e1);
						tr.commit();
		

	}

}
