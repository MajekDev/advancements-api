package dev.majek.advancements.trigger;

import com.google.gson.JsonObject;
import dev.majek.advancements.shared.EntityObject;
import dev.majek.advancements.shared.SharedObject;
import dev.majek.advancements.util.JsonBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Fires when a lightning bolt summoned from the Channeling enchantment strikes an enemy.
 */
public class ChanneledLightningTrigger extends Trigger {

	private List<EntityObject> victims;
	
	public ChanneledLightningTrigger() {
		super(Type.CHANNELED_LIGHTNING);
	}

	/**
	 * @return immutable list of entities that must be struck
	 */
	public @NotNull List<EntityObject> victims() {
		return this.victims == null ? Collections.emptyList() : Collections.unmodifiableList(this.victims);
	}

	/**
	 * @param victim an entity that must be struck
	 * @return the current trigger for chaining
	 */
	public @NotNull ChanneledLightningTrigger addVictim(final @NotNull EntityObject victim) {
		if (this.victims == null) {
			this.victims = new ArrayList<>();
		}
		this.victims.add(victim);
		return this;
	}
	
	/**
	 * @param victim an entity that no longer needs to be struck
	 * @return the current trigger for chaining
	 */
	public @NotNull ChanneledLightningTrigger removeVictim(final @NotNull EntityObject victim) {
		if (this.victims != null) {
			this.victims.remove(victim);
		}
		return this;
	}

	@Override
	protected @NotNull JsonObject conditions() {
		return new JsonBuilder()
				.add("victims", victims, SharedObject::toJson)
				.build();
	}
}
