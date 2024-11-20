package Oving2;

public class O2Oppg2 {
    public static String sammenliknPris(Object[] aItem, Object[] bItem) {
        float aGram = (float) aItem[2];
        float bGram = (float) bItem[2];
        
        float aPris = (float) aItem[1];
        float bPris = (float) bItem[1];

        String aProd = (String) aItem[0];
        String bProd = (String) bItem[0];

        
        float a = aPris / (aGram / 1000);
        float b = bPris / (bGram / 1000);

        if (a == b) {
            return "Det er like stor pris per kg på begge varer.";
        }
        else if (a < b) {
            return bProd + " koster " + b + "kr/kg, mens " + aProd + " koster " + a + "kr/kg. Det vil si at " + 
            bProd + " som koster " + b + "kr/kg er billigere enn " + aProd + " som koster " + a + "kr/kg.";
        } 
        else {
            return aProd + " koster " + a + "kr/kg, mens " + bProd + " koster " + b + "kr/kg. Det vil si at " + 
            aProd + " som koster " + a + "kr/kg er billigere enn " + bProd + " som koster " + b + "kr/kg.";
        }
        
    }
    public static void main(String[] args) {
        Object[] item1 = new Object[3];
        Object[] item2 = new Object[3];

        item1[0] = "Kjøttdeig1";
        item1[1] = Float.valueOf(35.9f);
        item1[2] = Float.valueOf(450f);
        
        item2[0] = "Kjøttdeig2";
        item2[1] = Float.valueOf(39.5f);
        item2[2] = Float.valueOf(500f);

        System.out.println(sammenliknPris(item1, item2));
    }
}