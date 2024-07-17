public class Person {

    private String registry;
    private String passport;

    public Person() {
    }

    public Person(String registry) {
        this.registry = registry;
    }

    public Person(String registry, String passport) {
//        this.registry = registry;
        this(registry);
        this.passport = passport;
    }

    @Override
    public String toString() {
        return "Person{" +
                "registry='" + registry + '\'' +
                ", passport='" + passport + '\'' +
                '}';
    }

    public void show() {
        System.out.println("registry = " + registry);
        System.out.println("passport = " + passport);
    }

}
