package bookManagmentSys2;

import java.io.Serializable;
import java.util.Objects;

@SuppressWarnings("serial")
public class adminbean implements Serializable {
	
	private String  uname;
	private String  password;
	private String  email;
	
	
	public adminbean()
	{
		
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public int hashCode() {
		return Objects.hash(email, password, uname);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		adminbean other = (adminbean) obj;
		return Objects.equals(email, other.email) && Objects.equals(password, other.password)
				&& Objects.equals(uname, other.uname);
	}
	
	
	

}
