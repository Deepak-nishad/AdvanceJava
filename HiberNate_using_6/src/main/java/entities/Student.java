package entities;

import jakarta.persistence.Entity;

@Entity
public class Student {
  
	int sid;
    
 
    String sname;
    
   
 
    
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Student(int sid, String sname) {
		super();
		this.sid = sid;
		this.sname = sname;
		
	}

    
}
