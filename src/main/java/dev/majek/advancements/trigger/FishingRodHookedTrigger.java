package dev.majek.advancements.trigger;

import com.google.gson.JsonObject;
import dev.majek.advancements.shared.EntityObject;
import dev.majek.advancements.shared.ItemObject;
import dev.majek.advancements.util.JsonBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Fires when a player reels back a fishing rod when it was either attached
 * to another entity or when successfully fishing up an item.
 */
public class FishingRodHookedTrigger extends Trigger {

	private ItemObject rod;
	private EntityObject entity;
	private ItemObject item;
	
	public FishingRodHookedTrigger() {
		super(Type.FISHING_ROD_HOOKED);
	}

	/**
	 * @return the fishing rod used by the player or null, if none was specified
	 */
	public @Nullable ItemObject rod() {
		return this.rod;
	}
	
	/**
	 * @return the hooked entity or null, if none was specified
	 */
	public @Nullable EntityObject entity() {
		return this.entity;
	}
	
	/**
	 * @return the fished up item or null, if none was specified
	 */
	public @Nullable ItemObject item() {
		return this.item;
	}

	/**
	 * @param rod the fishing rod used by the player or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	public @NotNull FishingRodHookedTrigger rod(final @Nullable ItemObject rod) {
		this.rod = rod;
		return this;
	}
	
	/**
	 * @param entity the hooked entity or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	public @NotNull FishingRodHookedTrigger entity(final @Nullable EntityObject entity) {
		this.entity = entity;
		return this;
	}
	
	/**
	 * @param item the fished up item or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	public @NotNull FishingRodHookedTrigger item(final @Nullable ItemObject item) {
		this.item = item;
		return this;
	}

	@Override
	protected @NotNull JsonObject conditions() {
		return new JsonBuilder()
				.add("rod", rod)
				.add("entity", entity)
				.add("item", item)
				.build();
	}
}
