package print;

import inter.Printable;

public class SPrinter implements Printable {

    @Override
    public void print(String mydoc) {
        System.out.println("삼성 프린터 출력");
        System.out.println(mydoc);
    }
}
