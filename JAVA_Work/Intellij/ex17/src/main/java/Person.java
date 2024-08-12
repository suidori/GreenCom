public class Person implements Comparable {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Person p = (Person) o;
//        System.out.println(this.age);
//        System.out.println(((Person) o).age);
//        if (this.age > p.age) {
//            return 1;
//        } else if(this.age < p.age){
//            return -1;
//        }
//        else return 0;

        return this.age-p.age;
    }
}
