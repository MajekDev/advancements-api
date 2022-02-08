package dev.majek.advancements.shared;

import com.google.gson.JsonElement;
import dev.majek.advancements.util.JsonBuilder;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Specifies information about a damage event.
 */
public class DamageObject extends SharedObject {

	private RangeObject dealt;
	private RangeObject taken;
	private Boolean blocked;
	private DamageFlagsObject flags;
	private EntityObject sourceEntity;
	
	/**
	 * @return the dealt damage (damage reduction modifiers (ex. armor) are not yet applied) or null, if none was specified
	 */
	public @Nullable RangeObject dealt() {
		return this.dealt;
	}
	
	/**
	 * @return the taken damage (damage reduction modifiers (ex. armor) are applied) or null, if none was specified
	 */
	public @Nullable RangeObject taken() {
		return this.taken;
	}
	
	/**
	 * @return whether the damage is blocked or null, if this wasn't specified
	 */
	public @Nullable Boolean blocked() {
		return this.blocked;
	}
	
	/**
	 * @return more information about the damage event or null, if none was specified
	 */
	public @Nullable DamageFlagsObject flags() {
		return this.flags;
	}
	
	/**
	 * @return information about the dealer of the damage or null, if none was specified
	 */
	public @Nullable EntityObject sourceEntity() {
		return this.sourceEntity;
	}

	/**
	 * @param dealt the dealt damage (damage reduction modifiers (ex. armor) are not yet applied) or null, if it should be cleared
	 * @return the current damage object for chaining
	 */
	public @NotNull DamageObject dealt(final @Nullable RangeObject dealt) {
		this.dealt = dealt;
		return this;
	}
	
	/**
	 * @param taken the taken damage (damage reduction modifiers (ex. armor) are applied) or null, if it should be cleared
	 * @return the current damage object for chaining
	 */
	public @NotNull DamageObject taken(final @Nullable RangeObject taken) {
		this.taken = taken;
		return this;
	}
	
	/**
	 * @param blocked whether the damage is blocked or null, if it should be cleared
	 * @return the current damage object for chaining
	 */
	public @NotNull DamageObject setBlocked(final @Nullable Boolean blocked) {
		this.blocked = blocked;
		return this;
	}
	
	/**
	 * @param flags more information about the damage event or null, if it should be cleared
	 * @return the current damage object for chaining
	 */
	public @NotNull DamageObject flags(final @Nullable DamageFlagsObject flags) {
		this.flags = flags;
		return this;
	}
	
	/**
	 * @param sourceEntity information about the dealer of the damage or null, if it should be cleared
	 * @return the current damage object for chaining
	 */
	public @NotNull DamageObject sourceEntity(final @Nullable EntityObject sourceEntity) {
		this.sourceEntity = sourceEntity;
		return this;
	}

	/**
	 * @return the Json representation of the damage object
	 */
	@Override
	public @NotNull JsonElement toJson() {
		return new JsonBuilder()
				.add("dealt", dealt)
				.add("taken", taken)
				.add("blocked", blocked)
				.add("type", flags)
				.add("source_entity", sourceEntity)
				.build();
	}
}
