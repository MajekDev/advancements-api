package dev.majek.advancements.shared;

import com.google.gson.JsonObject;
import dev.majek.advancements.util.JsonBuilder;
import dev.majek.advancements.util.Validator;
import org.bukkit.entity.Cat;
import org.bukkit.entity.EntityType;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Specifies information about an entity.
 */
public class EntityObject extends SharedObject {

	private EntityType type;
	private DistanceObject distance;
	private LocationObject location;
	private StatusEffectsObject effects;
	private String nbt;
	private Boolean onFire;
	private Boolean sneaking;
	private Boolean sprinting;
	private Boolean swimming;
	private Boolean baby;
	private ItemObject head;
	private ItemObject chest;
	private ItemObject legs;
	private ItemObject feet;
	private ItemObject mainHand;
	private ItemObject offHand;
	private Cat.Type catType;
	
	/**
	 * @return the type of the entity or null, if none was specified
	 */
	public @Nullable EntityType type() {
		return this.type;
	}
	
	/**
	 * @return information about the distance of the entity or null, if none was specified
	 */
	public @Nullable DistanceObject distance() {
		return this.distance;
	}
	
	/**
	 * @return information about the location of the entity or null, if none was specified
	 */
	public @Nullable LocationObject location() {
		return this.location;
	}
	
	/**
	 * @return the status effects of the entity or null, if none was specified
	 */
	public @Nullable StatusEffectsObject effects() {
		return this.effects;
	}
	
	/**
	 * @return the NBT of the entity or null, if none was specified
	 */
	public @Nullable String nbt() {
		return this.nbt;
	}
	
	/**
	 * @return whether the entity is on fire or null, if unspecified
	 */
	public @Nullable Boolean onFire() {
		return this.onFire;
	}
	
	/**
	 * @return whether the entity is sneaking or null, if unspecified
	 */
	public @Nullable Boolean sneaking() {
		return this.sneaking;
	}
	
	/**
	 * @return whether the entity is sprinting or null, if unspecified
	 */
	public @Nullable Boolean sprinting() {
		return this.sprinting;
	}
	
	/**
	 * @return whether the entity is swimming or null, if unspecified
	 */
	public @Nullable Boolean swimming() {
		return this.swimming;
	}
	
	/**
	 * @return whether the entity is a baby or null, if unspecified
	 */
	public @Nullable Boolean baby() {
		return this.baby;
	}
	
	/**
	 * @return the item on the head of the entity or null, if none was specified
	 */
	public @Nullable ItemObject head() {
		return this.head;
	}
	
	/**
	 * @return the item on the chest of the entity or null, if none was specified
	 */
	public @Nullable ItemObject chest() {
		return this.chest;
	}
	
	/**
	 * @return the item on the legs of the entity or null, if none was specified
	 */
	public @Nullable ItemObject legs() {
		return this.legs;
	}
	
	/**
	 * @return the item on the feet of the entity or null, if none was specified
	 */
	public @Nullable ItemObject feet() {
		return this.feet;
	}
	
	/**
	 * @return the item in the main hand of the entity or null, if none was specified
	 */
	public @Nullable ItemObject mainHand() {
		return this.mainHand;
	}
	
	/**
	 * @return the item in the off hand of the entity or null, if none was specified
	 */
	public @Nullable ItemObject offHand() {
		return this.offHand;
	}
	
	/**
	 * @return the cat type of the entity or null, if none was specified
	 */
	public @Nullable Cat.Type catType() {
		return this.catType;
	}
	
	/**
	 * @param type the type of the entity or null, if it should be cleared
	 * @return the current entity object for chaining
	 */
	public @NotNull EntityObject type(final @Nullable EntityType type) {
		this.type = type;
		return this;
	}
	
	/**
	 * @param distance information about the distance of the entity or null, if it should be cleared
	 * @return the current entity object for chaining
	 */
	public @NotNull EntityObject distance(final @Nullable DistanceObject distance) {
		this.distance = distance;
		return this;
	}
	
	/**
	 * @param location information about the location of the entity or null, if it should be cleared
	 * @return the current entity object for chaining
	 */
	public @NotNull EntityObject location(final @Nullable LocationObject location) {
		this.location = location;
		return this;
	}
	
	/**
	 * @param effects the status effects of the entity or null, if it should be cleared
	 * @return the current entity object for chaining
	 */
	public @NotNull EntityObject effects(final @Nullable StatusEffectsObject effects) {
		this.effects = effects;
		return this;
	}
	
