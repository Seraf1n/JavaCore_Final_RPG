import java.util.HashMap;
import java.util.Map;

public class Menu {

    private Map<Integer, String> menuDef = new HashMap();
    private Map<Integer, String> menuOpt = new HashMap();
    private Map<Integer, String> menuTrader = new HashMap();

    public Map<Integer, String> getMenuDef() {
        return menuDef;
    }

    public Map<Integer, String> getMenuOpt() {
        return menuOpt;
    }

    public Map<Integer, String> getMenuTrader() {
        return menuTrader;
    }

    public Menu() {

        menuDef.put(1, "К торговцу");
        menuDef.put(2, "В Темный лес");
        menuDef.put(3, "На выход");

        menuOpt.put(1, "Вернуться в город");
        menuOpt.put(2, "Продолжить торговлю/бой");
        menuOpt.put(9, "Показатели");

        menuTrader.put(1, "Купить зелье");
        menuTrader.put(2, "Покинуть торговца");
    }

    public int selectAction(Map<Integer, String> actionMenu) {

        int result = 0;
        actionMenu.entrySet()
                .stream()
                .forEach((Map.Entry entry) ->
                        System.out.printf(
                                entry.getKey() + "-> " + entry.getValue() + "\n"));
        while (result !=1 && result !=2 && result !=3 && result != 9) {
            String str = Application.SCANNER.next();
            try {
                result = Integer.parseInt(str);
            }catch (NumberFormatException e){
                System.out.println(e.getMessage());
            }
        }
        return result;
    }
}
