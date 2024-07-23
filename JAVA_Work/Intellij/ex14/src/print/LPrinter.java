package print;

import inter.Printable;

public class LPrinter implements Printable {

    @Override
    public void print(String mydoc) {
        System.out.println("LG프린터 출력");
        System.out.println(mydoc);
    }
}
