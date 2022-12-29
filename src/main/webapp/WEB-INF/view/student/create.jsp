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
 
 
 <form action="/student/_save" method="POST" enctype="multipart/form-data">
    Code<input type="text" name="code"/><br>
 	Name<input type="text" name="name"/><br>
 	Course<input type="text" name="course"/><br>
 	
 	
 	
 	<input type="file" name="photo"/>
 	
 	
 	<input type="submit" value="Save"/>
 </form>
 <a href="/student/getAll">Get</a><br>
 <br>
 <br>
 
 
 
<form>
    Code<input type="text" id="student_code"/><br>
 	Name<input type="text" id="student_name"/><br>
 	Course<input type="text" id="student_course"/><br>
 	<select id="country">
 		<option value="BD">BD</option>
 		<option value="UK">UK</option>
 		<option value="USA">USA</option>
 	</select><br>
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
			"/student/saveStudent",
			{
				code : $("#student_code").val(),
				name : $("#student_name").val(),
				course : $("#student_course").val(),
				country : $("#country :selected").val();
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
        	 $("#student_table tbody").html("");
			for(i=0; i<data.length; i++){
			var tr = "<tr>";
				tr += "<td>" + data[i].code + "</td>";
				tr += "<td>" + data[i].name + "</td>";
				tr += "<td>" + data[i].course + "</td>";
				tr += "<td><a href='/student/delete/"+data[i].id+"'>Edit</a></td>";
				tr += "</tr>";
				$("#student_table tbody").append(tr);
			}

         }
     });
 })
 
 </script>
</body>
</html>