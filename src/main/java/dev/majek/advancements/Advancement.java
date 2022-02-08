package dev.majek.advancements;

import dev.majek.advancements.config.Frame;
import dev.majek.advancements.config.Rewards;
import dev.majek.advancements.shared.ItemObject;
import dev.majek.advancements.trigger.LocationTrigger;
import dev.majek.advancements.trigger.Trigger;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Custom advancement.
 *
 * @since 1.0.0
 */
public interface Advancement {

    /**
     * Build a new custom advancement.
     *
     * @param key the key of the advancement, which determines the file location
     * @param icon the item to display in the advancement tab, the root advancement's icon is the icon of the tab
     * @param title the title of the advancement
     * @param description the description of the advancement
     * @param triggers the map of triggers that will cause the advancement to complete
     * @see Trigger see this to learn how to use triggers
     * @see ItemObject see this to learn how to use item objects for the icon
     * @return a new advancement builder
     * @since 1.0.0
     */
    static @NotNull Advancement.Builder builder(final @NotNull NamespacedKey key,
                                        final @NotNull ItemObject icon,
                                        final @NotNull Component title,
                                        final @NotNull Component description,
                                        final @NotNull Map<@NotNull String, @NotNull Trigger> triggers) {
        return new AdvancementImpl.BuilderImpl(key, icon, title, description, triggers, new HashSet<>(),
                null, null, null, Frame.TASK, true, true, false);
    }

    /**
     * Get the key of the advancement. All advancement keys are unique.
     *
     * @return the key
     * @since 1.0.0
     */
    @NotNull NamespacedKey key();

    /**
     * Get the item object of the advancement. This is the item shown in the advancements tab.
     *
     * @return the icon
     * @since 1.0.0
     */
    @NotNull ItemObject icon();

    /**
     * Get the title of the advancement. This is the name shown in chat and in the advancements tab.
     *
     * @return the title
     * @since 1.0.0
     */
    @NotNull Component title();

    /**
     * Get the description of the advancement.
     *
     * @return the description
     * @since 1.0.0
     */
    @NotNull Component description();

    /**
     * Get the map of triggers for the advancement. These are things that can cause the advancement to complete.
     *
     * @return the triggers
     * @see #requirements()
     * @since 1.0.0
     */
    @NotNull Map<@NotNull String, @NotNull Trigger> triggers();

    /**
     * Get the requirements for the advancement. These are strings which are the ids of triggers.
     * Items in the set are separated by logical ANDs and items in the array are separated by logical ORs.
     *
     * @return the requirements
     * @see #triggers()
     * @since 1.0.0
     */
    @NotNull Set<@NotNull String[]> requirements();

    /**
     * Get the parent of this advancement, if there is one.
     *
     * @return the parent
     * @since 1.0.0
     */
    @Nullable NamespacedKey parent();

    /**
     * Get the background of this advancement, if there is one.
     *
     * @return the background
     * @since 1.0.0
     */
    @Nullable String background();

    /**
     * Get the rewards that will be given on advancement completion, if there are any.
     *
     * @return the rewards
     * @since 1.0.0
     */
    @Nullable Rewards rewards();

    /**
     * Get the type of frame that will surround the {@link #icon()} in the advancements tab.
     *
     * @return the frame
     * @since 1.0.0
     */
    @NotNull Frame frame();

    /**
     * Whether there will be a popup notification in the top right on advancement completion.
     *
     * @return whether to toast completion
     * @since 1.0.0
     */
    boolean toast();

    /**
     * Whether the advancement completion should be announced in chat to all players.
     *
     * @return whether to announce
     * @since 1.0.0
     */
    boolean announce();

    /**
     * Whether the child advancement is hidden until the parent is completed.
     *
     * @return whether to hide child
     * @since 1.0.0
     */
    boolean hidden();

    /**
     * Get the Json representation of the advancement that will be stored in the server files.
     *
     * @return the advancement's json
     * @since 1.0.0
     */
    @NotNull String toJson();

    /**
     * Load the advancement onto the server and into storage.
     *
     * @param reloadBukkitData whether to reload bukkit data (if you're registering a lot of advancements
     *                         you should reload bukkit data once afterwards)
     * @return whether advancement activation was successful
     * @see Bukkit#reloadData() this is how to reload the data once afterwards
     * @since 1.0.0
     */
    boolean activate(final boolean reloadBukkitData);

    /**
     * Advancement builder for additional configuration options.
     *
     * @since 1.0.0
     */
    interface Builder {

        /**
         * Add a trigger for the advancement.
         *
         * @param id the id of the trigger, all ids must be unique for a single advancement
         * @param trigger any extension of {@link Trigger}
         * @return this builder
         * @since 1.0.0
         */
        @NotNull Builder addTrigger(final @NotNull String id, final @NotNull Trigger trigger);

        /**
         * Add a requirement to the advancement. These are the keys of the triggers that are required.
         *
         * @param requirement requirements which are separated by logical ORs (while separate calls
         *                    to this method are separated by logical ANDs)
         * @return this builder
         * @since 1.0.0
         */
        @NotNull Builder addRequirement(final @NotNull String... requirement);

        /**
         * Set the rewards to be given on advancement completion.
         *
         * @param rewards the rewards which should be given upon completion of this advancement
         *                or null, if no rewards should be given
         * @return this builder
         * @since 1.0.0
         */
        @NotNull Builder rewards(final @Nullable Rewards rewards);

        /**
         * Set the frame of the advancement.
         *
         * @param frame the new frame style. {@link Frame#TASK} by default
         * @return this builder
         * @since 1.0.0
         */
        @NotNull Builder frame(final @NotNull Frame frame);

        /**
         * Set whether there should be a toast popup on advancement completion. True by default.
         *
         * @param toast whether there should be a toast upon completion
         * @return this builder
         * @since 1.0.0
         */
        @NotNull Builder toast(final boolean toast);

        /**
         * Set whether the advancement completion should be announced in chat. True by default.
         *
         * @param announce whether there should be a chat message upon completion
         * @return this builder
         * @since 1.0.0
         */
        @NotNull Builder announce(final boolean announce);

        /**
         * Set whether the child advancement is hidden until the parent is completed. False by default.
         *
         * @param hidden whether child advancement should be hidden
         * @return this builder
         * @since 1.0.0
         */
        @NotNull Builder hidden(final boolean hidden);

        /**
         * Make this advancement a root advancement with a background.
         *
         * @param background the texture to set as the tab's background. Example value: {@code blocks/gravel}
         * @param autoUnlock whether the advancement should be unlocked by default.
         * When true, a {@link LocationTrigger} is added and the {@code announce} and {@code toast}
         *                   properties are set to false
         * @return this builder
         * @since 1.0.0
         */
        @NotNull Builder makeRoot(final @NotNull String background, final boolean autoUnlock);

        /**
         * Make this advancement a child of another advancement.
         *
         * @param parent the advancement id of the parent
         * @return this builder
         * @since 1.0.0
         */
        @NotNull Builder makeChild(final @NotNull NamespacedKey parent);

        /**
         * Build the advancement.
         *
         * @return advancement
         * @since 1.0.0
         */
        @NotNull Advancement build();
    }
}
