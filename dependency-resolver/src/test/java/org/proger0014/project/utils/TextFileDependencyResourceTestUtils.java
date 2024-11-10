package org.proger0014.project.utils;

import org.proger0014.project.models.Dependency;

import java.net.URI;
import java.nio.file.Path;
import java.util.*;

public final class TextFileDependencyResourceTestUtils {
    private static final String VALID_PATH_BASE = "valid";

    public static Map.Entry<String, Set<Dependency.Raw>> getValidData() {
        String pathOfValid = getPathBase(VALID_PATH_BASE);

        Set<Dependency.Raw> set = new HashSet<>();

        set.add(Dependency.Raw.builder()
                .key(getPathOfFile(pathOfValid, "File 1.1.txt"))
                .requirement(getPathOfFile(pathOfValid, "Folder 2/File 2.1.txt"))
                .requirement(getPathOfFile(pathOfValid, "Folder 2/File 2.2.txt"))
                .build());

        set.add(Dependency.Raw.builder()
                .key(getPathOfFile(pathOfValid, "Folder 2/File 2.1.txt"))
                .build());

        set.add(Dependency.Raw.builder()
                .key(getPathOfFile(pathOfValid, "Folder 2/File 2.2.txt"))
                .build());

        return new AbstractMap.SimpleEntry<>(pathOfValid, set);
    }

    private static String getPathOfFile(String base, String file) {
        String absolutePathToBase = Path.of(URI.create(base)).toString();

        return Path.of(absolutePathToBase, file).toString();
    }

    private static String getPathBase(String base) {
        String pathBase = "";

        try {
            pathBase = Objects.requireNonNull(TextFileDependencyResourceTestUtils.class
                            .getClassLoader()
                            .getResource(VALID_PATH_BASE))
                    .toURI()
                    .toString();
        } catch (Exception ignored) { }

        return pathBase;
    }
}
