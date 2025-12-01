package beans;

public class Topic {
   int topicid;
   String tname;
   String tdesc;
   String userid;
   public Topic() {
	super();
	// TODO Auto-generated constructor stub
   }
   public Topic(int topicid, String tname, String tdesc, String userid) {
	super();
	this.topicid = topicid;
	this.tname = tname;
	this.tdesc = tdesc;
	this.userid = userid;
   }
   public int getTopicid() {
	return topicid;
   }
   public void setTopicid(int topicid) {
	this.topicid = topicid;
   }
   public String getTname() {
	return tname;
   }
   public void setTname(String tname) {
	this.tname = tname;
   }
   public String getTdesc() {
	return tdesc;
   }
   public void setTdesc(String tdesc) {
	this.tdesc = tdesc;
   }
   public String getUserid() {
	return userid;
   }
   public void setUserid(String userid) {
	this.userid = userid;
   }  
}
