package bookManagmentSys2;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet
("/logout")
public class AdminLogout  extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		HttpSession hs=req.getSession(false);
		if(hs==null)
		{
			req.setAttribute("msg", "Session Expried..");
			req.getRequestDispatcher("msg.jsp").forward(req, res);
		}
		else
		{
			
			hs.removeAttribute("AdminPass");
			hs.removeAttribute("listofbook");
			hs.invalidate();
//			hs.setAttribute("msg", "Admin logout Sucessfully...");
			req.setAttribute("msg", "Admin logout Sucessfully");
			req.getRequestDispatcher("msg.jsp").forward(req, res);
		}
	}

}
