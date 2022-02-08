package dev.majek.advancements.trigger;

import com.google.gson.JsonObject;
import dev.majek.advancements.shared.DeathObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Fires whenever a player kills a living entity, except players.
 */
public class PlayerKilledEntityTrigger extends Trigger {

	private DeathObject death;
	
	public PlayerKilledEntityTrigger() {
		super(Type.PLAYER_KILLED_ENTITY);
	}
	
	/**
	 * @return information about the death event or null, if none was specified
	 */
	public @Nullable DeathObject death() {
		return this.death;
	}
	
	/**
	 * @param death information about the death event or null, if none was specified
	 * @return the current trigger for chaining
	 */
	public @NotNull PlayerKilledEntityTrigger death(final @Nullable DeathObject death) {
		this.death = death;
		return this;
	}

	@Override
	protected @NotNull JsonObject conditions() {
		return death == null ? new JsonObject() : death.toJson();
	}
}
