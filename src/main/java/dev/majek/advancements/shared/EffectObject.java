package dev.majek.advancements.shared;

import com.google.gson.JsonObject;
import dev.majek.advancements.util.JsonBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Specifies information about a single applied status effect.
 */
public class EffectObject extends SharedObject {

	private RangeObject amplifier;
	private RangeObject duration;
	private Boolean ambient;
	private Boolean visible;

	/**
	 * @return the amplifier or null, if none was specified
	 */
	public @Nullable RangeObject amplifier() {
		return this.amplifier;
	}
	
	/**
	 * @return the duration or null, if none was specified
	 */
	public @Nullable RangeObject duration() {
		return this.duration;
	}
	
	/**
	 * @return whether the effect is ambient or null, if it wasn't specified
	 */
	public @Nullable Boolean ambient() {
		return this.ambient;
	}
	
	/**
	 * @return whether the effect is visible or null, if it wasn't specified
	 */
	public @Nullable Boolean visible() {
		return this.visible;
	}
	
	/**
	 * @param amplifier the amplifier or null, if it should be cleared
	 * @return the current effect object for chaining
	 */
	public @NotNull EffectObject amplifier(final @Nullable RangeObject amplifier) {
		this.amplifier = amplifier;
		return this;
	}
	
	/**
	 * @param duration the duration or null, if it should be cleared
	 * @return the current effect object for chaining
	 */
	public @NotNull EffectObject duration(final @Nullable RangeObject duration) {
		this.duration = duration;
		return this;
	}
	
	/**
	 * @param ambient whether the effect is ambient or null, if it should be cleared
	 * @return the current effect object for chaining
	 */
	public @NotNull EffectObject ambient(final @Nullable Boolean ambient) {
		this.ambient = ambient;
		return this;
	}
	
	/**
	 * @param visible whether the effect is visible or null, if it should be cleared
	 * @return the current effect object for chaining
	 */
	public @NotNull EffectObject visible(final @Nullable Boolean visible) {
		this.visible = visible;
		return this;
	}
	
	/**
	 * @return the Json representation of the effect object
	 */
	@Override
	public @NotNull JsonObject toJson() {
		return new JsonBuilder()
				.add("amplifier", amplifier)
				.add("duration", duration)
				.add("ambient", ambient)
				.add("visible", visible)
				.build();
	}
}
