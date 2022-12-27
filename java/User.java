import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class User {
    private final String name;
    private final String patronymic;
    private final String lNames;
    private final int age;
    private final boolean sex;

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getlNames() {
        return lNames;
    }

    public int getAge() {
        return age;
    }

    public boolean isSex() {
        return sex;
    }

    public User(String name, String patronymic, String lNames, int age, boolean sex) {
        this.name = name;
        this.patronymic = patronymic;
        this.lNames = lNames;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "\nUser{" +
                "\n\t" + "name='" + name + '\'' + ", \n" +
                "\t" + "patronymic='" + patronymic + '\'' + ", \n" +
                "\t" + "lNames='" + lNames + '\'' + ", \n" +
                "\t" + "age=" + age + ", \n" +
                "\t" + "sex=" + sex + ", \n" +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && sex == user.sex && Objects.equals(name, user.name) && Objects.equals(patronymic, user.patronymic) && Objects.equals(lNames, user.lNames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, patronymic, lNames, age, sex);
    }
}
