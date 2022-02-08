package dev.majek.advancements.shared;

import com.google.gson.JsonObject;
import dev.majek.advancements.util.JsonBuilder;
import org.bukkit.StructureType;
import org.bukkit.block.Biome;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Specifies information about a location in any world.
 */
public class LocationObject extends SharedObject {

	private RangeObject x;
	private RangeObject y;
	private RangeObject z;
	private Biome biome;
	private StructureType feature;
	private Dimension dimension;
	
	/**
	 * @return the x coordinate component or null, if none is specified
	 */
	public @Nullable RangeObject x() {
		return this.x;
	}
	
	/**
	 * @return the y coordinate component or null, if none is specified
	 */
	public @Nullable RangeObject y() {
		return this.y;
	}
	
	/**
	 * @return the z coordinate component or null, if none is specified
	 */
	public @Nullable RangeObject z() {
		return this.z;
	}
	
	/**
	 * @return the biome or null, if none is specified
	 */
	public @Nullable Biome biome() {
		return this.biome;
	}
	
	/**
	 * @return the feature or null, if none is specified
	 */
	public @Nullable StructureType feature() {
		return this.feature;
	}
	
	/**
	 * @return the dimension or null, if none is specified
	 */
	public @Nullable Dimension dimension() {
		return this.dimension;
	}
	
	/**
	 * @param x the x coordinate component or null, if it should be cleared
	 * @return the current location object for chaining
	 */
	public @NotNull LocationObject x(final @Nullable RangeObject x) {
		this.x = x;
		return this;
	}
	
	/**
	 * @param y the y coordinate component or null, if it should be cleared
	 * @return the current location object for chaining
	 */
	public @NotNull LocationObject y(final @Nullable RangeObject y) {
		this.y = y;
		return this;
	}
	
	/**
	 * @param z the z coordinate component or null, if it should be cleared
	 * @return the current location object for chaining
	 */
	public @NotNull LocationObject z(final @Nullable RangeObject z) {
		this.z = z;
		return this;
	}
	
	/**
	 * @param biome the biome, or null if it should be cleared
	 * @return the current location object for chaining
	 */
	public @NotNull LocationObject biome(final @Nullable Biome biome) {
		this.biome = biome;
		return this;
	}
	
	/**
	 * @param feature the feature, or null if it should be cleared
	 * @return the current location object for chaining
	 */
	public @NotNull LocationObject feature(final @Nullable StructureType feature) {
		this.feature = feature;
		return this;
	}
	
	/**
	 * @param dimension the dimension, or null if it should be cleared
	 * @return the current location object for chaining
	 */
	public @NotNull LocationObject dimension(final @Nullable Dimension dimension) {
		this.dimension = dimension;
		return this;
	}
	
	/**
	 * @return the JSON representation of the location object
	 */
	@Override
	public @NotNull JsonObject toJson() {
		JsonBuilder builder = new JsonBuilder();
		if (x != null || y != null || z != null) {
			builder.add("position", new JsonBuilder().add("x", x).add("y", y).add("z", z).build());
		}
		if (feature != null) {
			builder.add("feature", "minecraft:" + feature.getName());
		}
		return builder
				.add("biome", biome)
				.add("dimension", dimension)
				.build();
	}
}
