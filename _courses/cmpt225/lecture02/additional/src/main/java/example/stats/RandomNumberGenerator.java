package example.stats;

import java.util.Random;

class RandomNumberGenerator {
    
    public static float randomFloat() {
        Random rand = new Random();
        return rand.nextFloat();
    }

    public static int randomInt() {
        Random rand = new Random();
        return rand.nextInt();
    }

}
