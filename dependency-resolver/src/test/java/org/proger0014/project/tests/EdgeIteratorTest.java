package org.proger0014.project.tests;

import org.junit.jupiter.api.Test;
import org.proger0014.project.models.Dependency;
import org.proger0014.project.utils.graph.Graph;
import org.proger0014.project.utils.EdgeIteratorTestUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EdgeIteratorTest {

    @Test
    void iterateForward_shouldReturnDistinctListOf6ItemsInForwardOrder() {
        // Arrange
        final Map.Entry<Graph.Edge<Dependency>, List<String>> edgeWithExistsKeys = EdgeIteratorTestUtils.initEdge(EdgeIteratorTestUtils.FIRST);

        List<String> keys = edgeWithExistsKeys.getValue();
        Graph.Edge<Dependency> edge = edgeWithExistsKeys.getKey();
        List<String> returnedKeys = new ArrayList<>();

        // Act
        for (Graph.Edge<Dependency> e : edge.forward()) {
            returnedKeys.add(e.getVertex().getItem().getKey());
        }

        // Assert
        assertEquals(keys, returnedKeys);
    }

    @Test
    void iterateBackward_shouldReturnDistinctListOf6ItemsInBackwardOrder() {
        // Arrange
        final Map.Entry<Graph.Edge<Dependency>, List<String>> edgeWithExistsKeys = EdgeIteratorTestUtils.initEdge(EdgeIteratorTestUtils.LAST);

        List<String> keys = edgeWithExistsKeys.getValue();
        Graph.Edge<Dependency> edge = edgeWithExistsKeys.getKey();
        List<String> returnedKeys = new ArrayList<>();

        // Act
        for (Graph.Edge<Dependency> e : edge.backward()) {
            returnedKeys.add(e.getVertex().getItem().getKey());
        }

        // Assert
        assertEquals(keys, returnedKeys);
    }
}
