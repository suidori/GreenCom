class InstClass{
    static int num = 0;

    InstClass() {
           num++;
        System.out.println(num);
    }
}

public class Ex04 {
    public static void main(String[] args) {
        new InstClass();
        new InstClass();
        new InstClass();
        new InstClass();
    }
}
