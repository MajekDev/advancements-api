package dev.majek.advancements.trigger;

import com.google.gson.JsonObject;
import dev.majek.advancements.shared.ItemObject;
import dev.majek.advancements.shared.RangeObject;
import dev.majek.advancements.util.JsonBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Fires whenever the player enchants an item. The item doesn't have to be taken out of the enchanting table.
 */
public class EnchantedItemTrigger extends Trigger {

	private ItemObject item;
	private RangeObject levels;
	
	public EnchantedItemTrigger() {
		super(Type.ENCHANTED_ITEM);
	}
	
	/**
	 * @return the item after it has been enchanted or null, if none was specified
	 */
	public @Nullable ItemObject item() {
		return this.item;
	}
	
	/**
	 * @return the number of levels the player used up to enchant the item or null, if none was specified
	 */
	public @Nullable RangeObject levels() {
		return this.levels;
	}

	/**
	 * @param item the item after it has been enchanted or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	public @NotNull EnchantedItemTrigger item(final @Nullable ItemObject item) {
		this.item = item;
		return this;
	}
	
	/**
	 * @param levels the number of levels the player used up to enchant the item or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	public @NotNull EnchantedItemTrigger levels(final @Nullable RangeObject levels) {
		this.levels = levels;
		return this;
	}

	@Override
	protected @NotNull JsonObject conditions() {
		return new JsonBuilder()
				.add("item", item)
				.add("levels", levels)
				.build();
	}
}
