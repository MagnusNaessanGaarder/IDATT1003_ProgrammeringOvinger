package Oving4;

public class Valuta {
    private float kurs;
    public String valType;

    public Valuta(float kurs, String valType) {
        this.kurs = kurs;
        this.valType = valType;
    }

    public void toNOK(float amount) {
        float NOK = amount * kurs;
        
        System.out.printf("%.2f %s blir %.2f NOK. \n", amount, valType, NOK);
        return;
    }
    public void fromNOK(float amount) {
        float valuta = amount / kurs;

        System.out.printf("%.2f NOK blir %.2f %s. \n", amount, valuta, valType);
        return;
    }
}
