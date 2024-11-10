package org.proger0014.project.models;

import org.proger0014.project.utils.EqualsUtils;

public class Requirement extends Dependency {
    public Requirement(String key) {
        super(key);
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsUtils.equals(this, obj, () -> obj instanceof Requirement);
    }
}
