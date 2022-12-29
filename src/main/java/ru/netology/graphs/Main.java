package ru.netology.graphs;

import ru.netology.graphs.topologycalculator.VertexReachabilityCalculator;
import ru.netology.graphs.graph.Edge;
import ru.netology.graphs.graph.Graph;

import java.util.HashSet;
import java.util.Set;

public class Main {
    private static final Set<Edge> edges = new HashSet<>();

    static {
        edges.add(Edge.builder().headEnd(0).tailEnd(1).build());
        edges.add(Edge.builder().headEnd(0).tailEnd(3).build());
        edges.add(Edge.builder().headEnd(1).tailEnd(2).build());
        edges.add(Edge.builder().headEnd(1).tailEnd(3).build());
    }
    public static void main(String[] args) {
        var graph = new Graph(7, edges);
        var visitedVertices = VertexReachabilityCalculator.getOrderedListOfVisitedVertices(graph);
        System.out.println("Последний получатель мема: " + visitedVertices.get(visitedVertices.size() - 1));
    }
}