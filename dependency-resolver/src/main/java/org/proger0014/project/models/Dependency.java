package org.proger0014.project.models;

import org.proger0014.project.utils.EqualsUtils;
import org.proger0014.project.utils.HashCodeBuilder;

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
}
