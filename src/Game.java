import Characters.Character;
import Characters.*;

public class Game extends Thread {
    Player player;
    final static Menu MENU = new Menu();

    public Game(Player player) {
        this.player = player;
    }

    @Override
    public void run() {
        while (!player.isDead()) {
            int selection = MENU.selectAction(MENU.getMenuDef());
            switch (selection) {
                case 1 -> trade(player);
                case 2 -> getMonsterAndFight(player);
                case 3 -> {
                    System.out.println(" ак жаль, что вы уже уходите!");
                    return;
                }
                case 9 -> System.out.println(player);
            }
        }
        System.out.println(player);
    }


    private static void trade(Player player) {

        int selection = MENU.selectAction(MENU.getMenuTrader());
        if (selection == 1) {
            new Trader().trade(player);
        }
    }

    private static void getMonsterAndFight(Player player) {

        Character monster = randomizeMonster(player);
        Thread fighting = new Thread(new Fighting(monster, player), "THE BATTLE");
        fighting.start();

        try {
            fighting.join();
            if (player.isDead()) {
                return;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        while (true) {
            int selection = MENU.selectAction(MENU.getMenuOpt());
            switch (selection) {
                case 1 -> {
                }
                case 2 -> getMonsterAndFight(player);
                case 9 -> {
                    System.out.println(player);
                    continue;
                }
            }
            break;
        }
    }

    private static Character randomizeMonster(Player player) {
        int lvlPlayer = player.getLvl();
        RandomFactory factory = new RandomFactory(new MonsterFactory[]
                {
                        new GoblinFactory(),
                        new SkeletonFactory()
                });

        Character monster = factory.create(lvlPlayer);
        System.out.println("начинаетс€ бой с " + monster.getName());
        return monster;
    }
}
