package dev.majek.advancements.trigger;

import com.google.gson.JsonObject;
import dev.majek.advancements.util.JsonBuilder;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

/**
 * Fires whenever the player unlocks a recipe. The trigger is invalid without the {@code recipe} property,
 * therefore it must be assigned in the constructor.
 */
public class RecipeUnlockedTrigger extends Trigger {

	private final NamespacedKey recipe;
	
	/**
	 * @param recipe the recipe which must be unlocked
	 */
	public RecipeUnlockedTrigger(@NotNull NamespacedKey recipe) {
		super(Type.RECIPE_UNLOCKED);
		this.recipe = recipe;
	}
	
	/**
	 * @return the recipe's id which must be unlocked
	 */
	public @NotNull NamespacedKey getRecipe() {
		return this.recipe;
	}

	@Override
	protected @NotNull JsonObject conditions() {
		return new JsonBuilder()
				.add("recipe", recipe)
				.build();
	}
}
