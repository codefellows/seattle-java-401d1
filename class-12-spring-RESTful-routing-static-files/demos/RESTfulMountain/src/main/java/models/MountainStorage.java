package models;

import java.util.*;

public class MountainStorage {
    public static Map<Integer, Mountain> mountains;
    static {
        mountains = new HashMap<>();
        Mountain rainier = new Mountain("Mt. Rainier", 14_411);
        Mountain baker = new Mountain("Mt. Baker", 10_781);

        mountains.put(rainier.id, rainier);
        mountains.put(baker.id, baker);
    }
}
