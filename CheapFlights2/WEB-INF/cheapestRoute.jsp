<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="org.jgrapht.GraphPath" %>
<%@ page import="org.jgrapht.graph.DefaultWeightedEdge"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Cheapest Route</title>
	</head>
	<body>
		<h2>Cheapest Route</h2>
		Departure Airport: <%=request.getAttribute("departureAirport")%><br>
		Arrival Airport: <%=request.getAttribute("arrivalAirport")%><br>
		<br>
		Route:<br>
		<%=request.getAttribute("cheapestPath")%><br>
		<%
			GraphPath<String, DefaultWeightedEdge> cheapestPath = 
				(GraphPath<String, DefaultWeightedEdge>) request.getAttribute("cheapestPath");
		
			for(DefaultWeightedEdge flight: cheapestPath.getEdgeList()){
		%>
			<p><%=flight.toString()%></p>
		<%} %>
		<br>
		Total Price: <%=request.getAttribute("totalPrice")%>
	</body>
</html>