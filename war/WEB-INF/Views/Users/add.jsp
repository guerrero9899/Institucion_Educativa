<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="controller.PMF"%>
<%@page import="javax.jdo.*"%>
<%@page import="model.entity.Role"%>
<%@page import="java.util.*"%>
<%
	PersistenceManager pm = PMF.get().getPersistenceManager();
	Query query = pm.newQuery(Role.class);
	List<Role> roles = (List<Role>) query.execute();
%>
<!DOCTYPE html>
<html lang="es">
<head>

<title>Crear una pension</title>
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
	<div class="container-fluid text-center" style="margin-top: 30px">
		<div class="row content">
			<div class="col-sm-4 sidenav">
				<p>
					<a href="/user">Regresar</a>
				</p>
			</div>
			<div class="col-sm-8 text-left">
				<%
					if (!roles.isEmpty()) {
				%>
				<form action="/user/add" method="get">
					<fieldset>
						<legend>Registro</legend>
						<select name="roleId">
							<%
								for (int i = 0; i < roles.size(); i++) {
							%>
							<option value="<%=roles.get(i).getId()%>"
								<%if (i == 0)
						out.print("selected");%>><%=roles.get(i).getName()%></option>
							<%
								}
							%>
						</select> <input type="email" name="email" maxlength="30"
							placeholder="Email" /> <input type="radio" name="gender"
							value="true" checked> Male<br> <input type="radio"
							name="gender" value="false"> Female<br> <input
							type="date" name="date" value="2000-01-01"/> <input type="submit"
							value="Registrar" />
					</fieldset>
				</form>
				<%
					} else {
				%>
				<p>No hay roles creados</p>
				<%
					}
				%>
			</div>
		</div>
	</div>
	<div class="jumbotron text-center" style="margin-bottom: 0">
		<p>Footer</p>
	</div>
</body>
</html>
