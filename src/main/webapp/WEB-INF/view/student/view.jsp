<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
               <table>
            <tr>
                 <th>ID</th>
                <th>Code</th>
                <th>Name</th>
                <th>Course</th>
                <th>Status</th>
            </tr>
            	
            	<form method="post" action="/student/saveBatchStudent">
		            <c:forEach items="${students}" var="s">
		                <tr>
		                    <td>${s.id}</td>
		                    <td>${s.code}</td>
		                    <td>${s.name}</td>
		                    <td>${s.course}</td>
		                    <td>
		                        <input type="hidden" name="code[]" value="${s.code}"/>
			                    <input type="hidden" name="name[]" value="${s.name}"/>
			                    <input type="hidden" name="course[]" value="${s.course}"/>
			                    <input type="checkbox" name="status[]" checked/> 
		                    </td>
		                    
		                </tr>
		            </c:forEach>
		            <input type="submit" value="Take Attendance">
            	</form>
        </table>
    </body>
</html>
