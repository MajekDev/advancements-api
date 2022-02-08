package dev.majek.advancements.trigger;

import com.google.gson.JsonObject;
import dev.majek.advancements.shared.LocationObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Fires when the player successfully enters a bed (the player does not have to pass the night).
 * For example if the bed explodes, such as from trying to sleep in the nether, this trigger will not fire.
 */
public class SleptInBedTrigger extends Trigger {

	private LocationObject location;
	
	public SleptInBedTrigger() {
		super(Type.SLEPT_IN_BED);
	}

	/**
	 * @return information about the location of the sleeping player or null, if none was specified
	 */
	public @Nullable LocationObject location() {
		return this.location;
	}
	
	/**
	 * @param location information about the location of the sleeping player or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	public @NotNull SleptInBedTrigger location(final @Nullable LocationObject location) {
		this.location = location;
		return this;
	}

	@Override
	protected @NotNull JsonObject conditions() {
		return location == null ? new JsonObject() : location.toJson();
	}
}
