package dev.majek.advancements.trigger;

import com.google.gson.JsonObject;
import dev.majek.advancements.shared.ItemObject;
import dev.majek.advancements.util.JsonBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Fires whenever the player uses a Totem of Undying.
 */
public class UsedTotemTrigger extends Trigger {

	private ItemObject item;
	
	public UsedTotemTrigger() {
		super(Type.USED_TOTEM);
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
	public @NotNull UsedTotemTrigger item(final @Nullable ItemObject item) {
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
