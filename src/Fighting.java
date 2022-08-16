import Characters.Character;
import Characters.Player;

public class Fighting extends Thread {

    Character monster;
    Player player;

    public Fighting(Character monster, Player player) {
        this.monster = monster;
        this.player = player;
    }

    @Override
    public void run() {
        while (true) {
            if (player.isDead()) {
                System.out.printf("Игрок потерпел сокрушительное поражение от %s!\nGAME OVA!\n", monster.getName());
                break;
            }
            player.attack(monster);
            if (monster.isDead()) {
                player.setExp(monster.getExp());
                player.setGold(monster.getGold());
                player.UpdateStats();
                System.out.printf(player.getName() + " одержал победу!\nПолучено %d опыта\nПолучено %d золота\n", monster.getExp(), monster.getGold());
                break;
            }
            monster.attack(player);
            try {
                sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}

