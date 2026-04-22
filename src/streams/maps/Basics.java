package streams.maps;

import java.util.HashMap;

public class Basics {
    public static void main(String[] args) {
        HashMap<String, String> capitals = new HashMap<>();
        capitals.put("Finland", "Helsinki");
        capitals.put("Sweden", "Stockholm");
        capitals.put("Norway", "Oslo");

        System.out.println(capitals.get("Sweden"));

        for (String country : capitals.keySet()){
            System.out.println(capitals.get(country));
        }
    }
}
