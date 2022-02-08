package dev.majek.advancements.trigger;

import com.google.gson.JsonObject;
import dev.majek.advancements.shared.DamageObject;
import dev.majek.advancements.util.JsonBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Fires whenever the player takes damage, even if that damage is 0 or blocked.
 */
public class EntityHurtPlayerTrigger extends Trigger {

	private DamageObject damage;
	
	public EntityHurtPlayerTrigger() {
		super(Type.ENTITY_HURT_PLAYER);
	}
	
	/**
	 * @return information about the damage event or null, if none was specified
	 */
	public @NotNull DamageObject damage() {
		return this.damage;
	}
	
	/**
	 * @param damage information about the damage event or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	public @NotNull EntityHurtPlayerTrigger damage(final @Nullable DamageObject damage) {
		this.damage = damage;
		return this;
	}

	@Override
	protected @NotNull JsonObject conditions() {
		return new JsonBuilder()
				.add("damage", damage)
				.build();
	}
}
