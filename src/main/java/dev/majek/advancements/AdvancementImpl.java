package dev.majek.advancements;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import dev.majek.advancements.config.Frame;
import dev.majek.advancements.config.Rewards;
import dev.majek.advancements.shared.ItemObject;
import dev.majek.advancements.trigger.LocationTrigger;
import dev.majek.advancements.trigger.Trigger;
import dev.majek.advancements.util.JsonBuilder;
import dev.majek.advancements.util.Validator;
import net.kyori.adventure.text.Component;
import org.apache.commons.lang.Validate;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Set;

/**
 * Not public api.
 */
class AdvancementImpl implements Advancement {

    private final @NotNull NamespacedKey key;
    private final @NotNull ItemObject icon;
    private final @NotNull Component title;
    private final @NotNull Component description;
    private final @NotNull Map<String, Trigger> triggers;
    private final @NotNull Set<String[]> requirements;
    private final @Nullable NamespacedKey parent;
    private final @Nullable String background;
    private final @Nullable Rewards rewards;
    private final @NotNull Frame frame;
    private final boolean toast;
    private final boolean announce;
    private final boolean hidden;

    AdvancementImpl(final @NotNull NamespacedKey key,
                    final @NotNull ItemObject icon,
                    final @NotNull Component title,
                    final @NotNull Component description,
                    final @NotNull Map<@NotNull String, @NotNull Trigger> triggers,
                    final @NotNull Set<@NotNull String[]> requirements,
                    final @Nullable NamespacedKey parent,
                    final @Nullable String background,
                    final @Nullable Rewards rewards,
                    final @NotNull Frame frame,
                    final boolean toast,
                    final boolean announce,
                    final boolean hidden
    ) {
        this.key = key;
        this.icon = icon;
        this.title = title;
        this.description = description;
        this.triggers = triggers;
        this.requirements = requirements;
        this.parent = parent;
        this.background = background;
        this.rewards = rewards;
        this.frame = frame;
        this.toast = toast;
        this.announce = announce;
        this.hidden = hidden;
    }

    @Override
    public @NotNull NamespacedKey key() {
        return this.key;
    }

    @Override
    public @NotNull ItemObject icon() {
        return this.icon;
    }

    @Override
    public @NotNull Component title() {
        return this.title;
    }

    @Override
    public @NotNull Component description() {
        return this.description;
    }

    @Override
    public @NotNull Map<@NotNull String, @NotNull Trigger> triggers() {
        return this.triggers;
    }

    @Override
    public @NotNull Set<@NotNull String[]> requirements() {
        return this.requirements;
    }

    @Override
    public @Nullable NamespacedKey parent() {
        return this.parent;
    }

    @Override
    public @Nullable String background() {
        return this.background;
    }

    @Override
    public @Nullable Rewards rewards() {
        return this.rewards;
    }

    @Override
    public @NotNull Frame frame() {
        return this.frame;
    }

    @Override
    public boolean toast() {
        return this.toast;
    }

    @Override
    public boolean announce() {
        return this.announce;
    }

    @Override
    public boolean hidden() {
        return this.hidden;
    }

    @Override
    public @NotNull String toJson() {
        final JsonObject json = new JsonObject();
        if (this.parent != null) {
            json.addProperty("parent", parent.toString());
        }

        Validate.notNull(this.icon.item());
        json.add("display", new JsonBuilder()
                .add("icon", this.icon.toJson())
                .add("title", this.title)
                .add("description", this.description)
                .add("background", this.background)
                .add("frame", this.frame.value())
                .add("show_toast", this.toast)
                .add("announce_to_chat", this.announce)
                .add("hidden", this.hidden)
                .build());

        Validate.notEmpty(this.triggers, "All advancements must contain at least one trigger.");
        final JsonObject criteria = new JsonObject();
        for (Map.Entry<String, Trigger> entry : this.triggers.entrySet()) {
            criteria.add(entry.getKey(), entry.getValue().toJson());
        }
        json.add("criteria", criteria);

        if (!this.requirements.isEmpty()) {
            final JsonArray jsonArray = new JsonArray();
            for (String[] array : this.requirements) {
                final JsonArray temp = new JsonArray();
                for (String string : array) {
                    Validate.isTrue(this.triggers.containsKey(string),
                            "The " + string + " trigger doesn't exist in advancement: ", key);
                    temp.add(string);
                }
                jsonArray.add(temp);
            }
            json.add("requirements", jsonArray);
        }

        if (this.rewards != null) {
            json.add("rewards", this.rewards.toJson());
        }
        return JsonBuilder.GSON.toJson(json);
    }

