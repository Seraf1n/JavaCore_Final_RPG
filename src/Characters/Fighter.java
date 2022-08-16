package Characters;

public interface Fighter {

    void attack(Character target);

    default void sayDmg(String dmg){
        System.out.print(dmg);
    }

}
