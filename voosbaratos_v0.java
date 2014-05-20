import org.jsoup.Jsoup;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jgrapht.alg.*;
import org.jgrapht.*;
import org.jgrapht.graph.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

/**
 * Example program to list links from a URL.
 */
public class MainClass {
	public static void main(String[] args) throws IOException {
		String path = "/home/victor/Documents/IME/Profissional/3_Sem/LabProg_3/Trabalhos/VoosBaratos/voos/";
		ArrayList<String> lines = (ArrayList<String>) Files.readAllLines(Paths.get(path+"tam_flights"), Charset.defaultCharset());
		
		for(String file : lines){
			File input = new File(path+file);
			showURLElements(input);
		}
	}

	public static void showURLElements(File input)
			throws IOException {
		// Getting HTML page and key resources
		Document doc = Jsoup.parse(input, "UTF-8");
		Elements flights = doc.select("section[id=mainOuter]").select("table[id=outbound_list_flight_direct]").select("tbody[class=none]").select("tr");
		ArrayList<Flight> flight_array = new ArrayList<Flight>(); 
		DefaultDirectedWeightedGraph<String, DefaultWeightedEdge> airportsGraph =
	            new DefaultDirectedWeightedGraph<String, DefaultWeightedEdge>
	            (DefaultWeightedEdge.class);
		
		
		for (Element flight : flights) {
			/*
			Flight buff = new Flight();
			
			buff.setDepartureAirportName(flight.attr("data-blocationfull"));
			buff.setArrivalAirportName(flight.attr("data-elocationfull"));

			// get the first price
			buff.setPrice(flight.getElementsByClass("price").first().text());
			
			flight_array.add(buff);
			*/
			
			String departure_airport_name = flight.attr("data-blocationfull"); 
			String arrival_airport_name = flight.attr("data-elocationfull");
			String price = flight.getElementsByClass("price").first().text();
			
			airportsGraph.addVertex(departure_airport_name);
			airportsGraph.addVertex(arrival_airport_name);

			airportsGraph.setEdgeWeight(airportsGraph.addEdge(departure_airport_name,arrival_airport_name), Float.parseFloat(price));
			
			/*	
			System.out.println("Data de partida: "+flight.attr("data-departuredate"));
			System.out.println("Hora da partida: "+flight.attr("data-departuretime"));
			System.out.println("Codigo da cidade de origem: "+flight.attr("data-departurecitycode"));
			System.out.println("Codigo do aeroporto de origem: "+flight.attr("data-departureairportcode"));
			
			System.out.println("Data da chegada: "+flight.attr("data-arrivaldate"));
			System.out.println("Hora da chegada: "+flight.attr("data-arrivaltime"));
			System.out.println("Codigo da cidade de destino: "+flight.attr("data-arrivalcitycode"));
			System.out.println("Codigo do aeroporto de destino: "+flight.attr("data-arrivalairportcode"));
			
			System.out.println("Número do Avião: "+flight.attr("data-aircraft"));
			System.out.println("Duração: "+flight.attr("data-rpduration"));
			System.out.println("Número do vôo: "+flight.attr("data-flightnumber"));
			System.out.println("Número de paradas: "+flight.attr("data-number-of-stops"));
		*/
		}
		
		for(Flight buff : flight_array){
			buff.print();
		}
	}
}
