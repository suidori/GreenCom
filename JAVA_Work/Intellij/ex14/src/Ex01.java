import inter.CMYKPrintable;
import inter.Printable;
import print.CMYKPrinter;
import print.LPrinter;
import print.SPrinter;

public class Ex01 {

    public static void main (String[] args) {
//        System.out.println(Printable.HEIGHT);
//        System.out.println(Printable.WIDTH);

//        inter.Printable.HEIGHT = 60;
        //->static final 예약이 붙어 있어서 값 변경이 불가능하다.

        Printable prn = new LPrinter();
        prn.print("내 문서");

        prn = new SPrinter();
        prn.print("내 문서");

        CMYKPrintable colorPrn = new CMYKPrinter();
        colorPrn.print("내 문서");
        colorPrn.printCMYK("내 문서");

        prn.clean();

        colorPrn.clean();

        Printable.printLine();
    }

}