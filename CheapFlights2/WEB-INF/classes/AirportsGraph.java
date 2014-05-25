import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.jgrapht.GraphPath;
import org.jgrapht.alg.DijkstraShortestPath;
import org.jgrapht.graph.DefaultDirectedWeightedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


public class AirportsGraph{
	String date;
	ArrayList<String> airports;
	DefaultDirectedWeightedGraph<String, DefaultWeightedEdge> airportsGraph;
	DijkstraShortestPath<String, DefaultWeightedEdge> shortestPath;
	static int numberOfEdges;
    static boolean graphLoaded;
	
	ArrayList<String> getAirports(){
		return airports;
	}
	
	public void setDate(String newDate){
		date = newDate;
	}
	
	public String getDate(){
		return date;
	}
	
	GraphPath<String, DefaultWeightedEdge> getBestPath(){
		return shortestPath.getPath();
	}
	
	void saveGraph(String path) throws IOException{
		FileOutputStream fileOut =
				new FileOutputStream(path);

		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		
		StorageGraph storage = new StorageGraph();
		storage.setDate(date);
		storage.setAirports(airports);
		storage.setAirportsGraph(airportsGraph);
		
		out.writeObject(storage);
		out.close();
		fileOut.close();
		
        graphLoaded = true;
	}
	
	void loadGraph(String path) throws IOException, ClassNotFoundException{
		FileInputStream fileIn = new FileInputStream(path);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        
        StorageGraph storage = (StorageGraph) in.readObject();
        
        in.close();
        fileIn.close();
        
        date = storage.getDate();
        airports = storage.getAirports();
    	airportsGraph = storage.getAirportsGraph();
	}
	
	AirportsGraph(){
		// Used to build the interface bar
		/// Default date
		date = "201407060000";
		numberOfEdges = 0;
        graphLoaded = false;
		airports = new ArrayList<String>();
		airportsGraph = 
				new DefaultDirectedWeightedGraph<String, DefaultWeightedEdge>(DefaultWeightedEdge.class);
	}
	
	public void getAirportsGraph(String pathToFlights) throws IOException {
        graphLoaded = false;
        try{
        
        ArrayList<String> lines = 
				(ArrayList<String>) Files.readAllLines(
						Paths.get(pathToFlights), Charset.defaultCharset());
		
		// for each flight get names and the first price
		for(String file : lines){
			String departure = file.split(" ")[0];
			String arrival = file.split(" ")[1];
			
			// Getting HTML page and key resources					
			Connection.Response res = Jsoup.connect("http://book.tam.com.br/TAM/dyn/air/booking/upslDispatcher").
				    data("SITE","JJBKJJBK").
				    data("LANGUAGE","BR").
				    data("WDS_MARKET","BR").
				    data("B_DATE_1",date).
				    data("B_LOCATION_1",departure).
				    data("E_LOCATION_1", arrival).
				    data("TRIP_TYPE","O").
				    data("adults","1").
				    data("COMMERCIAL_FARE_FAMILY_1","NEWBUNDLE").
				    userAgent("Mozilla/5.0 (Macintosh; U; Intel Mac OS X; de-de) AppleWebKit/523.10.3 (KHTML, like Gecko) Version/3.0.4 Safari/523.10").
				    timeout(1000000).
				    method(Method.POST).
				    execute();

			Document doc = res.parse();
			
			Elements flights = 
					doc.select("section[id=mainOuter]").
					select("table[id=outbound_list_flight_direct]").
					select("tbody[class=none]").select("tr");
			
			// sometimes there is no direct flight, so its necessary to check
			if(flights.first() != null){
				// used in the interface
				numberOfEdges++;
				
				String departure_airport_name = flights.first().attr("data-blocationfull"); 
				String arrival_airport_name = flights.first().attr("data-elocationfull");
				
				// Add to airports list
				if(airports.contains(departure_airport_name) == false)
					airports.add(departure_airport_name);
				if(airports.contains(arrival_airport_name) == false)
					airports.add(arrival_airport_name);

				String price = flights.first().getElementsByClass("price").first().text();
				
				// Solving problems with comma for parsing
				price = price.replace(".", "");
				price = price.replace(',', '.');
			
				// Add flight to graph
				airportsGraph.addVertex(departure_airport_name);
				airportsGraph.addVertex(arrival_airport_name);
				airportsGraph.addEdge(departure_airport_name,arrival_airport_name);
			
				// Set the price
				airportsGraph.setEdgeWeight(
						airportsGraph.getEdge(departure_airport_name,arrival_airport_name),
						Float.parseFloat(price));
				}
			}
		} catch (NoSuchFileException e){
			e.printStackTrace();
		}
	}
	
	public void findBestPath(String departureAirport, String arrivalAirport){
		// Setting new shortest path 
		shortestPath = 
				new DijkstraShortestPath<String, DefaultWeightedEdge>(
						airportsGraph, 
						departureAirport,
						arrivalAirport);
	}
}