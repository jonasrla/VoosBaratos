

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoadLastGraph
 */
@WebServlet("/LoadLastGraph")
public class LoadLastGraph extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadLastGraph() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Instantiating graph
		AirportsGraph airports_graph = new AirportsGraph();
	
		// Get graph from memory
		try {
			airports_graph.loadGraph(getServletContext().getRealPath("WEB-INF")+"/airport_graph.ser");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		request.setAttribute("airports", airports_graph.getAirports());
		request.getRequestDispatcher("/WEB-INF/showAirports.jsp").forward(request,response);
	}
}
