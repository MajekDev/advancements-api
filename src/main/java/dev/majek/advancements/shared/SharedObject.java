package dev.majek.advancements.shared;

import com.google.gson.JsonElement;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Objects extending this class are used to define data.
 * ex. icons, criteria of triggers and can be converted to Json elements.
 */
public abstract class SharedObject {

	/**
	 * The json representation of the object.
	 *
	 * @return json
	 */
	@NotNull
	@Contract(pure = true)
	public abstract JsonElement toJson();

	/**
	 * This method should be used wisely, since it calls {@link #toJson()}
	 *
	 * @return the hash code of this shared object
	 */
	@Contract(pure = true)
	@Override
	public int hashCode() {
		return toJson().hashCode();
	}
	
	/**
	 * This method should be used wisely, since it calls {@link #toJson()}
	 *
	 * @param object the object with which to compare
	 * @return whether this object has the same content as the passed parameter
	 */
	@Contract(value = "null -> false", pure = true)
	@Override
	public boolean equals(@Nullable Object object) {
		return object instanceof SharedObject && toJson().equals(((SharedObject) object).toJson());
	}
}
