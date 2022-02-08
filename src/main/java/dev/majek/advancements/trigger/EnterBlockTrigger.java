package dev.majek.advancements.trigger;

import com.google.gson.JsonObject;
import dev.majek.advancements.shared.BlockObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Fires whenever a hitbox intersects with a block, including air, as well as the block
 * that an ender pearl had landed at. This trigger fires constantly.
 */
public class EnterBlockTrigger extends Trigger {

	private BlockObject block;
	
	public EnterBlockTrigger() {
		super(Type.ENTER_BLOCK);
	}
	
	/**
	 * @return information about the block the player is intersecting with or null, if none was specified
	 */
	public @Nullable BlockObject block() {
		return this.block;
	}
	
	/**
	 * @param block information about the block the player is intersecting with or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	public @NotNull EnterBlockTrigger block(final @Nullable BlockObject block) {
		this.block = block;
		return this;
	}

	@Override
	protected @NotNull JsonObject conditions() {
		return block == null ? new JsonObject() : block.toJson();
	}
}
