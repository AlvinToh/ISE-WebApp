<%@include file="protect.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>IS102 Web Platform</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="style/css/bootstrap.min.css">
<link rel="stylesheet" href="style/css/font-awesome.min.css">
<link rel="stylesheet" href="style/css/fullcalendar.css">
<link rel="stylesheet" href="style/css/_materialFullCalendar.css">
<script src="style/js/jquery-3.2.1.min.js"></script>
<script src="style/js/moment.min.js"></script>
<script src="style/js/fullcalendar.js"></script>

</head>
<body>
<jsp:include page="/Authcalendar"/>
<%
		String loginUrl = (String) session.getAttribute("loginUrl");
		
%>
	<nav class="navbar navbar-toggleable-md navbar-light bg-faded">
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarTogglerDemo01"
			aria-controls="navbarTogglerDemo01" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarTogglerDemo01">
			<a class="navbar-brand" href="home.jsp">IS102</a>
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<li class="nav-item"><a class="nav-link" href="attendance.jsp">Attendance</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Preset Questions</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Request Form</a></li>
				<li class="nav-item"><a class="nav-link" href="<%=loginUrl%>">Login Consultation</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Dashboard</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Forum</a></li>
				<li class="nav-item"><a class="nav-link" href="logout.jsp">Logout</a></li>
			</ul>
		</div>
	</nav>
<script type="text/javascript">
	$(document).ready(function() {

    // page is now ready, initialize the calendar...

    	$('#calendar').fullCalendar({
    		editable: false, // Don't allow editing of events
    		handleWindowResize: true,
    		weekends: false, // Hide weekends
    		defaultView: 'agendaWeek', // Only show week view
    		header: false, // Hide buttons/titles
    		minTime: '07:30:00', // Start time for the calendar
    		maxTime: '22:00:00', // End time for the calendar
    		columnFormat: {
    		    week: 'ddd' // Only show day of the week names
    		},
    		displayEventTime: true // Display event time
        	// put your options and callbacks here
    	})

	});
</script>
<div id="calendar"></div>

<script src="//cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"></script>
<script src="style/js/bootstrap.min.js"></script>

</body>
</html>