package org.proger0014.project.utils;

import java.util.Collection;

public final class HashCodeBuilder {
    private int prime = 1;
    private int result = 1;

    private HashCodeBuilder() { }

    public static HashCodeBuilder builder() {
        return new HashCodeBuilder();
    }

    public HashCodeBuilder prime(int prime) {
        this.prime = prime;

        return this;
    }

    public HashCodeBuilder initResult(int init) {
        this.result = init;

        return this;
    }

    public HashCodeBuilder append(Object object) {
        if (object == null) return this;

        result = prime * result + object.hashCode();

        return this;
    }

    public <T> HashCodeBuilder appendFromCollection(Collection<T> collection) {
        if (collection == null) return this;

        result = prime * result + collection.stream().mapToInt(Object::hashCode)
                .reduce(0, Integer::sum);

        return this;
    }

    public int build() {
        return result;
    }
}
