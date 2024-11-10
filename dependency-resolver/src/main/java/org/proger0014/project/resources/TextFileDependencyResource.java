package org.proger0014.project.resources;

import org.proger0014.project.abstractions.DependencyResource;
import org.proger0014.project.models.Dependency;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class TextFileDependencyResource implements DependencyResource {
    @Override
    public Set<Dependency.Raw> getRawDependencies(String url) {
        Set<Dependency.Raw> set = new HashSet<>();

        String absolutePathOfRootDir = Path.of(URI.create(url)).toString();

        try (Stream<Path> pathOfFiles = Files.walk(Path.of(absolutePathOfRootDir)).filter(Files::isRegularFile)) {

            pathOfFiles.forEach(p -> {
                Dependency.Raw.Builder builder = Dependency.Raw.builder();

                builder.key(p.toString());

                try (Stream<String> lines = Files.lines(p)) {
                    lines.filter(l -> l.startsWith("require "))
                            .map(s -> Path.of(absolutePathOfRootDir, s.substring(s.indexOf("'") + 1, s.lastIndexOf("'"))).toString())
                            .forEach(builder::requirement);
                } catch (Exception ignored) { }

                set.add(builder.build());
            });

        } catch (Exception ignored) { }

        return set;
    }
}
