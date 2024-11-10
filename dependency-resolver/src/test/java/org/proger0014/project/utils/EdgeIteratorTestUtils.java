package org.proger0014.project.utils;

import org.proger0014.project.models.Dependency;
import org.proger0014.project.utils.graph.Graph;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;

public final class EdgeIteratorTestUtils {
    public static final String FIRST = "first";
    public static final String LAST = "last";

    public static Map.Entry<Graph.Edge<Dependency>, List<String>> initEdge(String order) {
        List<String> keys = List.of("dp1", "dp2", "dp3", "dp4", "dp5", "dp6");

        Dependency dp1 = new Dependency("dp1");
        Dependency dp2 = new Dependency("dp2");
        Dependency dp3 = new Dependency("dp3");
        Dependency dp4 = new Dependency("dp4");
        Dependency dp5 = new Dependency("dp5");
        Dependency dp6 = new Dependency("dp6");

        Graph.Vertex<Dependency> v1 = new Graph.Vertex<>(dp1);
        Graph.Vertex<Dependency> v2 = new Graph.Vertex<>(dp2);
        Graph.Vertex<Dependency> v3 = new Graph.Vertex<>(dp3);
        Graph.Vertex<Dependency> v4 = new Graph.Vertex<>(dp4);
        Graph.Vertex<Dependency> v5 = new Graph.Vertex<>(dp5);
        Graph.Vertex<Dependency> v6 = new Graph.Vertex<>(dp6);

        Graph.Edge<Dependency> e1 = new Graph.Edge<>(v1);
        Graph.Edge<Dependency> e2 = new Graph.Edge<>(e1, v2);
        Graph.Edge<Dependency> e3 = new Graph.Edge<>(e2, v3);
        Graph.Edge<Dependency> e4 = new Graph.Edge<>(e3, v4);
        Graph.Edge<Dependency> e5 = new Graph.Edge<>(e4, v5);
        Graph.Edge<Dependency> e6 = new Graph.Edge<>(e5, v6);

        v1.addEdge(e2);
        v2.addEdge(e3);
        v3.addEdge(e4);
        v4.addEdge(e5);
        v5.addEdge(e6);

        e1.setNext(e2);
        e2.setNext(e3);
        e3.setNext(e4);
        e4.setNext(e5);
        e5.setNext(e6);

        return switch (order) {
            case FIRST -> new AbstractMap.SimpleEntry<>(e1, keys);
            default -> new AbstractMap.SimpleEntry<>(e6, keys.reversed());
        };
    }
}
