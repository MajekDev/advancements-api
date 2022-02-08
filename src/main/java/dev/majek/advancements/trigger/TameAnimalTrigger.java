package dev.majek.advancements.trigger;

import com.google.gson.JsonObject;
import dev.majek.advancements.shared.EntityObject;
import dev.majek.advancements.util.JsonBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Fires whenever the player tames an animal.
 */
public class TameAnimalTrigger extends Trigger {

	private EntityObject entity;
	
	public TameAnimalTrigger() {
		super(Type.TAME_ANIMAL);
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
	public @NotNull TameAnimalTrigger entity(final @Nullable EntityObject entity) {
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
