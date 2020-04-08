package xyz.jecy.plugins;

import org.gradle.api.Project;
import org.gradle.api.provider.Property;

public class BinaryRepositoryExtension {
    private final Property<String> serverUrl;
    private final Property<String> env;

    public BinaryRepositoryExtension(Project project) {
        serverUrl = project.getObjects().property(String.class);
        env =project.getObjects().property(String.class);
    }

    public Property<String> getServerUrl() {
        return serverUrl;
    }

    public Property<String> getEnv() {
        return env;
    }
}