	/**
	 * @param nbt the NBT string of the entity (starting and ending with curly braces) or null, if it should be cleared
	 * @return the current entity object for chaining
	 */
	public @NotNull EntityObject nbt(final @Nullable String nbt) {
		Validator.nbt(nbt);
		this.nbt = nbt;
		return this;
	}
	
	/**
	 * @param onFire the on fire status or null, if it should be cleared
	 * @return the current entity object for chaining
	 */
	public @NotNull EntityObject onFire(final @Nullable Boolean onFire) {
		this.onFire = onFire;
		return this;
	}
	
	/**
	 * @param sneaking the sneaking status or null, if it should be cleared
	 * @return the current entity object for chaining
	 */
	public @NotNull EntityObject sneaking(final @Nullable Boolean sneaking) {
		this.sneaking = sneaking;
		return this;
	}
	
	/**
	 * @param sprinting the sprinting status or null, if it should be cleared
	 * @return the current entity object for chaining
	 */
	public @NotNull EntityObject sprinting(final @Nullable Boolean sprinting) {
		this.sprinting = sprinting;
		return this;
	}
	
	/**
	 * @param swimming the swimming status or null, if it should be cleared
	 * @return the current entity object for chaining
	 */
	public @NotNull EntityObject swimming(final @Nullable Boolean swimming) {
		this.swimming = swimming;
		return this;
	}
	
	/**
	 * @param baby the baby status or null, if it should be cleared
	 * @return the current entity object for chaining
	 */
	public @NotNull EntityObject baby(final @Nullable Boolean baby) {
		this.baby = baby;
		return this;
	}
	
	/**
	 * @param head the item on the head or null, if it should be cleared
	 * @return the current entity object for chaining
	 */
	public @NotNull EntityObject head(final @Nullable ItemObject head) {
		this.head = head;
		return this;
	}
	
	/**
	 * @param chest the item on the chest or null, if it should be cleared
	 * @return the current entity object for chaining
	 */
	public @NotNull EntityObject chest(final @Nullable ItemObject chest) {
		this.chest = chest;
		return this;
	}
	
	/**
	 * @param legs the item on the legs or null, if it should be cleared
	 * @return the current entity object for chaining
	 */
	public @NotNull EntityObject legs(final @Nullable ItemObject legs) {
		this.legs = legs;
		return this;
	}
	
	/**
	 * @param feet the item on the feet or null, if it should be cleared
	 * @return the current entity object for chaining
	 */
	public @NotNull EntityObject feet(final @Nullable ItemObject feet) {
		this.feet = feet;
		return this;
	}
	
	/**
	 * @param mainHand the item in the main hand or null, if it should be cleared
	 * @return the current entity object for chaining
	 */
	public @NotNull EntityObject mainHand(final @Nullable ItemObject mainHand) {
		this.mainHand = mainHand;
		return this;
	}
	
	/**
	 * @param offHand the item in the off hand or null, if it should be cleared
	 * @return the current entity object for chaining
	 */
	public @NotNull EntityObject offHand(final @Nullable ItemObject offHand) {
		this.offHand = offHand;
		return this;
	}
	
	/**
	 * @param catType the cat type or null, if it should be cleared
	 * @return the current entity object for chaining
	 */
	public @NotNull EntityObject catType(final @Nullable Cat.Type catType) {
		this.catType = catType;
		return this;
	}

	/**
	 * @return the Json representation of the entity object
	 */
	@Override
	public @NotNull JsonObject toJson() {
		JsonBuilder builder = new JsonBuilder()
				.add("type", type)
				.add("distance", distance)
				.add("location", location)
				.add("effects", effects)
				.add("nbt", nbt);
		
		if (onFire != null || sneaking != null || sprinting != null || swimming != null || baby != null) {
			builder.add("flags", new JsonBuilder()
					.add("is_on_fire", onFire)
					.add("is_sneaking", sneaking)
					.add("is_sprinting", sprinting)
					.add("is_swimming", swimming)
					.add("is_baby", baby)
					.build());
		}
		
		if (head != null || chest != null || legs != null || feet != null || mainHand != null || offHand != null) {
			builder.add("equipment", new JsonBuilder()
					.add("head", head)
					.add("chest", chest)
					.add("legs", legs)
					.add("feet", feet)
					.add("mainhand", mainHand)
					.add("offhand", offHand)
					.build());
		}
		
		if (catType != null) {
			builder.add("catType", "minecraft:textures/entity/cat/" + catType.name().toLowerCase() + ".png");
		}
		return builder.build();
	}
}
