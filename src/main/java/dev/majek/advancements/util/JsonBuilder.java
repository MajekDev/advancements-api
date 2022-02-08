package dev.majek.advancements.util;

import com.google.gson.*;
import dev.majek.advancements.shared.SharedEnum;
import dev.majek.advancements.shared.SharedObject;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.gson.GsonComponentSerializer;
import org.bukkit.Keyed;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.function.Function;

/**
 * {@link JsonObject} creation utility, used internally.
 */
public class JsonBuilder {

	public static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
	private final JsonObject json;
	
	public JsonBuilder() {
		this(new JsonObject());
	}
	
	public JsonBuilder(@NotNull JsonObject source) {
		this.json = source;
	}
	
	@NotNull
	public JsonObject build() {
		return this.json;
	}
	
	@NotNull
	public JsonBuilder add(@NotNull String key, @Nullable String value) {
		if (value != null) {
			json.addProperty(key, value);
		}
		return this;
	}
	
	@NotNull
	public JsonBuilder add(@NotNull String key, @Nullable Number value) {
		if (value != null) {
			json.addProperty(key, value);
		}
		return this;
	}
	
	@NotNull
	public JsonBuilder add(@NotNull String key, @Nullable Boolean value) {
		if (value != null) {
			json.addProperty(key, value);
		}
		return this;
	}
	
	@NotNull
	public JsonBuilder add(@NotNull String key, @Nullable JsonElement value) {
		if (value != null) {
			json.add(key, value);
		}
		return this;
	}

	@NotNull
	public JsonBuilder addNonNegative(@NotNull String key, int value) {
		if (value >= 0) {
			json.addProperty(key, value);
		}
		return this;
	}
	
	@NotNull
	public JsonBuilder addPositive(@NotNull String key, int value) {
		if (value > 0) {
			json.addProperty(key, value);
		}
		return this;
	}
	
	@NotNull
	public JsonBuilder add(@NotNull String key, @Nullable SharedObject value) {
		if (value != null) {
			json.add(key, value.toJson());
		}
		return this;
	}
	
	@NotNull
	public JsonBuilder add(@NotNull String key, @Nullable SharedEnum value) {
		if (value != null) {
			json.addProperty(key, value.value());
		}
		return this;
	}
	
	@NotNull
	public JsonBuilder add(@NotNull String key, @Nullable NamespacedKey value) {
		if (value != null) {
			json.addProperty(key, value.toString());
		}
		return this;
	}
	
	@NotNull
	public JsonBuilder add(@NotNull String key, @Nullable Keyed value) {
		if (value != null) {
			json.addProperty(key, value.getKey().toString());
		}
		return this;
	}
	
	@NotNull
	public JsonBuilder add(@NotNull String key, @Nullable Component value) {
		if (value != null) {
			json.add(key, GsonComponentSerializer.gson().serializeToTree(value));
		}
		return this;
	}
	
	@NotNull
	public <T> JsonBuilder add(@NotNull String key, @Nullable Collection<T> value, Function<T, JsonElement> mapper) {
		if (value != null && !value.isEmpty()) {
			JsonArray array = new JsonArray();
			value.stream().map(mapper).forEach(array::add);
			json.add(key, array);
		}
		return this;
	}
}
