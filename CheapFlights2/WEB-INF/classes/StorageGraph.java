import java.io.Serializable;
import java.util.ArrayList;

import org.jgrapht.graph.DefaultDirectedWeightedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;


public class StorageGraph implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String date;
	ArrayList<String> airports;
	DefaultDirectedWeightedGraph<String, DefaultWeightedEdge> airports_graph;
	
	StorageGraph(){
		airports = null;
		airports_graph = null;
		date = null;
	}
	
	public void setDate(String newDate){
		date = newDate;
	}
	
	public String getDate(){
		return date;
	}
	
	public ArrayList<String> getAirports(){
		return airports;
	}
	
	public DefaultDirectedWeightedGraph<String, DefaultWeightedEdge> getAirportsGraph(){
		return airports_graph;
	}
	
	public void setAirports(ArrayList<String> new_airports){
		airports = new_airports;
	}
	
	public void setAirportsGraph(DefaultDirectedWeightedGraph<String, DefaultWeightedEdge> new_airports_graph){
		airports_graph = new_airports_graph;
	}
}