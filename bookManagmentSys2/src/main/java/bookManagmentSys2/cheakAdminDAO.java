package bookManagmentSys2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class cheakAdminDAO {

	private adminbean ad;
	private List<adminbean> listofadmin = new ArrayList<adminbean>();

	public List<adminbean> searchUser() {

		{
			try {
				Connection con = doconnection.doConnection();
				PreparedStatement p = con.prepareStatement("select * from admin");
				ResultSet e = p.executeQuery();
				if (e.next()) {
					ad = new adminbean();
					ad.setUname(e.getString(1));
					ad.setPassword(e.getString(2));
					ad.setEmail(e.getString(3));

					listofadmin.add(ad);
				}

			} catch (Exception e) {

			}
			System.out.println(this.listofadmin);
			return this.listofadmin;

		}

	}
}
