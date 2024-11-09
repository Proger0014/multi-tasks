package org.proger0014.project.utils;

import org.proger0014.project.models.Dependency;
import org.proger0014.project.models.Graph;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;

public final class EdgeIteratorTestUtils {
    public static Map.Entry<Graph.Edge, List<String>> initEdge() {
        List<String> keys = List.of("dp1", "dp2", "dp3", "dp4", "dp5", "dp6");

        Dependency dp1 = new Dependency("dp1");
        Dependency dp2 = new Dependency("dp2");
        Dependency dp3 = new Dependency("dp3");
        Dependency dp4 = new Dependency("dp4");
        Dependency dp5 = new Dependency("dp5");
        Dependency dp6 = new Dependency("dp6");

        Graph.Edge e1 = new Graph.Edge(dp1, dp2);
        Graph.Edge e2 = new Graph.Edge(e1, dp2, dp3);
        Graph.Edge e3 = new Graph.Edge(e2, dp3, dp4);
        Graph.Edge e4 = new Graph.Edge(e3, dp4, dp5);
        Graph.Edge e5 = new Graph.Edge(e3, dp5, dp6);

        e1.setNext(e2);
        e2.setNext(e3);
        e3.setNext(e4);
        e4.setNext(e5);

        return new AbstractMap.SimpleEntry<>(e1, keys);
    }
}
