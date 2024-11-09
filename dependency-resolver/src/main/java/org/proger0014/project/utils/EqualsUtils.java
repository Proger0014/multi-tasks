package org.proger0014.project.utils;

import java.util.function.Supplier;

public final class EqualsUtils {
    public static boolean equals(Object target, Object forEquals, Supplier<Boolean> isEqualsType) {
        if (target == null || forEquals == null) return false;
        if (!isEqualsType.get()) return false;
        if (target == forEquals) return true;

        return target.hashCode() == forEquals.hashCode();
    }
}
