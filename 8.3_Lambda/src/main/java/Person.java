import java.util.*;

public class Person{
    private String name;
    private int age;
    private String city;

    public Person(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<Person>();
        people.add(new Person("Alice Johnson", 28, "New York"));
        people.add(new Person("Bob Smith", 35, "Los Angeles"));
        people.add(new Person("Charlie Brown", 22, "Chicago"));
        
        people.sort(Comparator.comparingInt(p -> p.age));
        System.out.println(people);

        people.removeIf(person -> !person.city.equals("New York"));
        System.out.println(people);
    }

    @Override
    public String toString() {
        return name + " " + age + " " + city;
    }
}