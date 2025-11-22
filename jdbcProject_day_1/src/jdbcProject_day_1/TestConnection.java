package jdbcProject_day_1;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class TestConnection {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String jdbcurl="jdbc:mysql://localhost:3306/assignments_knowit";
		Connection con =DriverManager.getConnection(jdbcurl, "root", "Deepak@123");
		System.out.println("Connection completed");
		Scanner sc=new Scanner(System.in);
		
//		Statement stmt=con.createStatement();
	
//			ResultSet rs= stmt.executeQuery("select * from emp");
//			
//			while(rs.next()) {
//				System.out.print(rs.getInt(1)+" : ");
//				System.out.println(rs.getInt(8));
//			}
		
		
//	int cnt= stmt.executeUpdate("update emp set sal = 87999 where empno = 7499");
//		
//			if(cnt>0) {
//				System.out.println("result update");
//			}
//			else {
//				System.out.println("Not updated");
//			}
		
//		PreparedStatement ps=con.prepareStatement("select * from emp where EMPNO = ?");
//		
//		
//		System.out.println("Enter employee id : ");
//		Scanner sc=new Scanner(System.in);
//		int empno=sc.nextInt();
		
//		ps.setInt(1, empno);
//		
//		ResultSet rs=ps.executeQuery();
//		
//		if(rs.next()) {
//			System.out.println(rs.getInt(1)+" "+rs.getString(2));
//		}
//		else {
//			System.out.println("Not found the result");
//		}
//		
		
//		System.out.println("Enter min salary ");
//		int min=sc.nextInt();
//		int max=sc.nextInt();
//		
//		PreparedStatement ps=con.prepareStatement("select * from emp where SAl between ? and ?");
//		ps.setInt(1, min);
//		ps.setInt(2, max);
//		
//	ResultSet rs=ps.executeQuery();
//	while(rs.next()) {
//		System.out.println(rs.getInt(6));
//	}
		
		 CallableStatement cs = con.prepareCall("{call new_procedure()}");
       
        
//         cs.setInt(1 );   
         //cs.registerOutParameter(1, java.sql.Types.INTEGER);   //out type of parameters
         if(cs.execute()) {
        	ResultSet value= cs.getResultSet() ;
        	while(value.next()) {
        		System.out.println(value.getInt(1));
        		System.out.println(value.getInt(2));
        	}
         }
         //System.out.println("sal : "+cs.getInt(6));
		
		sc.close();
		
		

	}

}
