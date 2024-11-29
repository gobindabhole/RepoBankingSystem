package bookManagmentSys2;

import java.io.IOException;

import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/seeallBook")
public class seeallBook extends HttpServlet {
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		seeallBookDAO seB=new seeallBookDAO();
		List<Bookbean> getlistofBook = seB.getlistofBook();
//		Iterator<bookbean> ibb=getlistofBook.iterator();
		if(getlistofBook.size()>0)
		{
			HttpSession sct=req.getSession(false);
			sct.setAttribute("listofbook", getlistofBook);
			
			req.getRequestDispatcher("seeAllBook.jsp").forward(req, res);
		}
		else
		{
			req.setAttribute("msg1", "<h3 style:'color:red'>Book is not there.......</h3>");
			req.getRequestDispatcher("loginsucessfull.jsp").forward(req, res);

			
		}
		
	}

}
