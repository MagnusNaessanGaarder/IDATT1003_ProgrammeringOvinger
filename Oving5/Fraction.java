package Oving5;
import java.lang.IllegalArgumentException;
import java.util.LinkedList;
import java.util.Collections;
import java.util.List;

class Fraction {
    private int num;
    private int denum;

    public Fraction(int teller, int nevner) {
        if (nevner == 0) {
            throw new IllegalArgumentException("Null-divisjon error: Kan ikke ha null i nevner.");
        }
        
        this.num = teller;
        this.denum = nevner;
    }
    
    public Fraction(int teller) {
        this(teller, 1);
    }

    private int getNumerator() {
        return this.num;
    }

    private int getDenominator() {
        return this.denum;
    }

    private List<Integer> getCommonFactors() {
        int[] primeList = {2,3,5,7,11,13,17,19,23,29,31,37};
        List<Integer> list = new LinkedList<Integer>(Collections.<Integer>emptyList());
        
        for (int f : primeList) {
            if (getDenominator() % f == 0 && getNumerator() % f == 0) {
                list.add(f);
            }
        }
        return list;
    }

    private void shorten() {
        List<Integer> commonFactorList = new LinkedList<Integer>(getCommonFactors());

        while (!(commonFactorList.isEmpty())) {
            this.num /= commonFactorList.get(commonFactorList.size() - 1);
            this.denum /= commonFactorList.get(commonFactorList.size() - 1);

            commonFactorList.clear();
            commonFactorList = getCommonFactors();
        }
    }

    public void sum(int n, int d) {
        if (d == 0) { throw new IllegalArgumentException("Nevneren kan ikke være null!"); }
        
        int prev_num = this.num;
        int prev_denum = this.denum;

        if (d == this.denum) {
            this.num += n;
        }
        else {
            this.num = this.num*d + n*this.denum;
            this.denum *= d;
        }
        if (this.num % this.denum != 0) {
            shorten();
        }
        String s = """      
         %d       %d       %d
        ---  +  ---  =  --- 
         %d       %d       %d 
        """;
        System.out.println(String.format(s, Math.abs(prev_num), n, this.num, Math.abs(prev_denum), d, this.denum));
    }
    public void diff(int n, int d) {
        if (d == 0) { throw new IllegalArgumentException("Nevneren kan ikke være null!"); }
        
        int prev_num = this.num;
        int prev_denum = this.denum;

        if (d == denum) {
            this.num -= n;
        }
        else {
            this.num = this.num*d - n*this.denum;
            this.denum *= d;
        }
        
        if (this.num % this.denum != 0) {
            shorten();
        }
        String s = """      
         %d       %d       %d
        ---  -  ---  =  --- 
         %d       %d       %d 
        """;
        System.out.println(String.format(s, Math.abs(prev_num), n, this.num, Math.abs(prev_denum), d, this.denum));
    }
    public void product(int n, int d) {
        if (d == 0) { throw new IllegalArgumentException("Nevneren kan ikke være null!"); }
        int prev_num = this.num;
        int prev_denum = this.denum;
        
        this.num *= n;
        this.denum *= d;
        
        if (this.num % this.denum != 0) {
            shorten();
        }
        String s = """      
         %d       %d       %d
        ---  x  ---  =  --- 
         %d       %d       %d 
        """;
        System.out.println(String.format(s, Math.abs(prev_num), n, this.num, Math.abs(prev_denum), d, this.denum));
    }
    public void quotient(int n, int d) {
        if (d == 0) { throw new IllegalArgumentException("Nevneren kan ikke være null!"); }
        int prev_num = this.num;
        int prev_denum = this.denum;
        
        this.num *= d;
        this.denum *= n;
        
        if (this.num % this.denum != 0) {
            shorten();
        }
        String s = """      
         %d       %d       %d
        ---  /  ---  =  --- 
         %d      %d       %d 
        """;
        System.out.println(String.format(s, Math.abs(prev_num), n, this.num, Math.abs(prev_denum), d, this.denum));
    }
}