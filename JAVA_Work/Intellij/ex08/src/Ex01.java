class Person{
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public void greeting(){
        System.out.println(name + "이 인사를 합니다.");
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class Ex01 {
    public static void main(String[] args) {
       Person p1 = new Person("홍길동");

       Person p2 = new Person();
       p2.setName("박길동");

       p1.greeting();
       p2.greeting();

    }
}
