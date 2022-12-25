import java.util.*;
import java.util.stream.Collectors;

public class Seminar4 {
    public static void main(String[] args) {
//Написать приложение для ввода ФИО, возраста и пола пользователей. Данные хранить в разных списках.

        List<String> names = new ArrayList<>(Arrays.asList("Olga", "Olga", "Gennagiy", "Anton", "Vladimir"));
        List<String> patronymic = new ArrayList<>(Arrays.asList("Olegovna", "Ivanovna", "Semenovich", "Sergeevich", "Viktorovich"));
        List<String> lNames = new ArrayList<>(Arrays.asList("Smirnova", "Volkova", "Vorobev", "Bessonov", "Vorobev"));
        List<Integer> ages = new ArrayList<>(Arrays.asList(29, 29, 32, 28, 36));
        List<Boolean> sexes = new ArrayList<>(Arrays.asList(true, true, false, false, false));

//Добавить методы для сортировки пользователей по возрасту полу и первой букве фамилии.

        ageSort(ages);
        System.out.println(ages); //[28, 29, 29, 32, 36]

        sexSort(sexes);
        System.out.println(sexes); //[false, false, false, true, true]

        System.out.println(lNameSort(lNames)); //[Bessonov, Smirnova, Volkova, Vorobev, Vorobev]

//*Добавить возможность одновременной сортировки по двум параметрам.


//**Добавить возможность одновременной сортировки по трём параметрам.


    }


    public static void ageSort(List<Integer> list) {
        Collections.sort(list);
    }

    public static void sexSort(List<Boolean> list) {
        Collections.sort(list);
    }

    public static List<String> lNameSort(List<String> list) {
        return list.stream()
                .sorted(Comparator.comparing(o1 -> o1.charAt(0)))
                .collect(Collectors.toList());
    }
}
