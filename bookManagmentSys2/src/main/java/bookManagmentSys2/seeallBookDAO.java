package bookManagmentSys2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class seeallBookDAO {
	
	
	private List<Bookbean> litsOfbook=new ArrayList<>();
	
	
	public List<Bookbean> getlistofBook()
	{
		try
		{
			Connection con=doconnection.doConnection();
			 Bookbean bb;
			PreparedStatement p = con.prepareStatement("select * from Book2");
			ResultSet e = p.executeQuery();
			while(e.next())
			{
				bb=new Bookbean();
				bb.setBname(e.getString(2));
				bb.setBid(e.getInt(1));
				bb.setBauthor(e.getString(3));
				bb.setQty(e.getInt(4));
				bb.setPrice((double)e.getLong(5));
//				System.out.println(e.getInt(5));
				this.litsOfbook.add(bb);
				
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return this.litsOfbook;
	}
	
	
	

}
