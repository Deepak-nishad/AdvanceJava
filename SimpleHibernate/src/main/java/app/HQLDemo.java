package app;

import org.hibernate.query.Query;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import entities.Emp;

public class HQLDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//create the service
				StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
										
				//read the info hibernate.cfg.xml file
				Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
										
				//actually conn to database
				SessionFactory sf = metadata.getSessionFactoryBuilder().build();		
				
				Session session = sf.openSession();
				
//				Query<Emp> query=session.createQuery("from Emp",Emp.class);
//				List<Emp>emps=query.getResultList();
//				
//				for(Emp e:emps) {
//					
//					System.out.println(e);
//				}
				
//				Query<Object[]> query=session.createQuery("select ename, empno from Emp",Object[].class);
//				
//				List<Object[]>emps=query.getResultList();
//				
//				for(Object[] e:emps) {
//					
//					System.out.println(e[0]+" "+e[1]);
//				}
				
//				Query<Emp> q=session.createQuery("from Emp where deptno= :dno",Emp.class);
//				q.setParameter("dno", 20);
//				List<Emp>emps=q.getResultList();
//				
//				for(Emp e:emps) {
//					
//					System.out.println(e);
//				}
				
//				Query<Object[]> q = session.createQuery("select empno,sal from Emp where deptno = ?1 and sal > ?2",Object[] .class);
//				q.setParameter(1, 10);
//				q.setParameter(2, 2000.0f);
//				List<Object[]>emps=q.getResultList();
//				
//				for(Object[] e:emps) {
//					
//					System.out.println(e[0]+" "+e[1]);
//				}
				
				
//				Query<Double> q = session.createQuery("select avg(sal) from Emp",Double.class);
//				Double avgsal = q.getSingleResult();
//				System.out.println("Average salary : "+avgsal);
//				
//				//only if it is executed within transaction
//				Query query = session.createQuery("update Emp set comm = 1000 where comm < 1000");
//				Transaction tr = session.beginTransaction();
//				int n = query.executeUpdate();   
//				tr.commit();
//				System.out.println(n + " records updated"); 
				
				
				Query<Object[]> q = session.createNamedQuery("getempsfromdept",Object[].class);
				q.setParameter("dno", 30);
				List<Object[]> list= q.getResultList();
				for(Object [] emp : list) {
					System.out.println(emp[0]+" : "+emp[1]);
				}
				
				session.close();
				
				sf.close();
				
				
				
				
				
				

	}

}
