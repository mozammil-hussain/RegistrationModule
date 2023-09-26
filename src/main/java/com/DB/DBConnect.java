package com.DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	private static Connection conn=null;
	public static Connection getConnection(){
		// TODO Auto-generated method stub
		try {
			if (conn==null) {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginpage","root","mozammil");
				System.out.println(conn);    
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
			
		}
		System.out.println(conn);
		return conn;
		
	}

}

/*package com.DB;

import java.sql.Connection; 
import java.sql.DriverManager;

public class DBConnect{
    static Connection con;
    public static Connection createDBConnetion(){

        try{
            //load driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //get connection
           // String url="jdbc:mysql://localhost:3306/employee?useSSL=false";
           // String username="root";
          //  String password="root_pass_1234";
        	// Class.forName("com.mysql.jdbc.Driver");
             con= DriverManager.getConnection("jdbc:mysql://localhost:3306/ebook-app","root","mozammil");
             System.out.println("inside DBConnection "+con);

        }catch (Exception ex){
            ex.printStackTrace();
        } 
     return con;

    }
}  
/*
public class DBConnect {
	public static void main(String[] args) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginpage","root","mozammil");
	   System.out.println(conn+" hello");
	
	}
}
*/