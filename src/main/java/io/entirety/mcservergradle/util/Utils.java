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

package io.entirety.mcservergradle.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.gradle.api.Project;

import java.io.*;

public class Utils {

    public static final Gson GSON = new GsonBuilder()
        .setPrettyPrinting()
        .create();

    private static int CACHE_TIMEOUT = 1000 * 60 * 60;

    public static File getCacheBase(Project project) {
        return new File(project.getGradle().getGradleUserHomeDir(), "caches/mc_server_gradle");
    }

    public static File getCache(Project project, String... path) {
        return new File(getCacheBase(project), String.join(File.separator, path));
    }

    public static <T> T loadJson(File target, Class<T> clazz) throws IOException {
        try (InputStream input = new FileInputStream(target)) {
            return loadJson(input, clazz);
        }
    }

    public static <T> T loadJson(InputStream input, Class<T> clazz) throws IOException {
        return GSON.fromJson(new InputStreamReader(input), clazz);
    }

}
