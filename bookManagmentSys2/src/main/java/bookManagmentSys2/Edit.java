package bookManagmentSys2;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/edit")
public class Edit extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("bid"));
		System.out.println(id);
		HttpSession s = req.getSession();
		@SuppressWarnings("unchecked")
		List<Bookbean> list = (List<Bookbean>) s.getAttribute("listofbook");
//		List<Bookbean> bok = list.stream().filter(b -> (b.getBid() == id)).collect(Collectors.toList());
		Optional<Bookbean> optional = list.stream().filter(k -> k.getBid() == id).findFirst();
		Bookbean bookbean = null;
		if (optional.isPresent())
			bookbean = optional.get();

		if (bookbean != null) {
			req.setAttribute("Editbook", bookbean);
			req.getRequestDispatcher("update.jsp").forward(req, res);

		} else {
			req.setAttribute("msg", "Somthing went wrong....");
			req.getRequestDispatcher("seeAllBook.jsp");
		}

	}

}
