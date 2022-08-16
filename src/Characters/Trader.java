package Characters;

import java.util.Scanner;

public class Trader extends Character {

    public Trader() {
        super("Trader");
    }

    public void trade(Player player) {
        int gold = player.getGold();
        System.out.printf("� ��� ���� %d ������, ����� ����� 3 ������.\n������� ������ ����������?\n", gold);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String str = scanner.nextLine();
            try {
                int count = Integer.parseInt(str);
                if(count*3<=gold){
                    player.setHPPotions(player.getHPPotions()+count);
                    player.setGold(-count*3);
                    return;
                }else
                    System.out.println("������������ �������, ���������� ������ ������");
            } catch (NumberFormatException e) {
                System.out.print("������� �� �������\n���������� ��� ���\n");
            }
        }

    }


    @Override
    public void attack(Character target) {
    }
}
