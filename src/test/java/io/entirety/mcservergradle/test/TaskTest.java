package io.entirety.mcservergradle.test;

import org.gradle.api.DefaultTask;
import org.gradle.api.Project;
import org.gradle.testfixtures.ProjectBuilder;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;

import java.io.IOException;

public abstract class TaskTest<T extends DefaultTask> {

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    protected T getTask(Class<? extends T> clazz) throws IOException {
        Project project = ProjectBuilder.builder()
            .withProjectDir(temporaryFolder.newFolder("projectDir"))
            .build();

        return project.getTasks().create(clazz.getSimpleName(), clazz);
    }

}
