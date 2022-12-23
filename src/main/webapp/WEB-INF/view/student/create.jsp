<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
</head>
<style>
table, th, td {
  border:1px solid black;
}
</style>
<body>
   Create Student
 <p style="color: red"> ${msg} </p>
 
 
 <form action="/student/save" method="POST">
    Code<input type="text" name="student_code"/><br>
 	Name<input type="text" name="student_name"/><br>
 	Course<input type="text" name="student_course"/><br>
 	<input type="submit" value="Save"/>
 </form>
 <a href="/student/getAll">Get</a><br>
 
<form>
    Code<input type="text" id="student_code"/><br>
 	Name<input type="text" id="student_name"/><br>
 	Course<input type="text" id="student_course"/><br>
 	<input type="button" value="Save" id="btn_save"/>
</form>
<button id="btn_getAll">Get All</button>
<table style="width:100%" id="student_table">
  	<thead>
  		<th>Code</th>
  		<th>Name</th>
  		<th>Course</th>
  		<th>Action</th>
  	</thead>
  	<tbody>
  	</tbody>
</table>
 <script>
 $("#btn_save").on("click", function(){
	       $.post(
			"/student/save",
			{
				student_code : $("#student_code").val(),
				student_name : $("#student_name").val(),
				student_course : $("#student_course").val()
			},
			function(data, status){
				if(status == "success"){
					alert("Data Saved");
					$("#student_code").val("");
					$("#student_name").val("");
					$("#student_course").val("");
				}

			}
	 ); 
 });
 
 $("#btn_getAll").click(function(){
	 $.ajax({
         type: "GET",
         url: "/student/getAll",
         success : function(data){
			for(i=0; i<data.length; i++){
			var tr = "<tr>";
				tr += "<td>" + data[i].code + "</td>";
				tr += "<td>" + data[i].name + "</td>";
				tr += "<td>" + data[i].course + "</td>";
				tr += "<td><button>Edit</button></td>";
				tr += "</tr>";
				$("#student_table tbody").append(tr);
			}

         }
     });
 })
 
 </script>
</body>
</html>