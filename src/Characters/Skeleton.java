package Characters;

import java.util.Random;

public class Skeleton extends Character implements Fighter{

    Skeleton(String name, int lvl, int gold, int exp) {
        super(name, lvl, gold, exp);
    }

    public static Character createSkeleton(int lvlPlayer) {
        Random rand = new Random();
        int monsterLvl = rand.nextInt(1,lvlPlayer+1);
        int maxGoldDrop = (int)(BASE_GOLD_DROP*LVL_RATIO*monsterLvl);
        int gold = rand.nextInt(maxGoldDrop/2, maxGoldDrop);
        int exp = (int)(BASE_EXP*LVL_RATIO*monsterLvl);
        return new Skeleton("Skeleton_lvl"+monsterLvl, monsterLvl, gold, exp);
    }

    @Override
    public void attack(Character target) {
        Random rand = new Random();
        int origin = rand.nextInt(0, 100);
        int chance = super.getAgility()*3;
        int dmg = super.getStr();
        if(chance>origin*2){
            dmg *=2;
            target.setHp(target.getHp()-dmg);
        } else if (chance>origin) {
            target.setHp(target.getHp()-dmg);
        }else{
            dmg = 0;
        }
        sayDmg(String.format("Монстр %s нанес %d урона игроку\n", this.getName(), dmg));
    }
}
