package dev.majek.advancements.trigger;

import com.google.gson.JsonObject;
import dev.majek.advancements.shared.DistanceObject;
import dev.majek.advancements.shared.LocationObject;
import dev.majek.advancements.util.JsonBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Fires whenever the player enters the nether and then returns to the overworld.
 */
public class NetherTravelTrigger extends Trigger {

	private LocationObject entered;
	private LocationObject exited;
	private DistanceObject distance;
	
	public NetherTravelTrigger() {
		super(Type.NETHER_TRAVEL);
	}
	
	/**
	 * @return information about the location of the nether portal the player entered through or null, if none was specified
	 */
	public @Nullable LocationObject entered() {
		return this.entered;
	}
	
	/**
	 * @return information about the location of the nether portal the player arrived to in the overworld or null, if none was specified
	 */
	public @Nullable LocationObject exited() {
		return this.exited;
	}
	
	/**
	 * @return information about the distance of the two nether portals in the overworld or null, if none was specified
	 */
	public @Nullable DistanceObject distance() {
		return this.distance;
	}
	
	/**
	 * @param entered information about the location of the nether portal the player entered through or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	public @NotNull NetherTravelTrigger entered(final @Nullable LocationObject entered) {
		this.entered = entered;
		return this;
	}
	
	/**
	 * @param exited information about the location of the nether portal the player arrived to in the overworld or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	public @NotNull NetherTravelTrigger exited(final @Nullable LocationObject exited) {
		this.exited = exited;
		return this;
	}
	
	/**
	 * @param distance information about the distance of the two nether portals in the overworld or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	public @NotNull NetherTravelTrigger distance(final @Nullable DistanceObject distance) {
		this.distance = distance;
		return this;
	}

	@Override
	protected @NotNull JsonObject conditions() {
		return new JsonBuilder()
				.add("entered", entered)
				.add("exited", exited)
				.add("distance", distance)
				.build();
	}
}
