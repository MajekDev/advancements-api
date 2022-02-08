package dev.majek.advancements.trigger;

import com.google.gson.JsonObject;
import dev.majek.advancements.shared.ItemObject;
import dev.majek.advancements.shared.RangeObject;
import dev.majek.advancements.shared.SharedObject;
import dev.majek.advancements.util.JsonBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Fires whenever items are added to or removed from the player's inventory.
 */
public class InventoryChangedTrigger extends Trigger {

	private RangeObject occupied;
	private RangeObject full;
	private RangeObject empty;
	private Set<ItemObject> items;
	
	public InventoryChangedTrigger() {
		super(Type.INVENTORY_CHANGED);
	}
	
	/**
	 * @return the amount of slots which have items in them or null, if none was specified
	 */
	public @Nullable RangeObject occupied() {
		return this.occupied;
	}
	
	/**
	 * @return the amount of slots which have full stacks of items in them or null, if none was specified
	 */
	public @Nullable RangeObject full() {
		return this.full;
	}
	
	/**
	 * @return the amount of slots which have no items in them or null, if none was specified
	 */
	public @Nullable RangeObject empty() {
		return this.empty;
	}
	
	/**
	 * @return items which the inventory contains
	 */
	public @NotNull Set<ItemObject> items() {
		return this.items == null ? Collections.emptySet() : Collections.unmodifiableSet(this.items);
	}

	/**
	 * @param occupied the amount of slots which have items in them or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	public @NotNull InventoryChangedTrigger occupied(final @Nullable RangeObject occupied) {
		this.occupied = occupied;
		return this;
	}
	
	/**
	 * @param full the amount of slots which have full stacks of items in them or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	public @NotNull InventoryChangedTrigger full(final @Nullable RangeObject full) {
		this.full = full;
		return this;
	}
	
	/**
	 * @param empty the amount of slots which have no items in them or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	public @NotNull InventoryChangedTrigger empty(final @Nullable RangeObject empty) {
		this.empty = empty;
		return this;
	}
	
	/**
	 * @param item the item to add to the list of items which the inventory contains
	 * @return the current trigger for chaining
	 */
	public @NotNull InventoryChangedTrigger addItem(final @NotNull ItemObject item) {
		if (this.items == null) {
			this.items = new HashSet<>();
		}
		this.items.add(item);
		return this;
	}
	
	/**
	 * @param item the item to removed from the list of items which the inventory contains
	 * @return the current trigger for chaining
	 */
	public @NotNull InventoryChangedTrigger removeItem(final @NotNull ItemObject item) {
		if (this.items != null) {
			this.items.remove(item);
		}
		return this;
	}

	@Override
	protected @NotNull JsonObject conditions() {
		JsonBuilder json = new JsonBuilder();
		if (occupied != null || full != null || empty != null) {
			json.add("slots", new JsonBuilder()
					.add("occupied", occupied)
					.add("full", full)
					.add("empty", empty)
					.build());
		}
		
		return json.add("items", items, SharedObject::toJson)
				.build();
	}
}
