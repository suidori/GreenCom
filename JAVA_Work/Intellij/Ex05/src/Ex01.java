import java.util.Scanner;

class Fact {
    public int fact(int i){
        System.out.println("here" + i);
        if(i>0)
            return 2*fact(i-1);
        else
            return 1;
    }
}

public class Ex01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Input");

        String str = scan.nextLine();
        /*
        String -> int = Integer.parseInt
        int -> String = int + ""
         */
        int num = Integer.parseInt(str);

        Fact fact = new Fact();
        System.out.println(fact.fact(num));

//        System.out.println(str);
//        System.out.println(num);



    }
}
