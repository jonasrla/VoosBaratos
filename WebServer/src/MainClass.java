import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class MainClass {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
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
		
		// Save in memory
		airports_graph.saveGraph("src/airport_graph.ser");
		
		// Load from memory
        AirportsGraph g = new AirportsGraph();
        g.loadGraph("src/airport_graph.ser");
        
        // get array of airports name
        airports = g.getAirports();
        
		// Find shortest path from airports
		g.findBestPath(airports.get(0),airports.get(airports.size()-1));
        
        System.out.println("\nTotal price: " + g.getBestPath().getWeight()+
				"\nPath: "+g.getBestPath());
	}

}
