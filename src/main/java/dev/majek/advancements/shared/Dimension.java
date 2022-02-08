package dev.majek.advancements.shared;

import org.jetbrains.annotations.NotNull;

/**
 * Specifies a world type.
 * @see LocationObject
 */
public enum Dimension implements SharedEnum {
	OVERWORLD,
	THE_NETHER,
	THE_END;

	@Override
	public @NotNull String value() {
		return "minecraft:" + name().toLowerCase();
	}
}