    @Override
    public boolean activate(boolean reloadBukkitData) {
        return AdvancementIO.activateAdvancement(this, reloadBukkitData);
    }

    static class BuilderImpl implements Builder {

        private final @NotNull NamespacedKey key;
        private final @NotNull ItemObject icon;
        private final @NotNull Component title;
        private final @NotNull Component description;
        private final @NotNull Map<String, Trigger> triggers;
        private final @NotNull Set<String[]> requirements;
        private @Nullable NamespacedKey parent;
        private @Nullable String background;
        private @Nullable Rewards rewards;
        private @NotNull Frame frame;
        private boolean toast;
        private boolean announce;
        private boolean hidden;

        BuilderImpl(final @NotNull NamespacedKey key,
                    final @NotNull ItemObject icon,
                    final @NotNull Component title,
                    final @NotNull Component description,
                    final @NotNull Map<@NotNull String, @NotNull Trigger> triggers,
                    final @NotNull Set<@NotNull String[]> requirements,
                    final @Nullable NamespacedKey parent,
                    final @Nullable String background,
                    final @Nullable Rewards rewards,
                    final @NotNull Frame frame,
                    final boolean toast,
                    final boolean announce,
                    final boolean hidden
        ) {
            this.key = key;
            this.icon = icon;
            this.title = title;
            this.description = description;
            this.triggers = triggers;
            this.requirements = requirements;
            this.parent = parent;
            this.background = background;
            this.rewards = rewards;
            this.frame = frame;
            this.toast = toast;
            this.announce = announce;
            this.hidden = hidden;
        }

        @Override
        public @NotNull Builder addTrigger(@NotNull String id, @NotNull Trigger trigger) {
            this.triggers.put(id, trigger);
            return this;
        }

        @Override
        public @NotNull Builder addRequirement(@NotNull String... requirement) {
            this.requirements.add(requirement);
            return this;
        }

        @Override
        public @NotNull Builder rewards(@Nullable Rewards rewards) {
            this.rewards = rewards;
            return this;
        }

        @Override
        public @NotNull Builder frame(@NotNull Frame frame) {
            this.frame = frame;
            return this;
        }

        @Override
        public @NotNull Builder toast(boolean toast) {
            this.toast = toast;
            return this;
        }

        @Override
        public @NotNull Builder announce(boolean announce) {
            this.announce = announce;
            return this;
        }

        @Override
        public @NotNull Builder hidden(boolean hidden) {
            this.hidden = hidden;
            return this;
        }

        @Override
        public @NotNull Builder makeRoot(@NotNull String background, boolean autoUnlock) {
            Validator.texture(background);
            this.parent = null;
            this.background = "minecraft:textures/" + background + ".png";
            if (autoUnlock) {
                this.triggers.put("auto", new LocationTrigger());
                this.announce = false;
                this.toast = false;
            }
            return this;
        }

        @Override
        public @NotNull Builder makeChild(@NotNull NamespacedKey parent) {
            this.parent = parent;
            this.background = null;
            return this;
        }

        @Override
        public @NotNull Advancement build() {
            return new AdvancementImpl(this.key, this.icon, this.title, this.description,
                    this.triggers, this.requirements, this.parent, this.background, this.rewards,
                    this.frame, this.toast, this.announce, this.hidden);
        }
    }
}
