package bookManagmentSys2;


import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/adminlogginServlet")
public class adminlogginServlet  extends  HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String uname=req.getParameter("uname");
		String pass=req.getParameter("pass");
		
		AdminLoginDAO a=new AdminLoginDAO();
		adminbean admin = a.search(uname, pass);
		if(admin!=null)
		{
			HttpSession hs=req.getSession();
			hs.setAttribute("AdminPass", admin);
			RequestDispatcher r = req.getRequestDispatcher("loginsucessfull.jsp");
			r.forward(req, res);
		}
		else
		{
			req.setAttribute("msg", "<h4 style= 'color:red;'>Wrong userName or password try again...</h4>");
			req.getRequestDispatcher("adminlogin.html").forward(req, res);
		}
		
		
		
	}

}
