package bookManagmentSys2;

import java.io.IOException;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/addnewbook")
public class addnewbook extends HttpServlet {
	
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		Bookbean bb=new Bookbean();
		bb.setBid(Integer.parseInt(req.getParameter("bid")));
		bb.setBname(req.getParameter("bname"));
		bb.setBauthor(req.getParameter("author"));
		bb.setQty(Integer.parseInt(req.getParameter("Qty")));
		bb.setPrice(Double.parseDouble(req.getParameter("price")));
		addnewBookDAO ad=new addnewBookDAO();
		int k = ad.addnewBook(bb);
		if(k>0)
		{
			req.setAttribute("sucessmsg", "Book added sucessfully");
			req.getRequestDispatcher("loginsucessfull.jsp").forward(req, res);
		}
		
		
	}

}
