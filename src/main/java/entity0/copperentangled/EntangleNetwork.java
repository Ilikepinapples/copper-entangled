package entity0.copperentangled;

import net.minecraft.item.ItemStack;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class EntangleNetwork {
    public static Map<UUID, Long> EntangledPower = new HashMap<>();
    public static void putPower(UUID id, long power) {
        //if (EntangledPower.containsKey(id)) {
        //    EntangledPower.put(id, (EntangledPower.get(id) + power));
        //} else {
        //    EntangledPower.put(id, power);
        //}
        EntangledPower.put(id, (EntangledPower.getOrDefault(id, 0L) + power));
    }
    public long getpower(UUID id) {
        long powerReturn;
        powerReturn = EntangledPower.getOrDefault(id, 0L);
        EntangledPower.put(id, 0L);
        return powerReturn;
    }
}
