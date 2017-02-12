package practice.graph.bfs.s1;

import java.util.LinkedList;

/**
 * Represents a graph node
 * 
 * Modified from yan.braslavski code
 * 
 */
public class Vertex {
	
	private final int coordX;
	private final int coordY;
	private boolean visited;
	private LinkedList<Vertex> adjecentVertices = new LinkedList<>();

	/**
	 * 
	 * @param x coordinate x
	 * @param y coordinate y
	 */
	public Vertex(int x, int y) {
		coordX = x;
		coordY = y;
	}

	/* ------------------------------------------------ */
	/* OVERRIDDEN METHOD(S) */
	/* ------------------------------------------------ */

	@Override
	public String toString() {
		return "(" + coordX + "," + coordY + ")";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass())
			return false;

		Vertex vertex = (Vertex) o;

		if (coordX != vertex.coordX)
			return false;
		return coordY == vertex.coordY;

	}

	@Override
	public int hashCode() {
		int result = coordX;
		result = 31 * result + coordY;
		return result;
	}
	
	/* ------------------------------------------------ */
	/* GETTER(S) AND SETTER(S) */
	/* ------------------------------------------------ */
	
	public int getX() {
		return coordX;
	}

	public int getY() {
		return coordY;
	}

	public LinkedList<Vertex> getAdjVertices() {
		return adjecentVertices;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public void addAdjVertex(Vertex v) {
		adjecentVertices.add(v);
	}
	
	

}
