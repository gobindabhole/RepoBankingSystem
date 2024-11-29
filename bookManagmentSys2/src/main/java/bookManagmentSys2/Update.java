package bookManagmentSys2;


import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@SuppressWarnings("serial")
@WebServlet("/update")
public class Update extends HttpServlet{
	@SuppressWarnings("unchecked")
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		Bookbean bb=new Bookbean();
		bb.setBid(Integer.parseInt(req.getParameter("id")));
		bb.setBname(req.getParameter("bname"));
		bb.setBauthor(req.getParameter("author"));
		bb.setQty(Integer.parseInt(req.getParameter("Qty")));
		bb.setPrice(Double.parseDouble(req.getParameter("price")));
		HttpSession sct=req.getSession(false);
	 List<Bookbean>list=	(List<Bookbean>)sct.getAttribute("listofbook");
	 List<Bookbean> booklist = list.stream().filter(b->(b.getBid()!=bb.getBid())).collect(Collectors.toList());
		booklist.add(bb);
		booklist.sort((b1,b2)->(b1.getBname().compareTo(b2.getBname())));
		sct.removeAttribute("listofbook");
		sct.setAttribute("listofbook", booklist);
		UpdateDAO uD=new UpdateDAO();
		int k = uD.doUpdate(bb);
		if(k>0)
		{
			req.setAttribute("msg1", "UpdateSucessfully.....");
			RequestDispatcher rq = req.getRequestDispatcher("seeAllBook.jsp");
			rq.forward(req, res);
			
		}
		else
		{
			req.setAttribute("msg1", "Errpr ......");
			RequestDispatcher rq = req.getRequestDispatcher("seeAllBook.jsp");
			rq.forward(req, res);
			
		}
//		req.getRequestDispatcher("")
		
		
	}
	
//	int k=0;
//	@SuppressWarnings("unused")
//	public int doUpdate(Bookbean bb)
//	{
//		try
//		{
//			Connection con=doconnection.doConnection();
//			PreparedStatement p = con.prepareStatement("update Book2  set qty=?,price=? where bid=?");
//			p.setString(1, null);
//			
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//		return k;
//	}

}
