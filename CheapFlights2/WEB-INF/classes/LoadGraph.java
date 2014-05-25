import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoadGraph
 */
@WebServlet("/LoadGraph")
public class LoadGraph extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<String> airports;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadGraph() {
        super();
        
        // Set initial value
		airports = null;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Instantiating graph
		AirportsGraph airports_graph = new AirportsGraph();

		// Set arrival date
		airports_graph.setDate(getDate(request));
		
		// Mining TAM graph
		airports_graph.getAirportsGraph(getServletContext().getRealPath("WEB-INF/tam.dat"));
		
		// Store in memory the graph
		airports_graph.saveGraph(getServletContext().getRealPath("WEB-INF")+"/airport_graph.ser");
		
		// Get graph from memory
		try {
			airports_graph.loadGraph(getServletContext().getRealPath("WEB-INF")+"/airport_graph.ser");
			airports = airports_graph.getAirports();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		request.setAttribute("airports", airports);
		request.getRequestDispatcher("/WEB-INF/showAirports.jsp").forward(request,response);
	}
	
	String getDate(HttpServletRequest request){
		String date = (String) request.getParameter("date");
		return date.replace("-", "")+"0000";
	}
}
