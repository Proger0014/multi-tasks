package org.proger0014.project.utils;

import org.proger0014.project.models.Dependency;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public final class EqualsAndHashCodeUtils {
    public static List<String> getKeys() {
        List<String> keys = new ArrayList<>();

        keys.add("dp1");
        keys.add("dp2 asd dd");
        keys.add("ssss");
        keys.add("dp4");
        keys.add("dp5");
        keys.add("some another keys");
        keys.add("###22!");
        keys.add("");
        keys.add("among us");
        keys.add("dp10");
        keys.add("dp11");
        keys.add("sss");
        keys.add("dp13");
        keys.add("dp14");
        keys.add("dp15");

        return keys;
    }

    public static List<Dependency> getDistinctDependencies() {
        return getKeys().stream().map(Dependency::new).collect(Collectors.toList());
    }

    public static Set<Dependency> getDependenciesSetWithDuplicates() {
        List<Dependency> list = getDistinctDependencies();
        list.addAll(getDistinctDependencies());
        list.addAll(getDistinctDependencies());
        list.addAll(getDistinctDependencies());

        return new HashSet<>(list);
    }
}
