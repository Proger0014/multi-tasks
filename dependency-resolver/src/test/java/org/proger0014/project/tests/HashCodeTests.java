package org.proger0014.project.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.proger0014.project.models.Dependency;
import org.proger0014.project.utils.EqualsAndHashCodeUtils;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HashCodeTests {
    private static List<Dependency> dependencies;

    @BeforeAll
    static void beforeAll() {
        dependencies = EqualsAndHashCodeUtils.getDistinctDependencies();
    }

    @AfterAll
    static void afterAll() {
        dependencies = null;
    }

    @ParameterizedTest
    @MethodSource("keys")
    void listContains_shouldReturnTrueForAllKeys(String key) {
        // Arrange
        Dependency dependencyFromKey = new Dependency(key);

        // Act
        boolean isContains = dependencies.contains(dependencyFromKey);

        // Assert
        assertTrue(isContains);
    }

    @Test
    void hashSet_shouldHaveDistinctValues() {
        // Arrange-Act
        List<String> expectedKeys = EqualsAndHashCodeUtils.getKeys().stream().sorted().toList();
        Set<Dependency> set = EqualsAndHashCodeUtils.getDependenciesSetWithDuplicates();
        List<String> actualKeys = set.stream().map(Dependency::getKey).sorted().toList();

        // Assert
        assertEquals(expectedKeys, actualKeys);
    }


    private static Stream<Arguments> keys() {
        Stream.Builder<Arguments> builder = Stream.builder();

        EqualsAndHashCodeUtils.getKeys().stream()
                .map(Arguments::of)
                .forEach(builder::add);

        return builder.build();
    }
}
