package models;

public class User {

	 String uid, fname,lname,email, contactno;
	 Adress adress;

	 public User(Adress adress) {
		super();
		this.adress = adress;
	}
	 
	 

	 public User(String uid, String fname, String lname, String email, String contactno, Adress adress) {
		super();
		this.uid = uid;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.contactno = contactno;
		this.adress = adress;
	}



	 public String getUid() {
		 return uid;
	 }

	 public void setUid(String uid) {
		 this.uid = uid;
	 }

	 public String getFname() {
		 return fname;
	 }

	 public void setFname(String fname) {
		 this.fname = fname;
	 }

	 public String getLname() {
		 return lname;
	 }

	 public void setLname(String lname) {
		 this.lname = lname;
	 }

	 public String getEmail() {
		 return email;
	 }

	 public void setEmail(String email) {
		 this.email = email;
	 }

	 public String getContactno() {
		 return contactno;
	 }

	 public void setContactno(String contactno) {
		 this.contactno = contactno;
	 }



	 public Adress getAdress() {
		 return adress;
	 }



	 public void setAdress(Adress adress) {
		 this.adress = adress;
	 }
	 
	 

	
}
