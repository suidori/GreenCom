interface Printable{
    void print();
}

class Paper{
    private String con;
    public Paper(String con){
        this.con = con;
    }

//    public Printable getPrint(){
//        class Printer implements Printable{
//
//            @Override
//            public void print() {
//                System.out.println(con);
//            }
//        }
//        return new Printer();
//    }

    public Printable getPrint(){
        return new Printable() {
            @Override
            public void print() {
                System.out.println(con);
            }
        };
    }

}

public class Ex02 {
    public static void main(String[] args) {
        Paper paper = new Paper("출력할 내용");
        Printable print = paper.getPrint();
        print.print();
    }
}
