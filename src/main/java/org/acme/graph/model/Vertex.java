package org.acme.graph.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.locationtech.jts.geom.Coordinate;

/**
 * 
 * Un sommet dans un graphe
 * 
 * @author MBorne
 *
 */
public class Vertex {

	/**
	 * Identifiant du sommet
	 */
	private String id;

	/**
	 * Position du sommet
	 */
	private Coordinate coordinate;

	/**
	 * dijkstra - coût pour atteindre le sommet
	 */
	private double cost;
	/**
	 * arcs entrants
	 */
	@JsonIgnore
	private List<Edge> inEdges = new ArrayList<Edge>();
	/**
	 * arcs sortants
	 */
	@JsonIgnore
	private List<Edge> outEdges = new ArrayList<Edge>();
	/**
	 * dijkstra - arc entrant avec le meilleur coût
	 */
	private Edge reachingEdge;
	/**
	 * dijkstra - indique si le sommet est visité
	 */
	private boolean visited;

	Vertex() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@JsonIgnore
	public double getCost() {
		return cost;
	}

	public List<Edge> getInEdges() {
		return inEdges;
	}

	public List<Edge> getOutEdges() {
		return outEdges;
	}

	public void setReachingEdge(Edge reachingEdge) {
		this.reachingEdge = reachingEdge;
	}
	
	@JsonIgnore
	public Edge getReachingEdge() {
		return reachingEdge;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	@Override
	public String toString() {
		return id;
	}

}