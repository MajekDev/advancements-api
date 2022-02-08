package dev.majek.advancements.config;

import org.jetbrains.annotations.NotNull;

/**
 * Frame styles, displayed on the advancement screen around advancements.
 * The default style is {@link Frame#TASK}.
 */
public enum Frame {
    TASK,
    CHALLENGE,
    GOAL;

    /**
     * Get the value of the frame.
     *
     * @return a {@link String} representation of the enum value, which can be used in JSON objects
     */
    public @NotNull String value() {
        return name().toLowerCase();
    }
}
