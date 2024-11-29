package bookManagmentSys2;

import java.sql.Connection;
import java.sql.DriverManager;

public class doconnection {
	
	
 static Connection con;
	public  static Connection doConnection()
	{
		try
		{
			Class.forName(dbinfo.dirver);
			con=DriverManager.getConnection(dbinfo.url,dbinfo.uname,dbinfo.pass);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}

}
