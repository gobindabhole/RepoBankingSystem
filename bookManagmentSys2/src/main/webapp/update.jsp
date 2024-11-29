<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="bookManagmentSys2.Bookbean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
Bookbean bb=(Bookbean)request.getAttribute("Editbook");
 %>

<div>
<form  action="update" method="POST">
  Book-Id:<input type="number" name="id" value="<%=bb.getBid() %>" >
<br>
<br>
Book-Name<input type="text" name="bname" value="<%=bb.getBname() %>" readonly>
<br>
<br>
 Book-Author<input type="text" name="author" value="<%=bb.getBauthor() %>" readonly>
<br>
<br>
 Book-Qty<input type="number" name="Qty" value="<%=bb.getQty()%>">
<br>
<br>
Book-Price<input type="number" name="price" value="<%=bb.getPrice()%>">


<br>
<br>
<input type="submit" value="Update">




</form>


</div>




</body>
</html>