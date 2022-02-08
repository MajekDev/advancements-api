package dev.majek.advancements.trigger;

import com.google.gson.JsonObject;
import dev.majek.advancements.shared.RangeObject;
import dev.majek.advancements.util.JsonBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Fires whenever the player uses an Eye of Ender.
 */
public class UsedEnderEyeTrigger extends Trigger {

	private RangeObject distance;
	
	public UsedEnderEyeTrigger() {
		super(Type.USED_ENDER_EYE);
	}
	
	/**
	 * @return information about the distance of the player and the nearest stronghold's center or null,
	 * if none was specified. The vertical distance is not included
	 */
	public @Nullable RangeObject distance() {
		return this.distance;
	}
	
	/**
	 * @param distance information about the distance of the player and the nearest stronghold's center or null,
	 *                  if it should be cleared. The vertical distance is not included
	 * @return the current trigger for chaining
	 */
	public @NotNull UsedEnderEyeTrigger setDistance(final @Nullable RangeObject distance) {
		this.distance = distance;
		return this;
	}

	@Override
	protected @NotNull JsonObject conditions() {
		return new JsonBuilder()
				.add("distance", distance)
				.build();
	}
}
