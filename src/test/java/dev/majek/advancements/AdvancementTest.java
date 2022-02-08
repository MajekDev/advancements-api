package dev.majek.advancements;

import dev.majek.advancements.config.MinecraftFunction;
import dev.majek.advancements.config.Rewards;
import dev.majek.advancements.shared.ItemObject;
import dev.majek.advancements.trigger.ImpossibleTrigger;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;

import java.util.Map;
import java.util.Objects;

public class AdvancementTest {

    public void test() {
        MinecraftFunction function = MinecraftFunction.create(
                Objects.requireNonNull(NamespacedKey.fromString("fl_rewards:quenching-fire"))
        ).addLine("give @s minecraft:blaze_rod 2");

        Advancement advancement = Advancement
                .builder(
                        Objects.requireNonNull(NamespacedKey.fromString("farlands:nether/quenching-fire")),
                        ItemObject.icon(Material.BLAZE_ROD),
                        Component.text("Quenching Fire"),
                        Component.text("Throw a fire resistance potion on a Blaze."),
                        Map.of("impossible", new ImpossibleTrigger())
                )
                .makeChild(
                        NamespacedKey.minecraft("nether/obtain_blaze_rod")
                )
                .rewards(
                        Rewards.create().function(function).experience(100)
                )
                .build();
        AdvancementIO.activateAdvancement(advancement, true);
    }
}
