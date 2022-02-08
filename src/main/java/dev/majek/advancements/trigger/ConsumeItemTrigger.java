package dev.majek.advancements.trigger;

import com.google.gson.JsonObject;
import dev.majek.advancements.shared.ItemObject;
import dev.majek.advancements.util.JsonBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Fires whenever the player eats food, drinks milk or a potion/water bottle.
 */
public class ConsumeItemTrigger extends Trigger {

	private ItemObject item;
	
	public ConsumeItemTrigger() {
		super(Type.CONSUME_ITEM);
	}

	/**
	 * @return information about the item before it was consumed or null, if none was specified
	 */
	public @Nullable ItemObject item() {
		return this.item;
	}
	
	/**
	 * @param item information about the item before it was consumed or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	public @NotNull ConsumeItemTrigger setItem(final @Nullable ItemObject item) {
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
