package dev.majek.advancements.shared;

import com.google.gson.JsonObject;
import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Specifies information about a block. The object is invalid without the {@code block} property,
 * therefore it must be assigned in the constructor.
 * All the information specified must be met in order for the block to meet the criteria.
 */
public class BlockObject extends SharedObject {

	private final @NotNull Material block;
	private final @NotNull Map<String, String> states;

	private BlockObject(@NotNull Material block, @NotNull Map<String, String> states) {
		this.block = block;
		this.states = states;
	}

	/**
	 * Create a new block object.
	 *
	 * @param block the material representation of the block
	 * @return block object
	 */
	public static @NotNull BlockObject create(final @NotNull Material block) {
		return new BlockObject(block, new HashMap<>());
	}
	
	/**
	 * Get the material representation of the block type.
	 *
	 * @return the block
	 */
	public @NotNull Material block() {
		return this.block;
	}
	
	/**
	 * Get a map containing the state id and state value pairs.
	 *
	 * @return states map
	 */
	public @NotNull Map<String, String> states() {
		return Collections.unmodifiableMap(states);
	}
	
	/**
	 * Set a state of the block.
	 * The <a href="https://minecraft.gamepedia.com/Block_states">Minecraft Wiki</a>
	 * contains a list of possible states for each block.
	 *
	 * @param state the state's id
	 * @param value the state's value
	 * @return the block
	 */
	public @NotNull BlockObject state(final @NotNull String state, final @Nullable String value) {
		if (value == null) {
			states.remove(state);
		} else {
			states.put(state, value);
		}
		return this;
	}
	
	/**
	 * Get a Json representation of the block object.
	 *
	 * @return block object json
	 */
	@Override
	public @NotNull JsonObject toJson() {
		final JsonObject json = new JsonObject();
		json.addProperty("block", block.getKey().toString());
		if (!states.isEmpty()) {
			final JsonObject state = new JsonObject();
			states.forEach(state::addProperty);
			json.add("state", state);
		}
		return json;
	}
}
