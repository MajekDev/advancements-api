package dev.majek.advancements.trigger;

import com.google.gson.JsonObject;
import dev.majek.advancements.shared.ItemObject;
import dev.majek.advancements.util.JsonBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Fires when a player fills a bucket with lava, water or a fish.
 */
public class FilledBucketTrigger extends Trigger {

	private ItemObject item;
	
	public FilledBucketTrigger() {
		super(Type.FILLED_BUCKET);
	}

	/**
	 * @return the bucket item after it was filled or null, if none was specified
	 */
	public @Nullable ItemObject item() {
		return this.item;
	}
	
	/**
	 * @param item the bucket item after it was filled or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	public @NotNull FilledBucketTrigger item(final @Nullable ItemObject item) {
		this.item = item;
		return this;
	}

	@Override
	protected @NotNull JsonObject conditions() {
		return new JsonBuilder()
				.add("item", item)
				.build();
	}
}
