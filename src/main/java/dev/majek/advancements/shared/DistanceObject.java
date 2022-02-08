package dev.majek.advancements.shared;

import com.google.gson.JsonObject;
import dev.majek.advancements.util.JsonBuilder;
import org.apache.commons.lang.Validate;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Specifies information about a distance between two points.
 */
public class DistanceObject extends SharedObject {

	private RangeObject x;
	private RangeObject y;
	private RangeObject z;
	private RangeObject absolute;
	private RangeObject horizontal;
	
	/**
	 * @return the distance on the x-axis
	 */
	public @Nullable RangeObject x() {
		return this.x;
	}
	
	/**
	 * @return the distance on the y-axis
	 */
	public @Nullable RangeObject y() {
		return this.y;
	}
	
	/**
	 * @return the distance on the z-axis
	 */
	public @Nullable RangeObject z() {
		return this.z;
	}
	
	/**
	 * @return the distance on all axes
	 */
	public @Nullable RangeObject absolute() {
		return this.absolute;
	}
	
	/**
	 * @return the distance on the horizontal axes
	 */
	public @Nullable RangeObject horizontal() {
		return this.horizontal;
	}
	
	/**
	 * @param x the distance on the x-axis or null, if it should be cleared
	 * @return the current distance object for chaining
	 */
	public @NotNull DistanceObject x(final @Nullable RangeObject x) {
		this.x = x;
		return this;
	}
	
	/**
	 * @param y the distance on the y axis or null, if it should be cleared
	 * @return the current distance object for chaining
	 */
	public @NotNull DistanceObject y(final @Nullable RangeObject y) {
		this.y = y;
		return this;
	}
	
	/**
	 * @param z the distance on the z axis or null, if it should be cleared
	 * @return the current distance object for chaining
	 */
	public @NotNull DistanceObject z(final @Nullable RangeObject z) {
		this.z = z;
		return this;
	}
	
	/**
	 * @param absolute the distance on all axises or null, if it should be cleared
	 * @return the current distance object for chaining
	 */
	public @NotNull DistanceObject absolute(final @Nullable RangeObject absolute) {
		this.absolute = absolute;
		return this;
	}
	
	/**
	 * @param horizontal the distance on the horizontal axises or null, if it should be cleared
	 * @return the current distance object for chaining
	 */
	public @NotNull DistanceObject horizontal(final @Nullable RangeObject horizontal) {
		this.horizontal = horizontal;
		return this;
	}

	/**
	 * @return the Json representation of the distance object
	 */
	@Override
	public @NotNull JsonObject toJson() {
		boolean singleNotNull = x != null || y != null || z != null;
		Validate.isTrue((absolute == null && horizontal == null)
						|| (absolute == null && !singleNotNull)
						|| (horizontal == null && !singleNotNull),
				"Only one of the three options (x/y/z, absolute, horizontal) can be specified.");
		return new JsonBuilder()
				.add("x", x)
				.add("y", y)
				.add("z", z)
				.add("absolute", absolute)
				.add("horizontal", horizontal)
				.build();
	}
}
