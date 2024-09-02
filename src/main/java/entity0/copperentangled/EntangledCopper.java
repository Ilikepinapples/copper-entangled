package entity0.copperentangled;

import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import entity0.coppernetworks.*;

import java.util.UUID;

public class EntangledCopper extends Item implements copperNetworkPowerAPI{
    public EntangledCopper(Settings settings) {
        super(settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!stack.contains(EntangledComponent.COPPER_POWER_COMPONENT)) {
            stack.set(EntangledComponent.COPPER_POWER_COMPONENT, UUID.randomUUID());
        }
        if (!stack.contains(EntangledComponent.MAX_POWER_TRANSFER)) {
            stack.set(EntangledComponent.MAX_POWER_TRANSFER, 0L);
        }
        long maxPower = stack.get(EntangledComponent.MAX_POWER_TRANSFER);
        if (maxPower != 0 && copperNetworkAPI().canConsume(maxPower)) {
            copperNetworkAPI().consume(maxPower);
            EntangleNetwork.putPower(stack.get(EntangledComponent.COPPER_POWER_COMPONENT), maxPower);
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }
    CopperNetworkPowerClass copperPowerInstance = new CopperNetworkPowerClass();
    @Override public CopperNetworkPowerClass copperNetworkAPI() { return copperPowerInstance; }
}
