package ru.netology.graphs.topologycalculator;

import ru.netology.graphs.graph.Graph;

import java.util.*;

public class VertexReachabilityCalculator {

    private VertexReachabilityCalculator() {
    }

    public static List<Integer> getOrderedListOfVisitedVertices(Graph graph) {
        var graphTopology = graph.getGraphTopology();
        Deque<Integer> searchQueue = new ArrayDeque<>();
        List<Integer> vertices = new ArrayList<>(graphTopology.keySet());
        List<Integer> visited = new ArrayList<>();
        searchQueue.add(vertices.iterator().next());
        while (!searchQueue.isEmpty()) {
            var vertex = searchQueue.removeFirst();
            if (!visited.contains(vertex)) {
                graphTopology.get(vertex).stream()
                        .filter(Objects::nonNull)
                        .filter(e -> !visited.contains(e))
                        .forEach(searchQueue::add);
                visited.add(vertex);
            }
        }
        return visited;
    }
}