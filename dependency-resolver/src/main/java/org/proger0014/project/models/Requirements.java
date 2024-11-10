package org.proger0014.project.models;

import org.proger0014.project.utils.EqualsUtils;
import org.proger0014.project.utils.HashCodeBuilder;

import java.util.Set;

public class Requirements {
    private final Set<Requirement> requirements;

    public Requirements(Set<Requirement> requirements) {
        this.requirements = requirements;
    }

    public Set<Requirement> getRequirements() {
        return requirements;
    }


    @Override
    public boolean equals(Object obj) {
        return EqualsUtils.equals(this, obj, () -> obj instanceof Requirements);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.builder()
            .prime(31)
            .appendFromCollection(requirements)
            .build();
    }
}
