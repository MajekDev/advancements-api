package dev.majek.advancements.trigger;

import com.google.gson.JsonObject;
import dev.majek.advancements.shared.EntityObject;
import dev.majek.advancements.shared.ItemObject;
import dev.majek.advancements.util.JsonBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Fires whenever the player completes a trade with a villager.
 * Shift clicking, therefore possibly completing the trade multiple times will only fire this trigger once.
 */
public class VillagerTradeTrigger extends Trigger {

	private EntityObject villager;
	private ItemObject item;
	
	public VillagerTradeTrigger() {
		super(Type.VILLAGER_TRADE);
	}
	
	/**
	 * @return information about the villager the player traded with or null, if none was specified
	 */
	public @Nullable EntityObject villager() {
		return this.villager;
	}
	
	/**
	 * @return the item the player had purchased. The count is the same for a shift click as for a normal click
	 */
	public @Nullable ItemObject item() {
		return this.item;
	}
	
	/**
	 * @param villager information about the villager the player traded with or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	public @NotNull VillagerTradeTrigger villager(final @Nullable EntityObject villager) {
		this.villager = villager;
		return this;
	}
	
	/**
	 * @param item the item the player had purchased or null, if it should be cleared. The count is the same for a shift click as for a normal click
	 * @return the current trigger for chaining
	 */
	public @NotNull VillagerTradeTrigger item(final @Nullable ItemObject item) {
		this.item = item;
		return this;
	}

	@Override
	protected @NotNull JsonObject conditions() {
		return new JsonBuilder()
				.add("villager", villager)
				.add("item", item)
				.build();
	}
}
