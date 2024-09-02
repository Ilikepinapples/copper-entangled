package entity0.copperentangled;

import com.mojang.serialization.Codec;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerChunkEvents;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Uuids;

import java.util.UUID;

public class EntangledComponent {
    public static void initialize() {
        CopperEntangled.LOGGER.info("Initiating components for Item Access");
    }

    public static final ComponentType<UUID> COPPER_POWER_COMPONENT = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(CopperEntangled.MOD_ID, "entangle_copper"),
            ComponentType.<UUID>builder().codec(Uuids.CODEC).build()
    );
    public static final ComponentType<Long> MAX_POWER_TRANSFER = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(CopperEntangled.MOD_ID, "entangled_copper_max_power"),
            ComponentType.<Long>builder().codec(Codec.LONG).build()
    );
}
