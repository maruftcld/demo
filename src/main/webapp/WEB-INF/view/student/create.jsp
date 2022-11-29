<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 Create Student
 
 <form action="/student/save" method="POST">
 	Name<input type="text" name="student_name"/><br>
 	Course<input type="text" name="student_course"/><br>
 	<input type="submit" value="Save"/>
 </form>
 <a href="/student/getAll">Get</a>
 ${dfgd}
 
</body>
</html>