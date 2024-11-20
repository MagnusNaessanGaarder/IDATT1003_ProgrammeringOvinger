package Oving10.Oppg1;

import java.util.List;

public class Display {

    public static String menuList(List<Arrangement> list, String altText){
        StringBuilder str = new StringBuilder();
        if (list.isEmpty()) {
            str.append("            ---- ").append(altText).append(" ----\n\n");
        }
        else {
            str.append(displayMenuList(list));
        }
        return str.toString();
    }

    public static String displayMenuList(List<Arrangement> list) {
        StringBuilder sb = new StringBuilder();
        for (Arrangement arrangement : list) {
            sb.append("         ")
                    .append(arrangement.getName())
                    .append(", ")
                    .append(arrangement.getID()).append(", ")
                    .append(arrangement.getLocation()).append(", ")
                    .append(arrangement.getHost()).append(", ")
                    .append(arrangement.getType()).append(", ")
                    .append(arrangement.getTime())
                    .append("\n");
        }
        sb.append("\n\n");
        return sb.toString();
    }

    public static String displaySearchList(List<Arrangement> list) {
        StringBuilder sb = new StringBuilder();
        for (Arrangement a : list) {
            sb.append("         ")
                    .append(a.getName())
                    .append(", ")
                    .append(a.getID())
                    .append("\n");
        }
        sb.append("\n\n");
        return sb.toString();
    }
}
