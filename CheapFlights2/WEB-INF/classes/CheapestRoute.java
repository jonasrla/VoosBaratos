

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheapestRoute
 */
@WebServlet("/CheapestRoute")
public class CheapestRoute extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheapestRoute() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Instantiating graph
		AirportsGraph airports_graph = new AirportsGraph();
		
		// Get latest graph from memory
		try {
			airports_graph.loadGraph(getServletContext().getRealPath("WEB-INF")+"/airport_graph.ser");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		// TODO: Get destiny and destination
		String departureAirport = request.getParameter("origem");
		String arrivalAirport = request.getParameter("destino");
		
		// Computing best path
		airports_graph.findBestPath(departureAirport,arrivalAirport);
		
		// Setting attributes to JSP  
		request.setAttribute("departureAirport", airports_graph.getBestPath().getStartVertex());
		request.setAttribute("arrivalAirport", airports_graph.getBestPath().getEndVertex());
		request.setAttribute("cheapestPath", airports_graph.getBestPath());
		request.setAttribute("totalPrice",airports_graph.getBestPath().getWeight());
		
		// Send JSP
		request.getRequestDispatcher("/WEB-INF/cheapestRoute.jsp").forward(request,response);
	}
}


