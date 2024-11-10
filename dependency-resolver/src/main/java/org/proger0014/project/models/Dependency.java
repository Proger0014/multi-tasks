package org.proger0014.project.models;

import org.proger0014.project.utils.EqualsUtils;
import org.proger0014.project.utils.HashCodeBuilder;
import org.proger0014.project.utils.graph.Graph;

import java.util.HashSet;
import java.util.Set;

/***
 * Представляет собой ключевой элемент, который
 * представляет собой текстовый файл
 */
public class Dependency {
    private final String key;

    public Dependency(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }


    @Override
    public int hashCode() {
        return HashCodeBuilder.builder()
            .prime(31)
            .append(key)
            .build();
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsUtils.equals(this, obj, () -> obj instanceof Dependency);
    }

    public static class Resolved {
        private final Graph<Dependency> graphDependency;

        public Resolved(Graph<Dependency> graphDependency) {
            this.graphDependency = graphDependency;
        }

        public Graph.Vertex<Dependency> getRoot() {
            return graphDependency.getVertexSet().stream().findFirst().orElse(null);
        }
    }

    public static class Raw {
        private final Dependency dependency;
        private final Requirements requirements;

        public Raw(Dependency dependency, Requirements requirements) {
            this.dependency = dependency;
            this.requirements = requirements;
        }

        public Dependency getDependency() {
            return dependency;
        }

        public Requirements getRequirements() {
            return requirements;
        }

        @Override
        public int hashCode() {
            return HashCodeBuilder.builder()
                .prime(31)
                .append(dependency)
                .append(requirements)
                .build();
        }

        @Override
        public boolean equals(Object obj) {
            return EqualsUtils.equals(this, obj, () -> obj instanceof Raw);
        }

        public static Builder builder() {
            return new Builder();
        }

        public static class Builder {
            private Dependency dependency;
            private final Requirements requirements;

            private Builder() {
                this.requirements = initRequirements();
            }

            public Builder key(String key) {
                this.dependency = new Dependency(key);

                return this;
            }

            public Builder requirement(String requirement) {
                requirements.getRequirements().add(new Requirement(requirement));

                return this;
            }

            public Dependency.Raw build() {
                return new Dependency.Raw(dependency, requirements);
            }

            private Requirements initRequirements() {
                Set<Requirement> set = new HashSet<>();

                return new Requirements(set);
            }
        }
    }
}
