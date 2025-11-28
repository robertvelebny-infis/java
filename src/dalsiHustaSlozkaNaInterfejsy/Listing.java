package dalsiHustaSlozkaNaInterfejsy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Listing {
    public static void main(String[] args) {

        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            integers.add(i);
        }

        List<Integer> toAdd = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            toAdd.add(i);
        }
        integers.addAll(toAdd);
        //integers.
    }
}
