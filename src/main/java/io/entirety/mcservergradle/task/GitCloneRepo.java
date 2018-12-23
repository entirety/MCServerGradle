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

package io.entirety.mcservergradle.task;

import org.ajoberstar.grgit.Grgit;
import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.Optional;
import org.gradle.api.tasks.OutputDirectory;
import org.gradle.api.tasks.TaskAction;

import java.io.File;
import java.util.Base64;

public class GitCloneRepo extends DefaultTask {

    private File output;
    private String repo, ref, remote = "origin";

    @TaskAction
    public void run() {
        Grgit.clone(cloneOp -> {
           cloneOp.setDir(getOutput());
           cloneOp.setUri(getRepo());
           cloneOp.setRefToCheckout(getRef());
           cloneOp.setRemote(getRemote());
        });
    }

    @OutputDirectory
    public File getOutput() {
        if (output == null) {
            output = getProject().file("build/" + getName() + "/repo." + Base64.getEncoder().encodeToString(repo.getBytes()) + "/" + getRef());
        }

        return output;
    }

    public void setOutput(File output) {
        this.output = output;
    }

    @Input
    public String getRepo() {
        return repo;
    }

    public void setRepo(String repo) {
        this.repo = repo;
    }

    @Input
    @Optional
    public String getRef() {
        if (ref == null) {
            ref = "master";
        }

        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    @Input
    @Optional
    public String getRemote() {
        return remote;
    }

    public void setRemote(String remote) {
        this.remote = remote;
    }

}
