<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.io.ObjectInputStream" %>
<%@ page import="java.io.ByteArrayInputStream"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Airports</title>
				<%
			ArrayList<String> airports = (ArrayList<String>) request.getAttribute("airports");
		%>
		<script>
		function excluiOpcao(otherSelect,properSelect){
			// One selection
			var e1 = document.getElementById(properSelect);
			var strUser1 = e1.options[e1.selectedIndex].value;
			
			// Other selection
			var e2 = document.getElementById(otherSelect);
			var strUser2 = e2.options[e2.selectedIndex].value;
			
			if (!(strUser1 == "none" && strUser2 == "none")){
				
				for (var i=0; i<airports.size(); i++){
					if(airports.get(i)!=strUser1){
						if (airports.get(i) == strUser2){
							document.getElementById(otherSelect).innerHTML += "<option value="+airports.get(i)+" selected>"+airports.get(i).Nome+"</option>";
						}
						else{
							document.getElementById(otherSelect).innerHTML += "<option value="+airports.get(i)+">"+airports.get(i).Nome+"</option>";
						}
					}
				}
			}
		}
		</script>
	</head>
	<body>	
	<form method="post" action="/CheapFlights2/CheapestRoute">
		<select id="origem"  onchange="excluiOpcao('destino','origem')" name="origem">
		<%	for (String str : airports) { %>
				<option value="<%=str%>">
					<%=str%>
				</option>
		<%	}%>    
		</select><br>
			
		<select id="destino" onchange="excluiOpcao('origem','destino')" name="destino">
		<%	for (String str : airports) { %>
				<option value="<%=str%>">
					<%=str%>
				</option>
		<%	}%>    
		</select><br>
		
		<input type="submit" value="Find Cheapest Route"/>
	</form>
	</body>
</html>