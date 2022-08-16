package Characters;

public class GoblinFactory implements MonsterFactory {
    @Override
    public Character create(int lvlPlayer) {
        return Goblin.createGoblin(lvlPlayer);
    }
}
