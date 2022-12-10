package nix.lessons.dto;

public record Person(String name, int age, Sex sex) {

    @Override
    public String toString() {
        return name + "," + age + "," + sex;
    }
}
