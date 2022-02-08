package dev.majek.advancements.trigger;

import com.google.gson.JsonObject;
import dev.majek.advancements.shared.ItemObject;
import dev.majek.advancements.util.JsonBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Fires when a player fires a crossbow.
 */
public class ShotCrossbowTrigger extends Trigger {

	private ItemObject item;
	
	public ShotCrossbowTrigger() {
		super(Type.SHOT_CROSSBOW);
	}
	
	/**
	 * @return the crossbow before the projectile was fired or null, if none was specified
	 */
	public @Nullable ItemObject item() {
		return this.item;
	}
	
	/**
	 * @param item the crossbow before the projectile was fired or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	public @NotNull ShotCrossbowTrigger item(final @Nullable ItemObject item) {
		this.item = item;
		return this;
	}

	@Override
	protected @NotNull JsonObject conditions() {
		return new JsonBuilder()
				.add("item", item)
				.build();
	}
}
