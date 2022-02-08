package dev.majek.advancements.trigger;

import com.google.gson.JsonObject;
import dev.majek.advancements.shared.EntityObject;
import dev.majek.advancements.util.JsonBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Fires whenever the player creates an entity. In the case of the ender dragon, all players able to view the boss bar fulfill the trigger.
 */
public class SummonedEntityTrigger extends Trigger {

	private EntityObject entity;
	
	public SummonedEntityTrigger() {
		super(Type.SUMMONED_ENTITY);
	}

	/**
	 * @return information about the tamed entity or null, if none was specified
	 */
	public @Nullable EntityObject entity() {
		return this.entity;
	}
	
	/**
	 * @param entity information about the tamed entity or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	public @NotNull SummonedEntityTrigger entity(final @Nullable EntityObject entity) {
		this.entity = entity;
		return this;
	}

	@Override
	protected @NotNull JsonObject conditions() {
		return new JsonBuilder()
				.add("entity", entity)
				.build();
	}
}
