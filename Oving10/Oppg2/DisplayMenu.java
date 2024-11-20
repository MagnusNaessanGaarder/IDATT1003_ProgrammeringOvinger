package Oving10.Oppg2;

import java.util.List;

public class DisplayMenu {
    public static String displayMenuList(List<Menu> list) {
        StringBuilder sb = new StringBuilder();
        for (Menu menu : list) {
            sb.append("         ")
                    .append(menu.toString())
                    .append("\n\n");
        }
        sb.append("\n\n");
        return sb.toString();
    }
}
