/*
 * MCServerGradle
 * Copyright (C) 2018 entirety
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301
 * USA
 */

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
