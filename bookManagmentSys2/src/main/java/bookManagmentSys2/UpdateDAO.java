package bookManagmentSys2;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateDAO {
	
	
	int k=0;
	public int doUpdate(Bookbean bb)
	{
		try
		{
			Connection con=doconnection.doConnection();
			PreparedStatement p = con.prepareStatement("update Book2  set qty=?,price=? where bid=?");
			p.setInt(1, bb.getQty());
			p.setDouble(2,bb.getPrice());
			p.setInt(3,bb.getBid());
			
			k = p.executeUpdate();
		}
		catch(Exception e)
		{
		e.printStackTrace();
		}
		
		
		
		
		
		return k;
	}
	
	
	

}
