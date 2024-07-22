public class Ex03 {
    public static void main(String[] args) {
        String mydoc = "my document";
        Printable prn = new SPrint();
        prn.print(mydoc);

        prn = new LPrint();
        prn.print(mydoc);
    }
}
