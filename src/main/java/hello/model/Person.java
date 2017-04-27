package hello.model;

public class Person {

    private String name;
    private String subName;

    public Person(String name, String subName) {
        this.name = name;
        this.subName = subName;
    }

    public Person() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }


    public static Person empty() {
        return new Person();
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", subName='" + subName + '\'' +
                '}';
    }


}
