package org.proger0014.project.abstractions;

import org.proger0014.project.models.Dependency;

import java.util.Set;

public interface DependencyResource {
    Set<Dependency.Raw> getRawDependencies(String url);
}
