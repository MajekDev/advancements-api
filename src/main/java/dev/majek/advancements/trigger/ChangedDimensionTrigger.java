package dev.majek.advancements.trigger;

import com.google.gson.JsonObject;
import dev.majek.advancements.shared.Dimension;
import dev.majek.advancements.util.JsonBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Fires whenever the player switches to another dimension.
 */
public class ChangedDimensionTrigger extends Trigger {

	private Dimension to;
	private Dimension from;
	
	public ChangedDimensionTrigger() {
		super(Type.CHANGED_DIMENSION);
	}
	
	/**
	 * @return the dimension the player has just entered or null, if none was specified
	 */
	public @Nullable Dimension to() {
		return this.to;
	}
	
	/**
	 * @return the dimension the player has just left or null, if none was specified
	 */
	public @Nullable Dimension from() {
		return this.from;
	}

	/**
	 * @param to the dimension the player has just entered or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	public @NotNull ChangedDimensionTrigger to(final @Nullable Dimension to) {
		this.to = to;
		return this;
	}
	
	/**
	 * @param from the dimension the player has just left or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	public @NotNull ChangedDimensionTrigger from(final @Nullable Dimension from) {
		this.from = from;
		return this;
	}

	@Override
	protected @NotNull JsonObject conditions() {
		return new JsonBuilder()
				.add("to", to)
				.add("from", from)
				.build();
	}
}
