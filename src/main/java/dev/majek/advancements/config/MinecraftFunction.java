package dev.majek.advancements.config;

import dev.majek.advancements.AdvancementIO;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * A .mcfunction file.
 *
 * Note: a function must be activated with {@link AdvancementIO#activateFunction(MinecraftFunction)}.
 */
public class MinecraftFunction {

  private final NamespacedKey key;
  private final Set<String> lines;

  private MinecraftFunction(final @NotNull NamespacedKey key) {
    this.key = key;
    this.lines = new HashSet<>();
  }

  /**
   * Create a new Minecraft function.
   *
   * @param key the key of the function
   * @return new function
   */
  public static @NotNull MinecraftFunction create(final @NotNull NamespacedKey key) {
    return new MinecraftFunction(key);
  }

  /**
   * Get the function's key.
   *
   * @return the key
   */
  public @NotNull NamespacedKey key() {
    return this.key;
  }

  /**
   * Get the function's lines (commands).
   *
   * @return the lines
   */
  public @NotNull Set<@NotNull String> lines() {
    return this.lines;
  }

  /**
   * Add a line to the .mcfunction file. This should be a command.
   *
   * @param line the line to add (command)
   * @return this function
   */
  public @NotNull MinecraftFunction addLine(final @NotNull String line) {
    this.lines.add(line);
    return this;
  }

  /**
   * Add lines to the .mcfunction file. These should be commands.
   *
   * @param lines the lines to add (commands)
   * @return this function
   */
  public @NotNull MinecraftFunction addLines(final @NotNull String... lines) {
    this.lines.addAll(List.of(lines));
    return this;
  }

  /**
   * Add lines to the .mcfunction file. These should be commands.
   *
   * @param lines the lines to add (commands)
   * @return this function
   */
  public @NotNull MinecraftFunction addLines(final @NotNull Collection<String> lines) {
    this.lines.addAll(lines);
    return this;
  }
}
