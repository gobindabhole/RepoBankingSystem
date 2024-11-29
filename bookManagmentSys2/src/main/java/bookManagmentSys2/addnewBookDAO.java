 package bookManagmentSys2;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class addnewBookDAO  {
	
	
	private  int k=0;
	public int addnewBook(Bookbean bb)
	{
		try
		{
			Connection con=doconnection.doConnection();
			PreparedStatement p = con.prepareStatement("insert into Book2 values(?,?,?,?,?)");
			p.setInt(1, bb.getBid());
			p.setString(2,bb.getBname());
			p.setString(3, bb.getBauthor());
			p.setInt(4, bb.getQty());
			p.setDouble(5, bb.getPrice());
			k = p.executeUpdate();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return this.k;
		
	}

}
