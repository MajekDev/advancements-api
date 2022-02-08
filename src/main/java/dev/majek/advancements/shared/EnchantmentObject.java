package dev.majek.advancements.shared;

import com.google.gson.JsonElement;
import dev.majek.advancements.util.JsonBuilder;
import org.bukkit.enchantments.Enchantment;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Specifies information about an enchantment applied to an item.
 * @see ItemObject
 */
public class EnchantmentObject extends SharedObject {

	private Enchantment enchantment;
	private RangeObject levels;
	
	/**
	 * @return the enchantment or null, if none was specified
	 */
	public @Nullable Enchantment enchantment() {
		return this.enchantment;
	}
	
	/**
	 * @return the level of the enchantment or null, if none was specified
	 */
	public @Nullable RangeObject levels() {
		return this.levels;
	}

	/**
	 * @param enchantment the enchantment or null, if it should be cleared
	 * @return the current block object for chaining
	 */
	public @NotNull EnchantmentObject enchantment(final @Nullable Enchantment enchantment) {
		this.enchantment = enchantment;
		return this;
	}
	
	/**
	 * @param levels the level of the enchantment or null, if it should be cleared
	 * @return the current block object for chaining
	 */
	public @NotNull EnchantmentObject levels(final @Nullable RangeObject levels) {
		this.levels = levels;
		return this;
	}

	/**
	 * @return the JSON representation of the enchantment object
	 */
	@Override
	public @NotNull JsonElement toJson() {
		return new JsonBuilder() // empty JsonObject -> any enchantment
				.add("enchantment", enchantment)
				.add("levels", levels)
				.build();
	}
}
