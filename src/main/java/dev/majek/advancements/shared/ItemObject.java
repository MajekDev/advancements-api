package dev.majek.advancements.shared;

import com.google.gson.JsonObject;
import dev.majek.advancements.util.JsonBuilder;
import dev.majek.advancements.util.Validator;
import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Specifies information about an item. Apart from triggers, also used to specify the icon of advancements.
 * If this item object acts as an icon, the item's type must be specified (and mustn't be null): {@link #item(Material)}.
 * For icons only the {@code data} and {@code item} properties have effect.
 */
public class ItemObject extends SharedObject {

	private Material item;
	private RangeObject durability;
	private RangeObject count;
	private Potion potion;
	private Set<EnchantmentObject> enchantments;
	private String nbt;

	private ItemObject(final Material item) {
		this.item = item;
	}

	public static @NotNull ItemObject empty() {
		return new ItemObject(null);
	}

	public static @NotNull ItemObject icon(final @NotNull Material item) {
		return new ItemObject(item);
	}

	/**
	 * @return the item's type or null, if none was specified
	 */
	public @Nullable Material item() {
		return this.item;
	}
	
	/**
	 * @return the item's durability or null, if none was specified
	 */
	public @Nullable RangeObject durability() {
		return this.durability;
	}
	
	/**
	 * @return the item's count or null, if none was specified
	 */
	public @Nullable RangeObject count() {
		return this.count;
	}
	
	/**
	 * @return the item's potion data or null, if none was specified
	 */
	public @Nullable Potion potion() {
		return this.potion;
	}
	
	/**
	 * @return the item's applied enchantments
	 */
	public @Nullable Set<EnchantmentObject> enchantments() {
		return this.enchantments == null ? Collections.emptySet() : Collections.unmodifiableSet(this.enchantments);
	}
	
	/**
	 * @return the item's NBT string (starting and ending with curly braces) or null, if none was specified
	 */
	public @Nullable String nbt() {
		return this.nbt;
	}
	
	/**
	 * @param item the type of the item or null, if it should be cleared
	 * @return the current item object for chaining
	 */
	public @NotNull ItemObject item(final @Nullable Material item) {
		this.item = item;
		return this;
	}
	
	/**
	 * @param durability the item's durability or null, if it should be cleared
	 * @return the current item object for chaining
	 */
	public @NotNull ItemObject durability(final @Nullable RangeObject durability) {
		this.durability = durability;
		return this;
	}
	
	/**
	 * @param count the item's count or null, if it should be cleared
	 * @return the current item object for chaining
	 */
	public @NotNull ItemObject count(final @Nullable RangeObject count) {
		this.count = count;
		return this;
	}
	
	/**
	 * @param potion the potion data of the item or null, if it should be cleared
	 * @return the current item object for chaining
	 */
	public @NotNull ItemObject potion(final @Nullable Potion potion) {
		this.potion = potion;
		return this;
	}
	
	/**
	 * @param enchantment the enchantment which should be added to the item's applied enchantments
	 * @return the current item object for chaining
	 */
	public @NotNull ItemObject addEnchantment(final @NotNull EnchantmentObject enchantment) {
		if (this.enchantments == null) {
			this.enchantments = new HashSet<>();
		}
		this.enchantments.add(enchantment);
		return this;
	}
	
	/**
	 * @param enchantment the enchantment which should be removed from the item's applied enchantments
	 * @return the current item object for chaining
	 */
	public @NotNull ItemObject removeEnchant(final @NotNull EnchantmentObject enchantment) {
		if (this.enchantments != null) {
			this.enchantments.remove(enchantment);
		}
		return this;
	}
	
	/**
	 * @param nbt the NBT string of the item (starting and ending with curly braces) or null, if it should be cleared
	 * @return the current item object for chaining
	 */
	public @NotNull ItemObject nbt(final @Nullable String nbt) {
		Validator.nbt(nbt);
		this.nbt = nbt;
		return this;
	}

	/**
	 * @return the Json representation of the item object
	 */
	@Override
	public @NotNull JsonObject toJson() {
		return new JsonBuilder()
				.add("item", item)
				.add("durability", durability)
				.add("count", count)
				.add("nbt", nbt)
				.add("potion", potion)
				.add("enchantments", enchantments, SharedObject::toJson)
				.build();
	}
}
