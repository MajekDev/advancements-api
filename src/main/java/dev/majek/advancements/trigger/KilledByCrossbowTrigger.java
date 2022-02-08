package dev.majek.advancements.trigger;

import com.google.gson.JsonObject;
import dev.majek.advancements.shared.EntityObject;
import dev.majek.advancements.shared.SharedObject;
import dev.majek.advancements.util.JsonBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Fires when a player kills a mob with a projectile shot from a crossbow.
 */
public class KilledByCrossbowTrigger extends Trigger {

	private Integer uniqueEntityTypes;
	private List<EntityObject> victims;
	
	public KilledByCrossbowTrigger() {
		super(Type.KILLED_BY_CROSSBOW);
	}

	/**
	 * @return the minimum count of unique entity types hit with the projectile or null, if none was specified
	 */
	public @Nullable Integer uniqueEntityTypes() {
		return this.uniqueEntityTypes;
	}
	
	/**
	 * @return the immutable list of entities that must be hit
	 */
	public @NotNull List<EntityObject> victims() {
		return this.victims == null ? Collections.emptyList() : Collections.unmodifiableList(this.victims);
	}

	/**
	 * @param uniqueEntityTypes the minimum count of unique entity types
	 * hit with the projectile or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	public @NotNull KilledByCrossbowTrigger uniqueEntityTypes(final @Nullable Integer uniqueEntityTypes) {
		this.uniqueEntityTypes = uniqueEntityTypes;
		return this;
	}
	
	/**
	 * @param victim an entity that must be hit
	 * @return the current trigger for chaining
	 */
	public @NotNull KilledByCrossbowTrigger addVictim(final @NotNull EntityObject victim) {
		if (this.victims == null) {
			this.victims = new ArrayList<>();
		}
		this.victims.add(victim);
		return this;
	}
	
	/**
	 * @param victim an entity that no longer needs to be hit
	 * @return the current trigger (for chaining)
	 */
	public @NotNull KilledByCrossbowTrigger removeVictim(final @NotNull EntityObject victim) {
		if (this.victims != null) {
			this.victims.remove(victim);
		}
		return this;
	}

	@Override
	protected @NotNull JsonObject conditions() {
		return new JsonBuilder()
				.add("unique_entity_types", uniqueEntityTypes)
				.add("victims", victims, SharedObject::toJson)
				.build();
	}
}
