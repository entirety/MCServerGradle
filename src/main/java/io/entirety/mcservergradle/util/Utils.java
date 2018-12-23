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
