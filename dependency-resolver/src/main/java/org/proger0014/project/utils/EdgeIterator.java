package org.proger0014.project.utils;

import org.proger0014.project.models.Dependency;
import org.proger0014.project.models.Graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class EdgeIterator implements Iterator<Dependency> {
    private Graph.Edge edge;
    private final Queue<Dependency> initQueue;

    public EdgeIterator(Graph.Edge edge) {
        this.edge = edge;
        this.initQueue = initQueue(edge);
    }

    private Queue<Dependency> initQueue(Graph.Edge edge) {
        Queue<Dependency> queue = new LinkedList<>();

        queue.add(edge.getFirst());
        queue.add(edge.getSecond());

        return queue;
    }

    @Override
    public boolean hasNext() {
        return edge.getNext() != null && edge.getNext().getSecond() != null;
    }

    @Override
    public Dependency next() {
        return getNext();
    }

    private Dependency getNext() {
        if (!initQueue.isEmpty()) {
            return initQueue.poll();
        }

        edge = edge.getNext();

        return edge.getSecond();
    }
}
