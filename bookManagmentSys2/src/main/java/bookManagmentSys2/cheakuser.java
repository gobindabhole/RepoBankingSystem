package bookManagmentSys2;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import java.util.stream.Collectors;

import com.happy.App;
import com.happy.mail.SendEmail;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.activation.*;

@SuppressWarnings({ "serial", "unused" })
@WebServlet("/cheakuser")
public class cheakuser extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) {

		String mail = req.getParameter("mail");
		cheakAdminDAO ad = new cheakAdminDAO();
		List<adminbean> listofAdmin = ad.searchUser();
		

		List<adminbean> a = listofAdmin.stream().filter(e -> e.getEmail().equals(mail)).collect(Collectors.toList());
	     Iterator<adminbean> i=a.iterator();
	     
	     if(i.hasNext())
	     {
	    	 System.out.println(i.next());
	     }
		if (!a.isEmpty()) {
			
			String to = mail;
			String from = "bholegobinda@gmail.com";
			String subject = "Password";
			String text = "your password is" + a.get(0).getPassword();
			SendEmail email = new SendEmail();
			boolean sendEmail = email.sendEmail(to, from, subject, text);

			if (sendEmail) {
				System.out.println("Email is sent successfully");
			} else {
				System.out.println("There is a problem in sending email");
			}

		}

	}

}
