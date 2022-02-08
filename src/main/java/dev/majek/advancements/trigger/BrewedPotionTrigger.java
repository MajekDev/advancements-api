package dev.majek.advancements.trigger;

import com.google.gson.JsonObject;
import dev.majek.advancements.shared.Potion;
import dev.majek.advancements.util.JsonBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Fires whenever any (!) item is taken out of the output of a brewing stand.
 */
public class BrewedPotionTrigger extends Trigger {

	private Potion potion;
	
	public BrewedPotionTrigger() {
		super(Type.BREWED_POTION);
	}
	
	/**
	 * @return the taken out item's potion identifier or null, if none was specified.
	 * If the item is not a potion, it's id is {@link Potion#EMPTY}
	 */
	public @Nullable Potion potion() {
		return this.potion;
	}
	
	/**
	 * @param potion the taken out item's potion identifier or null, if it should be cleared. If the item is not a potion, it's id is {@link Potion#EMPTY}
	 * @return the current trigger for chaining
	 */
	public @NotNull BrewedPotionTrigger potion(final @Nullable Potion potion) {
		this.potion = potion;
		return this;
	}

	@Override
	protected @NotNull JsonObject conditions() {
		return new JsonBuilder()
				.add("potion", potion)
				.build();
	}
}
