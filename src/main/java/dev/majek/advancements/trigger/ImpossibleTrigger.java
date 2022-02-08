package dev.majek.advancements.trigger;

import com.google.gson.JsonObject;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Never fires, therefore this trigger cannot be fulfilled, except if it's explicitly granted using commands and such.
 */
public class ImpossibleTrigger extends Trigger {

	public ImpossibleTrigger() {
		super(Type.IMPOSSIBLE);
	}

	@Override
	protected @NotNull JsonObject conditions() {
		return new JsonObject();
	}
}
