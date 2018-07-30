package test;

import java.util.Collections;
import java.util.List;

import test.hipster.graph.GraphBuilder;
import test.hipster.graph.HipsterDirectedGraph;
import test.hipster.graph.HipsterGraph;



/**
 * @author Yaniv Zolicha
 */
public class GraphProblem{



	public static void main(String[] args){
		HipsterDirectedGraph<String, Double> graph = GraphBuilder.<String, Double>create()
				.connect("A").to("B").withEdge(4.0D)
				.connect("A").to("C").withEdge(2.0D)
				.connect("B").to("C").withEdge(5.0D)
				.connect("B").to("D").withEdge(10.0D)
				.connect("C").to("E").withEdge(3.0D)
				.connect("D").to("F").withEdge(11.0D)
				.connect("E").to("D").withEdge(4.0D)
				.createDirectedGraph();

		System.out.println("Path: " + solveGraph(graph, "A", "F"));
	}



	private static List<String> solveGraph(HipsterGraph<String, Double> graph, String fromVertex, String toVertex){
		return Collections.emptyList();
	}



}