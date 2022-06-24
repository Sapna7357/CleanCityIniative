package clean.city.initiative;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class databaseObject {
	public databaseObject() {
	}
	public static Connection getConnection() {
		Connection con = null;
		try {
			System.out.println("doin");
			Class.forName("com.mysql.jdbc.Driver");
			String JdbcURL = "jdbc:mysql://localhost:3306/cleancity?useSSL=false";
			String Username = "root";
			String password = "admin";
			con = DriverManager.getConnection(JdbcURL, Username, password);
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
}	
// register user
public int registerUser(String fullName, String user_name, String user_password, String email_id)
		throws ClassNotFoundException {
	int result = 0;
	try {
		Connection con = databaseObject.getConnection();
		Statement stmt = con.createStatement();
	   result = stmt.executeUpdate(
				("insert into users(name, username,email, password)values" + "('"
						+ fullName + "','" + user_name + "','" + user_password + "','" + email_id + "')"));
		ResultSet rs = stmt.executeQuery("SELECT * FROM cleancity.users;"); 
		while (rs.next())
			System.out.println(
					rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getDouble(4)); 
		// step5 close the connection object
		con.close();
	}catch (Exception e) {
		System.out.print(e);
		e.printStackTrace();
	}
	return result; 
}
// to check username already exists

public boolean checkUser(String username) throws ClassNotFoundException {
	boolean status = false;
	try {
		
		Connection con = databaseObject.getConnection();
		PreparedStatement ps = con.prepareStatement(
				"select USERNAME from users where USERNAME= ?");
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		status = rs.next();

	} catch (Exception e1) {
		System.out.print(e1);
		e1.printStackTrace();
	}
	return status;
}
}