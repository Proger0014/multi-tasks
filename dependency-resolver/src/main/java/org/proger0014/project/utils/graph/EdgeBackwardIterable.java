package org.proger0014.project.utils.graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class EdgeBackwardIterable<T> implements Iterable<Graph.Edge<T>> {
    private final Graph.Edge<T> edge;

    public EdgeBackwardIterable(Graph.Edge<T> edge) {
        this.edge = edge;
    }


    @Override
    public Iterator<Graph.Edge<T>> iterator() {
        return new EdgeIteratorBackward<>(edge);
    }

    public static class EdgeIteratorBackward<T> implements Iterator<Graph.Edge<T>> {
        private Graph.Edge<T> edge;
        private final Deque<Graph.Edge<T>> init;


        public EdgeIteratorBackward(Graph.Edge<T> edge) {
            this.edge = edge;
            this.init = initDeque(edge);
        }

        private Deque<Graph.Edge<T>> initDeque(Graph.Edge<T> edge) {
            Deque<Graph.Edge<T>> deque = new ArrayDeque<>();

            deque.add(edge);

            return deque;
        }


        @Override
        public boolean hasNext() {
            return edge.getPrevious() != null || !init.isEmpty();
        }

        @Override
        public Graph.Edge<T> next() {
            return getPrevious();
        }

        private Graph.Edge<T> getPrevious() {
            if (!init.isEmpty()) {
                return init.poll();
            }

            edge = edge.getPrevious();

            return edge;
        }
    }
}
