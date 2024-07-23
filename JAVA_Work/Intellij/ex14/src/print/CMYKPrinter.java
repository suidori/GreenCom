package print;

import inter.CMYKPrintable;

import java.sql.SQLOutput;

public class CMYKPrinter implements CMYKPrintable {

    @Override
    public void printCMYK(String mydoc) {
        System.out.println("컬러출력");
        System.out.println(mydoc);
    }

    @Override
    public void print(String mydoc) {
        System.out.println("흑백출력");
        System.out.println(mydoc);
    }
}
