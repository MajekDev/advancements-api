package dev.majek.advancements;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import dev.majek.advancements.config.MinecraftFunction;
import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

/**
 * Methods for writing advancements/functions to file to activate them.
 */
public class AdvancementIO {

    /**
     * Load the advancement onto the server and into storage.
     *
     * @param advancement the advancement to activate
     * @param reloadBukkitData whether to reload bukkit data (if you're registering a lot of advancements
     *                         you should reload bukkit data once afterwards)
     * @return whether advancement activation was successful
     * @see Bukkit#reloadData() this is how to reload the data once afterwards
     * @since 1.0.0
     */
    public static boolean activateAdvancement(final @NotNull Advancement advancement, final boolean reloadBukkitData) {
        File file = new File(Bukkit.getWorlds().get(0).getWorldFolder(),
                String.join(File.separator, "datapacks", "bukkit", "data",
                        advancement.key().getNamespace(), "advancements", advancement.key().getKey()) + ".json");

        if (!file.exists()) {
            try {
                //noinspection deprecation
                return Bukkit.getUnsafe().loadAdvancement(advancement.key(), advancement.toJson()) != null;
            } catch (Exception e) {
                Bukkit.getLogger().log(Level.SEVERE, "Error activating advancement: " + advancement.key(), e);
                return false;
            }
        }

        try {
            Files.asCharSink(file, Charsets.UTF_8).write(advancement.toJson());
            if (reloadBukkitData) {
                Bukkit.reloadData();
                return Bukkit.getAdvancement(advancement.key()) != null;
            }
            return true;
        } catch (IOException e) {
            Bukkit.getLogger().log(Level.SEVERE, "Error activating advancement: " + advancement.key(), e);
            return false;
        }
    }

    /**
     * Activate a Minecraft function so that it can be used by advancements. This will save the file to storage.
     *
     * @param function the function to activate
     * @return whether function activation was successful
     * @since 1.0.0
     */
    public static boolean activateFunction(final @NotNull MinecraftFunction function) {
        String[] directories_ = function.key().getKey().split("/");
        String fileName = function.key().getKey();
        String[] directories = {};
        if (directories_.length > 1) {
            fileName = directories_[directories_.length - 1];
            directories = Arrays.copyOf(directories_, directories_.length - 1);
        }

        List<String> elements = new ArrayList<>(List.of("datapacks", "bukkit", "data", function.key().getNamespace(), "functions"));
        elements.addAll(Arrays.stream(directories).toList());

        File folder = new File(Bukkit.getWorlds().get(0).getWorldFolder(), String.join(File.separator, elements));
        File file = new File(folder, fileName + ".mcfunction");

        try {
            if (!file.exists() && (!folder.mkdirs() || !file.createNewFile())) {
                Bukkit.getLogger().log(Level.SEVERE, "Error creating function for advancement: " + function.key());
                return false;
            }
            Files.asCharSink(file, Charsets.UTF_8).write(String.join(System.lineSeparator(), function.lines()));
            return true;
        } catch (IOException e) {
            Bukkit.getLogger().log(Level.SEVERE, "Error creating function for advancement: " + function.key(), e);
            return false;
        }
    }
}
