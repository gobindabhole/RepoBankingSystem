<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="bookManagmentSys2.adminbean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>
<%
  String msg=(String) request.getAttribute("sucessmsg");
String msg1=(String)request.getAttribute("msg1");
if(msg!=null)
{
	out.println(msg);
}
else if(msg1!=null)
{
	out.print(msg1);
}
 else
 {
	 adminbean bean=(adminbean)session.getAttribute("AdminPass");
		out.println("<h3>Welcome , "+bean.getUname()+" </h3>");
	 
 }


%>
</h3>

&nbsp;&nbsp;
<a href="AddNewBookDetailes.html"> Add new Book</a>&nbsp;&nbsp;&nbsp;
<a href="seeallBook"> See all book</a>&nbsp;&nbsp;&nbsp;
<a href="logout">Logout</a>



</body>
</html>