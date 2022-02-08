package dev.majek.advancements.config;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import dev.majek.advancements.AdvancementIO;
import dev.majek.advancements.util.JsonBuilder;
import dev.majek.advancements.util.Validator;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Specifies rewards which are given when the advancement is completed.
 */
public class Rewards {

	private Set<NamespacedKey> recipes;
	private Set<NamespacedKey> loots;
	private int experience;
	private NamespacedKey function;

	private Rewards() {
		this.recipes = new HashSet<>();
		this.loots = new HashSet<>();
		this.experience = 0;
		this.function = null;
	}

	/**
	 * Create new rewards for an advancement.
	 *
	 * @return new rewards
	 */
	public static @NotNull Rewards create() {
		return new Rewards();
	}

	/**
	 * @return the id of the recipes which will unlock upon completion of the advancement
	 */
	public @NotNull Set<NamespacedKey> recipes() {
		return this.recipes == null ? Collections.emptySet() : Collections.unmodifiableSet(this.recipes);
	}
	
	/**
	 * @return the id of the loot tables from all of which items will be given upon completion of the advancement
	 */
	public @NotNull Set<NamespacedKey> loots() {
		return this.loots == null ? Collections.emptySet() : Collections.unmodifiableSet(this.loots);
	}
	
	/**
	 * @return the amount of experience which will be given upon completion of the advancement
	 */
	public int experience() {
		return this.experience;
	}
	
	/**
	 * @return the id of the function which will run upon completion of the advancement
	 */
	public @Nullable NamespacedKey getFunction() {
		return this.function;
	}

	/**
	 * @param recipe the id of the recipe which should be unlocked upon completion of the advancement
	 * @return the current rewards object for chaining
	 */
	public @NotNull Rewards addRecipe(final @NotNull NamespacedKey recipe) {
		if (this.recipes == null) {
			this.recipes = new HashSet<>();
		}
		this.recipes.add(recipe);
		return this;
	}
	
	/**
	 * @param recipe the id of the recipe which should be removed from the reward recipes
	 * @return the current rewards object for chaining
	 */
	public @NotNull Rewards removeRecipe(final @NotNull NamespacedKey recipe) {
		if (this.recipes != null) {
			this.recipes.remove(recipe);
		}
		return this;
	}
	
	/**
	 * @param loot the id of the loot table from which items should also be given
	 * @return the current rewards object for chaining
	 */
	public @NotNull Rewards addLoot(final @NotNull NamespacedKey loot) {
		if (this.loots == null) {
			this.loots = new HashSet<>();
		}
		this.loots.add(loot);
		return this;
	}
	
	/**
	 * @param loot the id of the loot table which should be removed from the reward loot tables
	 * @return the current rewards object for chaining
	 */
	public @NotNull Rewards removeLoot(final @NotNull NamespacedKey loot) {
		if (this.loots != null) {
			this.loots.remove(loot);
		}
		return this;
	}
	
	/**
	 * @param experience the amount of experience which should be given upon completion of the advancement
	 * @return the current rewards object for chaining
	 */
	public @NotNull Rewards experience(final int experience) {
		Validator.zeroToDisable(experience);
		this.experience = experience;
		return this;
	}
	
	/**
	 * Set a function to run on completion. This will activate the function if it is not null.
	 *
	 * @param function the id of the function which should be run upon completion of the advancement or null, if it should be cleared
	 * The player will be considered the sender - {@code @s} will point to the player
	 * @return the current rewards object for chaining
	 */
	public @NotNull Rewards function(final @Nullable MinecraftFunction function) {
		if (function == null) {
			this.function = null;
		} else {
			this.function = function.key();
			AdvancementIO.activateFunction(function);
		}
		return this;
	}

	/**
	 * @return the Json representation of the reward object
	 */
	public @NotNull JsonObject toJson() {
		return new JsonBuilder()
				.add("recipes", recipes, v -> new JsonPrimitive(v.toString()))
				.add("loot", loots, v -> new JsonPrimitive(v.toString()))
				.addPositive("experience", experience)
				.add("function", function)
				.build();
	}
}
