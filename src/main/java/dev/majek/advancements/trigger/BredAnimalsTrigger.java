package dev.majek.advancements.trigger;

import com.google.gson.JsonObject;
import dev.majek.advancements.shared.EntityObject;
import dev.majek.advancements.util.JsonBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Fires whenever two animals are bred and a child is born.
 */
public class BredAnimalsTrigger extends Trigger {

	private EntityObject parent;
	private EntityObject partner;
	private EntityObject child;
	
	public BredAnimalsTrigger() {
		super(Type.BRED_ANIMALS);
	}
	
	/**
	 * @return information about one of the parents (doesn't matter) or null, if none was specified
	 */
	public @Nullable EntityObject parent() {
		return this.parent;
	}
	
	/**
	 * @return information about one of the parents (doesn't matter) or null, if none was specified
	 */
	public @Nullable EntityObject partner() {
		return this.partner;
	}
	
	/**
	 * @return information about the newborn entity or null, if none was specified
	 */
	public @Nullable EntityObject child() {
		return child;
	}

	/**
	 * @param parent information about one of the parents (doesn't matter) or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	public @NotNull BredAnimalsTrigger parent(final @Nullable EntityObject parent) {
		this.parent = parent;
		return this;
	}
	
	/**
	 * @param partner information about one of the parents (doesn't matter) or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	public @NotNull BredAnimalsTrigger partner(final @Nullable EntityObject partner) {
		this.partner = partner;
		return this;
	}
	
	/**
	 * @param child information about the newborn entity or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	public @NotNull BredAnimalsTrigger child(final @Nullable EntityObject child) {
		this.child = child;
		return this;
	}

	@Override
	protected @NotNull JsonObject conditions() {
		return new JsonBuilder()
				.add("parent", parent)
				.add("partner", partner)
				.add("child", child)
				.build();
	}
}
