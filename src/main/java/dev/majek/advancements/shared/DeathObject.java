package dev.majek.advancements.shared;

import com.google.gson.JsonObject;
import dev.majek.advancements.util.JsonBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Specifies information about a death event.
 */
public class DeathObject extends SharedObject {

	private EntityObject entity;
	private DamageFlagsObject killingBlow;

	/**
	 * @return information about the entity which died or null, if none was specified
	 */
	public @Nullable EntityObject entity() {
		return this.entity;
	}
	
	/**
	 * @return information about the damage event which caused this death or null, if none was specified
	 */
	public @Nullable DamageFlagsObject killingBlow() {
		return this.killingBlow;
	}
	
	/**
	 * @param entity information about the entity which died or null, if it should be cleared
	 * @return the current death object for chaining
	 */
	public @NotNull DeathObject entity(final @Nullable EntityObject entity) {
		this.entity = entity;
		return this;
	}
	
	/**
	 * @param killingBlow information about the damage event or null, if it should be cleared
	 * @return the current death object for chaining
	 */
	public @NotNull DeathObject killingBlow(final @Nullable DamageFlagsObject killingBlow) {
		this.killingBlow = killingBlow;
		return this;
	}

	/**
	 * @return the Json representation of the death object
	 */
	@Override
	public @NotNull JsonObject toJson() {
		return new JsonBuilder()
				.add("entity", entity)
				.add("killing_bow", killingBlow)
				.build();
	}
}
