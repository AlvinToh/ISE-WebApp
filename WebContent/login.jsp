<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>IS102 Web Platform</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="login.jsp">IS102</a>
			</div>
			<div>
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">CATBot Login Page </a></</li>


				</ul>
			</div>
		</div>
	</nav>
	<%
		String errorMsgs = (String) request.getAttribute("error");
		if (errorMsgs != null && errorMsgs.length() > 0) {
			out.println("<div class='container' align='center' style='padding:0px;height:40px'>");
			out.println("<div class='alert alert-warning' style='width:400px'>");
			out.println("<font color='red'>");
			out.println(errorMsgs);
			out.println("</font>");
		}
		request.removeAttribute("error");
		out.println("</div>");
		out.println("</div>");
	%>
	<div class="container" style="width: 400px">
		<table style="width: 100%; height: 40%">
			<tr>
				<td valign="middle"><form action="Authenticate" method="post"
						class="col-md-12">
						<div class="input-group margin-bottom-sm">
							<span class="input-group-addon"><i
								class="fa fa-envelope-o fa-fw"></i></span> <input class="form-control"
								type="text" placeholder="email address" required=""
								name="emailID">
						</div>
						<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-key fa-fw"></i></span>
							<input class="form-control" type="password" required=""
								placeholder="password" name="password">
						</div>
						<div style="line-height: 80%;">
							<br>
						</div>
						<div class="form-group">
							<table style="width: 100%; height: 40%">
								<tr>
									<th><button class="btn btn-primary btn-lg btn-block">Sign
											In</button>
									<th><span style="padding-left: 10px">
											<th><button class="btn btn-primary btn-lg btn-block">Forgot
													Password</button>
										<th>
										<tr>
												</div>
												</form>
												</td>
											</tr>
							</table>

						</div>
</body>
</html>