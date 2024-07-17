public class Ex01 {
    public static void main(String[] args) {

        Person p1 = new Person();
        Person p2 = new Person("020329");
        Person p3 = new Person("020329", "071516");

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        p1.show();
        p2.show();
        p3.show();


    }
}
