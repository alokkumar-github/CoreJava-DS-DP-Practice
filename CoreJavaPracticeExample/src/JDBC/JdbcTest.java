package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;

public class JdbcTest {
	public void run(String sql) {
	    // JDBC driver name and database URL
	    String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	    String DB_URL = "jdbc:mysql://localhost/demo";

	    // Database credentials
	    String USER = "someuser"; // Fake of course.
	    String PASS = "somepass"; // This too!

	    Statement stmt = null;
	    ResultSet rs = null;
	    Connection conn = null;
	    Vector<String> columnNames = new Vector<String>();

	    try {
	      // Register JDBC driver
	      Class.forName(JDBC_DRIVER);

	      // Open a connection
	      conn = DriverManager.getConnection(DB_URL, USER, PASS);

	      // Execute SQL query
	      stmt = conn.createStatement();
	      rs = stmt.executeQuery(sql);
	      if (rs != null) {
	        ResultSetMetaData columns = rs.getMetaData();
	        int i = 0;
	        while (i < columns.getColumnCount()) {
	          i++;
	          System.out.print(columns.getColumnName(i) + "\t");
	          columnNames.add(columns.getColumnName(i));
	        }
	        System.out.print("\n");

	        while (rs.next()) {
	          for (i = 0; i < columnNames.size(); i++) {
	            System.out.print(rs.getString(columnNames.get(i))
	                + "\t");

	          }
	          System.out.print("\n");
	        }

	      }
	    } catch (Exception e) {
	      System.out.println("Exception: " + e.toString());
	    }

	    finally {
	      try {
	        if (rs != null) {
	          rs.close();
	        }
	        if (stmt != null) {
	          stmt.close();
	        }
	        if (conn != null) {
	          conn.close();
	        }
	      } catch (Exception mysqlEx) {
	        System.out.println(mysqlEx.toString());
	      }

	    }
	  }
}
