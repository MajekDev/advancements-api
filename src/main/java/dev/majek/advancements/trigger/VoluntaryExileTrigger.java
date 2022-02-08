package dev.majek.advancements.trigger;

import com.google.gson.JsonObject;
import dev.majek.advancements.shared.LocationObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Fires when a player causes a raid to begin.
 */
public class VoluntaryExileTrigger extends Trigger {

	private LocationObject location;
	
	public VoluntaryExileTrigger() {
		super(Type.VOLUNTARY_EXILE);
	}
	
	/**
	 * @return the player's location or null, if none was specified
	 */
	public @Nullable LocationObject location() {
		return this.location;
	}
	
	/**
	 * @param location the player's location or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	public @NotNull VoluntaryExileTrigger location(final @Nullable LocationObject location) {
		this.location = location;
		return this;
	}

	@Override
	protected @NotNull JsonObject conditions() {
		return location == null ? new JsonObject() : location.toJson();
	}
}
