package packages;

public class Client {
    private Short age;
    private String name;

    public Client() {
        this.age = 0;
        this.name = "not defined";
    }

    public Client(Short age, String name) {
        this.age = age;
        this.name = name;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Short getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
