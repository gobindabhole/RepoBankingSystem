<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="bookManagmentSys2.Bookbean,java.util.List,java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String msg=(String) request.getAttribute("msg");
String msg1=(String)request.getAttribute("msg1");
HttpSession sct=request.getSession(false);

List<Bookbean> list=(List<Bookbean>)sct.getAttribute("listofbook");
if(msg!=null)
{
	out.println(msg);
}
if(msg1!=null)
{
	out.print(msg1);
}



if(list!=null)
{
	for(Bookbean b:list)
	{
		out.println("<br><br>"+b.getBid()+" "+b.getBname()+" "+b.getBauthor()+" "+ b.getQty()+ " "+ b.getPrice()+"   "+ "<a href='edit?bid="+b.getBid()+"'>Edit</a> <br><br>");
	}
}

%>
 <h3><a href="logout">Logout </a></h3>

</body>
</html>