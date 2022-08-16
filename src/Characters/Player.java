package Characters;

import java.util.Random;

public class Player extends Character implements Fighter {

    int HPPotions = 10;

    public Player(String name) {
        super(name, 1, 0, 0);
    }

    @Override
    public void attack(Character target) {
        Random rand = new Random();
        int origin = rand.nextInt(0, 100);
        int chance = super.getAgility()*3+10;
        int dmg = super.getStr();
        if (getHp()< target.getStr()*2){
            useHPPotion();
        }
        if(chance>origin*2){
            dmg *=2;
            target.setHp(target.getHp()-dmg);
        } else if (chance>origin) {
            target.setHp(target.getHp()-dmg);
        }else{
            dmg = 0;
        }
       sayDmg(String.format("Игрок %s нанес %d урона монстру\n", this.getName(), dmg));

    }

    private void useHPPotion() {
        if(HPPotions>0) {
            System.out.printf("%s скушал зелье\n", getName());
            setHp(getHp() + 10);
            HPPotions -= 1;
        }
    }

    public void setHPPotions(int HPPotions) {
        this.HPPotions = HPPotions;
    }

    public int getHPPotions() {
        return HPPotions;
    }

    public void UpdateStats() {
        super.setHp((int)(BASE_HP+(LVL_RATIO*super.getLvl())));
    }

    @Override
    public String toString() {
        return String.format("*************" +
                        "\nLVL: %d" +
                        "\nHP: %d" +
                        "\nXP: %d" +
                        "\nGOLD: %d" +
                        "\nHP potions: %d" +
                        "\n*************",
                super.getLvl(), super.getHp(), super.getExp(), super.getGold(), this.HPPotions);
    }

}
