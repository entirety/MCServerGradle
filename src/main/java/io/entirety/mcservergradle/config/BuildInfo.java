package io.entirety.mcservergradle.config;

import com.google.gson.annotations.SerializedName;

public class BuildInfo {

    public String name, escription;
    public Refs refs;
    public int toolsVersion;
    public int[] javaVersions;

    public class Refs {

        @SerializedName("BuildData")
        public String buildData;

        @SerializedName("Bukkit")
        public String bukkit;

        @SerializedName("CraftBukkit")
        public String craftBukkit;

        @SerializedName("Spigot")
        public String spigot;

    }

}
