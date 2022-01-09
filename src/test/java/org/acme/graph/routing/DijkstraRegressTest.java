package org.acme.graph.routing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;


import org.junit.Before;
import org.junit.Test;

import org.acme.graph.errors.NotFoundException;
import org.acme.graph.TestGraphFactory;
import org.acme.graph.model.Edge;
import org.acme.graph.model.Graph;
import org.acme.graph.model.Path;


/**
 * Tests fonctionnels sur DijkstraPathFinder
 * 
 * @author MBorne
 *
 */
public class DijkstraRegressTest {

	private Graph graph;

	private DijkstraPathFinder finder;

	@Before
	public void setUp() throws Exception {
		this.graph = TestGraphFactory.createGraph01();
		this.finder = new DijkstraPathFinder(graph);
	}

	@Test
	public void testABFound() {
		Path path = finder.findPath(graph.findVertex("a"), graph.findVertex("b"));
		assertNotNull(path);
		assertEquals(1, path.getEdges().size());
	}

	@Test
	public void testBANotFound() {
		assertThrows(NotFoundException.class, () -> {
			finder.findPath(graph.findVertex("b"), graph.findVertex("a"));
			}
		);
	}

	@Test
	public void testACFoundWithCorrectOrder() {
		Path path = finder.findPath(graph.findVertex("a"), graph.findVertex("c"));
		assertNotNull(path);
		assertEquals(2, path.getEdges().size());

		int index = 0;
		
		Edge edge = path.getEdges().get(index++);
		assertEquals("a", edge.getSource().getId());
		assertEquals("b", edge.getTarget().getId());
		
		Edge edge2 = path.getEdges().get(index++);
		assertEquals("b", edge2.getSource().getId());
		assertEquals("c", edge2.getTarget().getId());
		
	}
}