package entity0.copperentangled;

import java.util.HashMap;
import java.util.Map;

public class EntangleNetwork {
    public static Map<Integer, Long> EntangledPower = new HashMap<>();
    public void putPower (int id, long power) {
        //if (EntangledPower.containsKey(id)) {
        //    EntangledPower.put(id, (EntangledPower.get(id) + power));
        //} else {
        //    EntangledPower.put(id, power);
        //}
        EntangledPower.put(id, (EntangledPower.getOrDefault(id, 0L) + power));
    }
    public long getpower(int id) {
        long powerReturn;
        powerReturn = EntangledPower.getOrDefault(id, 0L);
        EntangledPower.put(id, 0L);
        return powerReturn;
    }
}
