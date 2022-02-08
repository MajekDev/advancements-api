package dev.majek.advancements.trigger;

import com.google.gson.JsonObject;
import dev.majek.advancements.shared.LocationObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Fires every 20 ticks (every second). Useful for pre-finished/always completed advancements.
 * @see TickTrigger
 */
public class LocationTrigger extends Trigger {

	private LocationObject location;
	
	public LocationTrigger() {
		super(Type.LOCATION);
	}

	/**
	 * @return information about the location or null, if none was specified
	 */
	public @Nullable LocationObject location() {
		return this.location;
	}
	
	/**
	 * @param location information about the location or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	public @NotNull LocationTrigger location(final @Nullable LocationObject location) {
		this.location = location;
		return this;
	}

	@Override
	protected @NotNull JsonObject conditions() {
		return location == null ? new JsonObject() : location.toJson();
	}
}
