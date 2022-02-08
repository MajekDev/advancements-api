package dev.majek.advancements.trigger;

import com.google.gson.JsonObject;
import dev.majek.advancements.shared.DeathObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Fires whenever any mob, excluding players kills the player.
 */
public class EntityKilledPlayerTrigger extends Trigger {

	private DeathObject death;
	
	public EntityKilledPlayerTrigger() {
		super(Type.ENTITY_KILLED_PLAYER);
	}
	
	/**
	 * @return information about the death event or null, if none was specified
	 */
	public @Nullable DeathObject death() {
		return this.death;
	}
	
	/**
	 * @param death information about the death event or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	public @NotNull EntityKilledPlayerTrigger death(final @Nullable DeathObject death) {
		this.death = death;
		return this;
	}

	@Override
	protected @NotNull JsonObject conditions() {
		return death == null ? new JsonObject() : death.toJson();
	}
}
