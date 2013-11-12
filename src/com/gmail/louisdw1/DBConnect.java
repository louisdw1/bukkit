package com.gmail.louisdw1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class DBConnect {
	 static String url = "upgrading.db.10645761.hostedresource.com";
	    static String dbName = "upgrading";
	    static String driver = "com.mysql.jdbc.Driver";
	    static String userName = "upgrading";
	    static String password = "Upgrading1!";
/*
	    public static void main() {
   
    try {
        Class.forName(driver).newInstance();
        Connection conn = DriverManager.getConnection(url+dbName,userName,password);
        Statement st = conn.createStatement();
        ResultSet res = st.executeQuery("SELECT * FROM  kill");
        while (res.next()) {
        int id = res.getInt("id");
        String msg = res.getString("vicitm");
        System.out.println(id + "\t" + msg);
        }
       /* int val = st.executeUpdate("INSERT into event VALUES("+1+","+"'Easy'"+")");
        if(val==1)
            System.out.print("Successfully inserted value");
        */
	    /*
        conn.close();

        } catch (Exception e) {
        e.printStackTrace();
        }

}
*/
public static void up(String player, double damage)
{
	 try {
	        Class.forName(driver).newInstance();
	        Connection conn = DriverManager.getConnection("jdbc:mysql://"+url+dbName,userName,password);
	        Statement st = conn.createStatement();
	        
	     int val = st.executeUpdate("INSERT INTO `kill` (`id`,`victim`) VALUES (NULL,'test')");
	        if(val==1)
	            System.out.print("Successfully inserted value");
	      
	        conn.close();

	        } catch (Exception e) {
	        e.printStackTrace();
	        }	
}
}



