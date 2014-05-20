import java.io.IOException;
import java.util.ArrayList;

public class MainClass {

	public static void main(String[] args) throws IOException {
		AirportsGraph airports_graph = new AirportsGraph();
		
		// Construct graph
		airports_graph.getAirportGraph();
		
		// Get airports list
		ArrayList<String> airports = airports_graph.getAirports();

		System.out.println(" Airports:\n");
		int i = 0;
		for(String airport : airports){
			System.out.println(i++ + ": " + airport);
		}
		
		// Find shortest path from airports
		airports_graph.findBestPath(airports.get(0),airports.get(airports.size()-1));
		
		System.out.println("\nTotal price: " + airports_graph.getBestPath().getWeight()+
							"\nPath: "+airports_graph.getBestPath());
	}

}
