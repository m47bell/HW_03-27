package nyc.c4q.m47bell;

/**
 * Created by c4q-marbella on 3/25/15.
 * Access Code 2-1
 * Marbella Vidals
 * Java Classes- Person
 * Write a function called checkSameCity which accepts as input two Person
 * instances and checks if they live in the same city. The function should return a boolean value
 A Person has recently had a child, whose name is 'Abc'.
 Write a function called registerChild which
 accepts as input a Person instance(Parent) and returns a new Person instance for the child,
 which has the same phoneNumber and city as the parent.
 */
public class Person {
    private String name;
    private String phoneNumber;
    private String city;

    public Person(){
    }

    public Person(String name){
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static boolean checkSameCity(Person person1, Person person2) {
        return person1.getCity().equals(person2.getCity());
    }

    public static Person registerChild(Person parent){

        Person child= new Person("Baby");
        child.setPhoneNumber(parent.getPhoneNumber());
        child.setCity(parent.getCity());

        return child;
    }

}
