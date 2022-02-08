package dev.majek.advancements.trigger;

import com.google.gson.JsonObject;
import dev.majek.advancements.shared.SharedEnum;
import dev.majek.advancements.util.JsonBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

/**
 * A trigger of an advancement. Each advancement must have at least one trigger.
 */
public abstract class Trigger {

    private final Type type;

    /**
     * Create a new trigger.
     *
     * @param type the type of trigger
     */
    protected Trigger(final @NotNull Type type) {
        this.type = type;
    }

    /**
     * Get the type of trigger.
     *
     * @return trigger type
     */
    public @NotNull Type type() {
        return this.type;
    }

    /**
     * Get a Json representation of this trigger.
     *
     * @return trigger json
     */
    public final @NotNull JsonObject toJson() {
        return new JsonBuilder()
                .add("trigger", type.value())
                .add("conditions", conditions())
                .build();
    }

    /**
     * Get a Json representation of the conditions for the trigger.
     *
     * @return the conditions
     */
    protected abstract @NotNull JsonObject conditions();

    /**
     * This method should be used wisely, since it calls {@link #conditions()}.
     *
     * @return the hash code of this trigger
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.type, conditions());
    }

    /**
     * This method should be used wisely, since it calls {@link #conditions()}.
     *
     * @param object the reference object with which to compare
     * @return whether this object has the same content as the passed parameter
     */
    @Override
    public boolean equals(final @Nullable Object object) {
        if (!(object instanceof Trigger)) {
            return false;
        }

        Trigger trigger = (Trigger) object;
        return trigger.type == this.type && Objects.equals(trigger.conditions(), this.conditions());
    }

    /**
     * The type of trigger, this determines which event the trigger listens to.
     */
    public enum Type implements SharedEnum {
        BRED_ANIMALS,
        BREWED_POTION,
        CHANGED_DIMENSION,
        CHANNELED_LIGHTNING,
        CONSTRUCT_BEACON,
        CONSUME_ITEM,
        CURED_ZOMBIE_VILLAGER,
        EFFECTS_CHANGED,
        ENCHANTED_ITEM,
        ENTER_BLOCK,
        ENTITY_HURT_PLAYER,
        ENTITY_KILLED_PLAYER,
        FILLED_BUCKET,
        FISHING_ROD_HOOKED,
        HERO_OF_THE_VILLAGE,
        IMPOSSIBLE,
        INVENTORY_CHANGED,
        ITEM_DURABILITY_CHANGED,
        KILLED_BY_CROSSBOW,
        LEVITATION,
        LOCATION,
        NETHER_TRAVEL,
        PLACED_BLOCK,
        PLAYER_HURT_ENTITY,
        PLAYER_KILLED_ENTITY,
        RECIPE_UNLOCKED,
        SHOT_CROSSBOW,
        SLEPT_IN_BED,
        SUMMONED_ENTITY,
        TAME_ANIMAL,
        TICK,
        USED_ENDER_EYE,
        USED_TOTEM,
        VILLAGER_TRADE,
        VOLUNTARY_EXILE;

        /**
         * Get the string representation of the trigger used by Minecraft.
         *
         * @return trigger value
         */
        @Override
        public @NotNull String value() {
            return "minecraft:" + name().toLowerCase();
        }
    }
}
