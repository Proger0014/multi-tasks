package org.proger0014.project.tests;

import org.junit.jupiter.api.Test;
import org.proger0014.project.abstractions.DependencyResource;
import org.proger0014.project.models.Dependency;
import org.proger0014.project.resources.TextFileDependencyResource;
import org.proger0014.project.utils.TextFileDependencyResourceTestUtils;

import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextFileDependencyResourceTest {
    private final DependencyResource dependencyResource = new TextFileDependencyResource();

    @Test
    void getFilesWithRequirements_shouldReturnValid() {
        // Arrange
        Map.Entry<String, Set<Dependency.Raw>> data = TextFileDependencyResourceTestUtils.getValidData();
        String urlToSearch = data.getKey();
        Set<Dependency.Raw> expectedSet = data.getValue();

        // Act
        Set<Dependency.Raw> result = dependencyResource.getRawDependencies(urlToSearch);

        // Assert
        assertEquals(expectedSet.hashCode(), result.hashCode());
    }
}
