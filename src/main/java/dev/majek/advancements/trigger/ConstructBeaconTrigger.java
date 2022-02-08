package dev.majek.advancements.trigger;

import com.google.gson.JsonObject;
import dev.majek.advancements.shared.RangeObject;
import dev.majek.advancements.util.JsonBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Fires whenever the player is close enough to a beacon and the beacon ticks, possibly giving the player status effects
 * (depending on whether any effect is selected in the beacon). The player does not need to be the one placing the beacon
 * and the beacon does not need to have a pyramid below it.
 */
public class ConstructBeaconTrigger extends Trigger {

	private RangeObject level;
	
	public ConstructBeaconTrigger() {
		super(Type.CONSTRUCT_BEACON);
	}

	/**
	 * @return the beacon's level or null, if none was specified
	 */
	public @Nullable RangeObject level() {
		return this.level;
	}
	
	/**
	 * @param level the beacon's level or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	public @NotNull ConstructBeaconTrigger level(final @Nullable RangeObject level) {
		this.level = level;
		return this;
	}

	@Override
	protected @NotNull JsonObject conditions() {
		return new JsonBuilder()
				.add("level", level)
				.build();
	}
}
