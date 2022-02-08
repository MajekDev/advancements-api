package dev.majek.advancements.shared;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import dev.majek.advancements.util.JsonBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Specifies a range of values. Both endpoints are inclusive.
 */
public class RangeObject extends SharedObject {

	private Number min;
	private Number max;
	
	/**
	 * @return the lower bound or null, if none is specified
	 */
	public @Nullable Number min() {
		return this.min;
	}
	
	/**
	 * @return the upper bound or null, if none is specified
	 */
	public @Nullable Number max() {
		return this.max;
	}

	/**
	 * @param min the lower bound or null, if it should be cleared
	 * @return the current range object for chaining
	 */
	public @NotNull RangeObject min(final @Nullable Number min) {
		this.min = min;
		return this;
	}
	
	/**
	 * @param max the upper bound or null, if it should be cleared
	 * @return the current range object for chaining
	 */
	public @NotNull RangeObject max(final @Nullable Number max) {
		this.max = max;
		return this;
	}
	
	/**
	 * @param exact the value which is to be assigned to both the lower and the upper bounds
	 * @return the current range object for chaining
	 */
	public @NotNull RangeObject exact(final @Nullable Number exact) {
		min = exact;
		max = exact;
		return this;
	}
	
	/**
	 * @return the Json representation of the range object
	 */
	@Override
	public @NotNull JsonElement toJson() {
		if (min != null && min.equals(max)) {
			return new JsonPrimitive(min);
		}
		return new JsonBuilder()
				.add("min", min)
				.add("max", max)
				.build();
	}
}
