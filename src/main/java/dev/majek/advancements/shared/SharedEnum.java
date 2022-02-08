package dev.majek.advancements.shared;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Enums implementing this interface are used to define data usually in {@link SharedObject}s.
 * They can also be converted to a {@link String} to be used in JSON objects.
 */
public interface SharedEnum {

	/**
	 * Get a string representation of the enum value, which can be used in Json objects.
	 *
	 * @return a string representation
	 */
	@NotNull
	@Contract(pure = true)
	String value();
}
