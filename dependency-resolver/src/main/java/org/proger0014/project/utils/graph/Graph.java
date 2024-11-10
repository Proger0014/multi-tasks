package org.proger0014.project.utils.graph;

import org.proger0014.project.utils.EqualsUtils;
import org.proger0014.project.utils.HashCodeBuilder;

import java.util.HashSet;
import java.util.Set;

public class Graph<T> {
    private final Set<Vertex<T>> vertexSet;

    public Graph(Set<Vertex<T>> vertexSet) {
        this.vertexSet = vertexSet;
    }

    public Set<Vertex<T>> getVertexSet() {
        return vertexSet;
    }

    public static class Edge<T> {
        private final Vertex<T> vertex;
        private Edge<T> previous;
        private Edge<T> next;

        public Edge(Edge<T> previous, Vertex<T> vertex, Edge<T> next) {
            this.previous = previous;
            this.vertex = vertex;
            this.next = next;
        }

        public Edge(Edge<T> previous, Vertex<T> vertex) {
            this(previous, vertex, null);
        }

        public Edge(Vertex<T> vertex, Edge<T> next) {
            this(null, vertex, next);
        }

        public Edge(Vertex<T> vertex) {
            this(null, vertex, null);
        }

        public Vertex<T> getVertex() {
            return vertex;
        }

        public void setPrevious(Edge<T> previous) {
            this.previous = previous;
        }

        public Edge<T> getPrevious() {
            return previous;
        }

        public void setNext(Edge<T> next) {
            this.next = next;
        }

        public Edge<T> getNext() {
            return next;
        }

        public Iterable<Edge<T>> forward() {
            return new EdgeForwardIterable<>(this);
        }

        public Iterable<Edge<T>> backward() {
            return new EdgeBackwardIterable<>(this);
        }


        @Override
        public int hashCode() {
            return HashCodeBuilder.builder()
                .prime(31)
                .append(vertex.getItem())
                .append(() -> getPrevious().getVertex().getItem())
                .append(() -> getNext().getVertex().getItem())
                .build();
        }

        @Override
        public boolean equals(Object obj) {
            return EqualsUtils.equals(this, obj, () -> obj instanceof Edge);
        }
    }

    public static class Vertex<T> {
        private final T item;
        private final Set<Edge<T>> edges;

        public Vertex(T item, Set<Edge<T>> edges) {
            this.item = item;
            this.edges = edges;
        }

        public Vertex(T item) {
            this(item, new HashSet<>());
        }

        public T getItem() {
            return item;
        }

        public boolean addEdge(Edge<T> edge) {
            return edges.add(edge);
        }

        public Set<Edge<T>> getEdges() {
            return edges;
        }

        public boolean isRoot() {
            return edges.stream().noneMatch(e -> e.getPrevious() != null);
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
