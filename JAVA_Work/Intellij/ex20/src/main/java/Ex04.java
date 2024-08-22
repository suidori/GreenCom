public class Ex04 {
    public static void main(String[] args) {
        System.out.println(Person.MAN);
    }
    public static void who (Person person){
        if(person==Person.MAN){
            System.out.println("남자");
        }else {
            System.out.println("여자");
        }
    }
}
