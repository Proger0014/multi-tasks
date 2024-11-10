package org.proger0014.project.utils.graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class EdgeForwardIterable<T> implements Iterable<Graph.Edge<T>> {
    private final Graph.Edge<T> edge;

    public EdgeForwardIterable(Graph.Edge<T> edge) {
        this.edge = edge;
    }

    @Override
    public Iterator<Graph.Edge<T>> iterator() {
        return new EdgeIteratorForward<>(edge);
    }

    public static class EdgeIteratorForward<T> implements Iterator<Graph.Edge<T>> {
        private Graph.Edge<T> edge;
        private final Deque<Graph.Edge<T>> init;

        public EdgeIteratorForward(Graph.Edge<T> edge) {
            this.edge = edge;
            this.init = initDeque(edge);
        }

        private Deque<Graph.Edge<T>> initDeque(Graph.Edge<T> edge) {
            Deque<Graph.Edge<T>> queue = new ArrayDeque<>();

            queue.add(edge);

            return queue;
        }

        @Override
        public boolean hasNext() {
            return edge.getNext() != null || !init.isEmpty();
        }

        @Override
        public Graph.Edge<T> next() {
            return getNext();
        }

        private Graph.Edge<T> getNext() {
            if (!init.isEmpty()) {
                return init.poll();
            }

            edge = edge.getNext();

            return edge;
        }
    }

}
