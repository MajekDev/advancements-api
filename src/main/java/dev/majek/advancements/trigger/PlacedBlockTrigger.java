package dev.majek.advancements.trigger;

import com.google.gson.JsonObject;
import dev.majek.advancements.shared.BlockObject;
import dev.majek.advancements.shared.ItemObject;
import dev.majek.advancements.shared.LocationObject;
import dev.majek.advancements.util.JsonBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Fires whenever the player places a block.
 */
public class PlacedBlockTrigger extends Trigger {

	private BlockObject block;
	private ItemObject item;
	private LocationObject location;
	
	public PlacedBlockTrigger() {
		super(Type.PLACED_BLOCK);
	}
	
	/**
	 * @return information about the newly placed block or null, if none was specified
	 */
	public @Nullable BlockObject block() {
		return this.block;
	}
	
	/**
	 * @return information about the item which was used to create the block or null, if none was specified
	 */
	public @Nullable ItemObject item() {
		return this.item;
	}
	
	/**
	 * @return information about the location where the block was placed or null, if none was specified
	 */
	public @Nullable LocationObject location() {
		return this.location;
	}
	
	/**
	 * @param block information about the newly placed block or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	public @NotNull PlacedBlockTrigger block(final @Nullable BlockObject block) {
		this.block = block;
		return this;
	}
	
	/**
	 * @param location information about the item which was used to create the block or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	public @NotNull PlacedBlockTrigger location(final @Nullable LocationObject location) {
		this.location = location;
		return this;
	}
	
	/**
	 * @param item information about the location where the block was placed or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	public @NotNull PlacedBlockTrigger item(final @Nullable ItemObject item) {
		this.item = item;
		return this;
	}

	@Override
	protected @NotNull JsonObject conditions() {
		return (block == null ? new JsonBuilder() : new JsonBuilder(block.toJson()))
				.add("item", item)
				.add("location", location)
				.build();
	}
}
