package services;

import java.util.Random;

/**
 * Created by Shiv on 2017-10-10.
 */

public class RandomGeneratorService {

    public int generate(int bound){
        Random random = new Random();
        return random.nextInt(bound);
    }
}
