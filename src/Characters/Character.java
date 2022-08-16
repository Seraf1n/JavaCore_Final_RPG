package Characters;

public abstract class Character implements Fighter {

    static final int BASE_GOLD_DROP = 5;
    static final double LVL_RATIO = 1.25;
    static final int BASE_EXP = 50;
    static final int BASE_HP = 50;
    static final int BASE_AGILITY = 10;
    static final int BASE_STR = 5;

    private String name;
    private int lvl;
    private int hp;
    private int gold;
    private int agility;
    private int exp;
    private int str;

    public Character(String name){
        this.name = name;
    }

    public Character(String name, int lvl, int gold, int exp) {
        this.name = name;
        this.lvl = lvl;
        this.hp = (int) (BASE_HP + (LVL_RATIO*lvl));
        this.gold = gold;
        this.agility = (int) (BASE_AGILITY + (LVL_RATIO * lvl));
        this.exp = exp;
        this.str = (int) (BASE_STR + (LVL_RATIO * lvl));
    }

    public int getStr() {
        return str;
    }

    public int getAgility() {
        return agility;
    }

    public String getName() {
        return name;
    }

    public int getLvl() {
        return lvl;
    }

    public int getHp() {
        return hp;
    }

    public int getGold() {
        return gold;
    }

    public int getExp() {
        return exp;
    }

    public void setGold(int gold) {
        this.gold += gold;
    }

    public void setExp(int exp) {
        this.exp += exp;
        int expToUp = getLvl()*75+125;
        if(getExp()>=expToUp){
            System.out.println("Повышение уровня");
            setLvl(1);
            this.exp -= expToUp;
            setStr((int)(BASE_STR+(LVL_RATIO*getLvl())));
            setAgility((int)(BASE_AGILITY+(LVL_RATIO*getLvl())));
        }
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public void setStr(int str) {
        this.str = str;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setLvl(int lvl) {
        this.lvl += lvl;


    }

    public boolean isDead() {
        return this.hp <= 0;
    }

    @Override
    public String toString() {
        return String.format("*************" +
                        "\nLVL: %d" +
                        "\nHP: %d" +
                        "\nXP: %d" +
                        "\nGOLD: %d" +
                        "\n*************",
                this.lvl, this.hp, this.exp, this.gold);
    }

}
