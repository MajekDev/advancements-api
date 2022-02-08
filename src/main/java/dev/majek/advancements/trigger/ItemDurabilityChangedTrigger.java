package dev.majek.advancements.trigger;

import com.google.gson.JsonObject;
import dev.majek.advancements.shared.ItemObject;
import dev.majek.advancements.shared.RangeObject;
import dev.majek.advancements.util.JsonBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Fires whenever any item's durability in the player's inventory changes.
 */
public class ItemDurabilityChangedTrigger extends Trigger {

	private ItemObject item;
	private RangeObject durability;
	private RangeObject delta;
	
	public ItemDurabilityChangedTrigger() {
		super(Type.ITEM_DURABILITY_CHANGED);
	}
	
	/**
	 * @return the item which durability changed or null, if none was specified
	 */
	public @Nullable ItemObject item() {
		return this.item;
	}
	
	/**
	 * @return the durability or null, if none was specified
	 */
	public @Nullable RangeObject durability() {
		return this.durability;
	}
	
	/**
	 * @return the durability change or null, if none was specified. The durability change is calculated by {@code new - old}
	 */
	public @Nullable RangeObject delta() {
		return this.delta;
	}
	
	/**
	 * @param item the item which durability changed or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	public @NotNull ItemDurabilityChangedTrigger item(final @Nullable ItemObject item) {
		this.item = item;
		return this;
	}
	
	/**
	 * @param durability the new durability or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	public @NotNull ItemDurabilityChangedTrigger durability(final @Nullable RangeObject durability) {
		this.durability = durability;
		return this;
	}
	
	/**
	 * @param delta the durability change or null, if it should be cleared. The durability change is calculated by {@code new - old}
	 * @return the current trigger for chaining
	 */
	public @NotNull ItemDurabilityChangedTrigger delta(final @Nullable RangeObject delta) {
		this.delta = delta;
		return this;
	}

	@Override
	protected @NotNull JsonObject conditions() {
		return new JsonBuilder()
				.add("item", item)
				.add("durability", durability)
				.add("delta", delta)
				.build();
	}
}
