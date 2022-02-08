package dev.majek.advancements.trigger;

import com.google.gson.JsonObject;
import dev.majek.advancements.shared.DamageObject;
import dev.majek.advancements.shared.EntityObject;
import dev.majek.advancements.util.JsonBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Fires whenever a player deals any amount of damage (including 0) to an entity (excluding players).
 */
public class PlayerHurtEntityTrigger extends Trigger {

	private DamageObject damage;
	private EntityObject entity;
	
	public PlayerHurtEntityTrigger() {
		super(Type.PLAYER_HURT_ENTITY);
	}
	
	/**
	 * @return information about the damage event or null, if none was specified
	 */
	public @Nullable DamageObject damage() {
		return this.damage;
	}
	
	/**
	 * @return information about the entity that the player had damaged or null, if none was specified
	 */
	public @Nullable EntityObject entity() {
		return this.entity;
	}

	/**
	 * @param damage information about the damage event or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	public @NotNull PlayerHurtEntityTrigger damage(final @Nullable DamageObject damage) {
		this.damage = damage;
		return this;
	}
	
	/**
	 * @param entity information about the entity that the player had damaged or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	public @NotNull PlayerHurtEntityTrigger entity(final @Nullable EntityObject entity) {
		this.entity = entity;
		return this;
	}

	@Override
	protected @NotNull JsonObject conditions() {
		return new JsonBuilder()
				.add("damage", damage)
				.add("entity", entity)
				.build();
	}
}
