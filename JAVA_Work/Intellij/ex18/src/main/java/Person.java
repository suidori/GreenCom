public class Person implements Comparable<Person>{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person o) {
        for(int i = 0; i<(Math.min(this.name.length(), o.name.length())); i++){
            if(this.name.charAt(i)-o.name.charAt(i) != 0){
                return this.name.charAt(i) - o.name.charAt(i);
            }
        }
        return this.name.length() - o.name.length();
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
