package io.entirety.mcservergradle.test.task;

import io.entirety.mcservergradle.task.GitCloneRepo;
import io.entirety.mcservergradle.test.TaskTest;
import io.entirety.mcservergradle.util.Constants;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class TestGitCloneRepo extends TaskTest<GitCloneRepo> {

    @Test
    public void runTask() throws IOException, InterruptedException {
        GitCloneRepo task = getTask(GitCloneRepo.class);
        task.setRepo(Constants.BUKKIT_REPO_URL);
        task.run();

        Assert.assertTrue(task.getOutput().exists());
    }

}
