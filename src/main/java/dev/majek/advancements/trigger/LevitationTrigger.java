package dev.majek.advancements.trigger;

import com.google.gson.JsonObject;
import dev.majek.advancements.shared.DistanceObject;
import dev.majek.advancements.shared.RangeObject;
import dev.majek.advancements.util.JsonBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Fires whenever the player is under the levitation status effect.
 */
public class LevitationTrigger extends Trigger {

	private RangeObject duration;
	private DistanceObject distance;
	
	public LevitationTrigger() {
		super(Type.LEVITATION);
	}
	
	/**
	 * @return the duration or null, if none was specified
	 */
	public @Nullable RangeObject duration() {
		return this.duration;
	}
	
	/**
	 * @return information about the distance of the entity or null, if none was specified
	 */
	public @Nullable DistanceObject distance() {
		return this.distance;
	}
	
	/**
	 * @param duration the duration or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	public @NotNull LevitationTrigger duration(final @Nullable RangeObject duration) {
		this.duration = duration;
		return this;
	}
	
	/**
	 * @param distance information about the distance of the entity or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	public @NotNull LevitationTrigger distance(final @Nullable DistanceObject distance) {
		this.distance = distance;
		return this;
	}

	@Override
	protected @NotNull JsonObject conditions() {
		return new JsonBuilder()
				.add("duration", duration)
				.add("distance", distance)
				.build();
	}
}
