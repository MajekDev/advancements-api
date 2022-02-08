package dev.majek.advancements.trigger;

import com.google.gson.JsonObject;
import dev.majek.advancements.shared.StatusEffectsObject;
import dev.majek.advancements.util.JsonBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Fires whenever the player receives or loses a status effect.
 */
public class EffectsChangedTrigger extends Trigger {

	private StatusEffectsObject effects;
	
	public EffectsChangedTrigger() {
		super(Type.EFFECTS_CHANGED);
	}
	
	/**
	 * @return the effects which the player has or null, if none was specified. The newly added/lost effect is unknown
	 */
	public @Nullable StatusEffectsObject effects() {
		return this.effects;
	}
	
	/**
	 * @param effects the effects which the player has or null, if it should be cleared. The newly added/lost effect cannot be explicitly specified
	 * @return the current trigger for chaining
	 */
	public @NotNull EffectsChangedTrigger effects(final @Nullable StatusEffectsObject effects) {
		this.effects = effects;
		return this;
	}

	@Override
	protected @NotNull JsonObject conditions() {
		return new JsonBuilder()
				.add("effects", effects)
				.build();
	}
}
