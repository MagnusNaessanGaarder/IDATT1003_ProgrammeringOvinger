package Oving7;

import java.util.*;
public class NyString {
    
    final private String str;
    final private String shortStr;

    public NyString(String s) {
        this.str = s;
        this.shortStr = shorten();
    }

    public NyString() {
        this.str = "Dette er en test streng!";
        this.shortStr = shorten();
    }
    
    public String getString() {
        String A = deepCopy(str);
        return A;
    }

    public String getShort() {
        String A = deepCopy(shortStr);
        return A;
    }

    private String deepCopy(String a) {
        String A = "";
        for (int i = 0; i < a.length(); i++) {
            A += a.charAt(i);
        }
        return A;
    } 

    private String shorten() {
        return Arrays.stream(this.str.split("\\s+"))
            .map(str -> Character.toString(str.toUpperCase().charAt(0)))
            .reduce("", (accumulator, currentValue) -> {
                return accumulator + currentValue;
            });
    }

    public String cutString(String s) {
        return String.join("",this.str.split(s));
    }
}
