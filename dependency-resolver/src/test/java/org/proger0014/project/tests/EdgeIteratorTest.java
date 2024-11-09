package org.proger0014.project.tests;

import org.junit.jupiter.api.Test;
import org.proger0014.project.models.Dependency;
import org.proger0014.project.models.Graph;
import org.proger0014.project.utils.EdgeIteratorTestUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EdgeIteratorTest {

    @Test
    void iterate_shouldReturnDistinctListOf6Items() {
        // Arrange
        final Map.Entry<Graph.Edge, List<String>> edgeWithExistsKeys = EdgeIteratorTestUtils.initEdge();

        List<String> keys = edgeWithExistsKeys.getValue();
        Graph.Edge edge = edgeWithExistsKeys.getKey();
        List<String> returnedKeys = new ArrayList<>();

        // Act
        for (Dependency d : edge) {
            returnedKeys.add(d.getKey());
        }

        // Assert
        assertEquals(keys, returnedKeys);
    }
}
