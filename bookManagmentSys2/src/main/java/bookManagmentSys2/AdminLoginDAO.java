package bookManagmentSys2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminLoginDAO {
	
	
	
	adminbean ab;
	public adminbean search(String u,String p)
	{
		try
		{
			Connection con=doconnection.doConnection();
			PreparedStatement per= con.prepareStatement("select * from admin where uname=? and password=?");
			per.setString(1, u);
			per.setString(2, p);
			ResultSet r = per.executeQuery();
			if(r.next())
			{
				ab=new adminbean();
				ab.setUname(r.getString(1));
				ab.setPassword(r.getString(2));
				ab.setEmail(r.getString(3));
			}
		}
		catch(Exception e)
		{
			
		}
		
		
		
		
		
		
		return ab;
		
	}
	
	
	

}
