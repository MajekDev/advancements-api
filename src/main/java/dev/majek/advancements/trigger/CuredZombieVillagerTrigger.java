package dev.majek.advancements.trigger;

import com.google.gson.JsonObject;
import dev.majek.advancements.shared.EntityObject;
import dev.majek.advancements.util.JsonBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Fires whenever a zombie villager turns into a villager. The player that had fed the zombie the golden apple will be the one fulfilling the trigger.
 */
public class CuredZombieVillagerTrigger extends Trigger {

	private EntityObject zombie;
	private EntityObject villager;
	
	public CuredZombieVillagerTrigger() {
		super(Type.CURED_ZOMBIE_VILLAGER);
	}
	
	/**
	 * @return information about the zombie villager that was converted or null, if none was specified
	 */
	public @Nullable EntityObject zombie() {
		return this.zombie;
	}
	
	/**
	 * @return information about the villager that was just created or null, if none was specified
	 */
	public @Nullable EntityObject villager() {
		return this.villager;
	}

	/**
	 * @param zombie information about the zombie villager that was converted or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	public @NotNull CuredZombieVillagerTrigger zombie(final @Nullable EntityObject zombie) {
		this.zombie = zombie;
		return this;
	}
	
	/**
	 * @param villager information about the villager that was just created or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	public @NotNull CuredZombieVillagerTrigger villager(final @Nullable EntityObject villager) {
		this.villager = villager;
		return this;
	}

	@Override
	protected @NotNull JsonObject conditions() {
		return new JsonBuilder()
				.add("zombie", zombie)
				.add("villager", villager)
				.build();
	}
}
