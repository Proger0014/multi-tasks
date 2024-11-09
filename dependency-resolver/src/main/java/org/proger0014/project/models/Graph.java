package org.proger0014.project.models;

import org.proger0014.project.utils.EdgeIterator;
import org.proger0014.project.utils.EqualsUtils;
import org.proger0014.project.utils.HashCodeBuilder;

import java.util.Iterator;
import java.util.Set;

public class Graph {
    private final Set<Edge> edges;

    public Graph(Set<Edge> edges) {
        this.edges = edges;
    }

    public Set<Edge> getEdges() {
        return edges;
    }

    public static class Edge implements Iterable<Dependency> {
        private final Dependency first;
        private final Dependency second;
        private Edge previous;
        private Edge next;

        public Edge(
                Dependency first,
                Dependency second,
                Edge previous,
                Edge next) {
            this.first = first;
            this.second = second;
            this.previous = previous;
            this.next = next;
        }

        public Edge(
                Dependency first,
                Dependency second) {
            this(first, second, null, null);
        }

        public Edge(
                Edge previous,
                Dependency first,
                Dependency second) {
            this(first, second, previous, null);
        }

        public Edge(
                Dependency first,
                Dependency second,
                Edge next) {
            this(first, second, null, next);
        }

        public Dependency getFirst() {
            return first;
        }

        public Dependency getSecond() {
            return second;
        }

        public void setPrevious(Edge previous) {
            this.previous = previous;
        }

        public Edge getPrevious() {
            return previous;
        }

        public void setNext(Edge next) {
            this.next = next;
        }

        public Edge getNext() {
            return next;
        }


        @Override
        public int hashCode() {
            return HashCodeBuilder.builder()
                .prime(31)
                .append(first)
                .append(second)
                .build();
        }

        @Override
        public boolean equals(Object obj) {
            return EqualsUtils.equals(this, obj, () -> obj instanceof Edge);
        }

        @Override
        public Iterator<Dependency> iterator() {
            return new EdgeIterator(this);
        }
    }

    public static class Vertex {
        private final Set<Edge> edges;

        public Vertex(Set<Edge> edges) {
            this.edges = edges;
        }

        public Set<Edge> getEdges() {
            return edges;
        }

        @Override
        public int hashCode() {
            return HashCodeBuilder.builder()
                .prime(31)
                .appendFromCollection(edges)
                .build();
        }

        @Override
        public boolean equals(Object obj) {
            return EqualsUtils.equals(this, obj, () -> obj instanceof Vertex);
        }
    }
}
