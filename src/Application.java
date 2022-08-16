import Characters.Player;

import java.util.Scanner;

public class Application extends Thread {

    public final static Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("����������....");

        String name = SCANNER.nextLine();
        Player player = new Player(name);
        System.out.printf("����� ���������� � ����, %s!\n", player.getName());
        System.out.println("���� �� ������ �����?");
        System.out.println(player);

        Thread game = new Thread(new Game(player), "THE GAME");
        game.start();
        try {
            game.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}



