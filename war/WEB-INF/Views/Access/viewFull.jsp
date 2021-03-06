<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.entity.*"%>
<%@page import="java.util.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%
	List<Access> accesss = (List<Access>) request.getAttribute("showFull");
%>
<%
	TimeZone.setDefault(TimeZone.getTimeZone("America/Lima"));
	SimpleDateFormat sdf = new SimpleDateFormat();
%>
<!DOCTYPE html>
<html lang="es">
<head>
<title>Todos las Pensiones</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta name="description" content="Servlet perteneciente a escuela">
<meta name="keywords" content="Pension,Pensión,Escuela">
<meta name="author" content="Cristhian Ramirez">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="jumbotron text-center" style="margin-bottom: 0">
		<h1>My First Project</h1>
		<p>Resize this mint</p>
	</div>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<a class="navbar-brand" href="/index.jsp">INDEX</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavbar">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="/resource">Resource</a></li>
				<li class="nav-item"><a class="nav-link" href="/user">User</a></li>
				<li class="nav-item"><a class="nav-link" href="/access">Access</a></li>
				<li class="nav-item"><a class="nav-link" href="/role">Role</a></li>
				<li class="nav-item"><a class="nav-link" href="/pension">Pension</a></li>
				<li class="nav-item"><a class="nav-link" href="/users/login">LOGIN</a></li>
				<li class="nav-item"><a class="nav-link" href="/users/logout">LOGOUT</a></li>
				<li class="nav-item"><a class="nav-link" href="#">...</a></li>
			</ul>
		</div>
	</nav>
	<div class="container" style="margin-top: 30px">
		<div class="row content">
			<div class="col-sm-4 sidenav">
				<p>
					<a href="/access/add">Añadir Nuevo</a>
				</p>
			</div>
			<div class="col-sm-8 text-left">
				<table>
					<tr>
						<th>ID</th>
						<th>Role</th>
						<th>Resource</th>
						<th>Date</th>
						<th>Status</th>
						<th>Actions</th>
					</tr>
					<%
						for (int idx = 0; idx < accesss.size(); idx++) {
							Access t = (Access) accesss.get(idx);
					%>
					<tr>
						<td><%=t.getId()%></td>
						<td><%=t.getRoleId()%></td>
						<td><%=t.getResourceId()%></td>
						<td><%=sdf.format(t.getDate())%></td>
						<td><%=t.isStatus()%></td>
						<td><a href="/pension/view?ID=<%=t.getId()%>">View</a><a
							href="/pension/edit?ID=<%=t.getId()%>">Edit</a><a
							href="/pension/delete?ID=<%=t.getId()%>">Delete</a></td>
					</tr>
					<%
						}
					%>
				</table>
			</div>
		</div>
	</div>
	<div class="jumbotron text-center" style="margin-bottom: 0">
		<p>Footer</p>
	</div>
</body>
</html>