package Characters;

import java.util.Random;

public class RandomFactory implements MonsterFactory {
    MonsterFactory[] factories;
    Random rand = new Random();

    public RandomFactory(MonsterFactory[] factories) {
        this.factories = factories;
    }

    @Override
    public Character create(int lvlPlayer) {
        int ind = rand.nextInt(factories.length);
        return factories[ind].create(lvlPlayer);
    }
}