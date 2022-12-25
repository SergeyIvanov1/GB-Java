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

        List<User> users = new ArrayList<>();
        users.add(new User("Olga", "Olegovna", "Smirnova",29,true));
        users.add(new User("Olga", "Ivanovna", "Volkova",21,true));
        users.add(new User("Gennagiy", "Semenovich", "Vorobev",32,false));
        users.add(new User("Anton", "Sergeevich", "Bessonov",40,false));
        users.add(new User("Vladimir", "Viktorovich", "Vorobev",36,false));

        System.out.println(users);

        System.out.println("___________________________");
        System.out.println(users);


//Добавить методы для сортировки пользователей по возрасту полу и первой букве фамилии.

        ageSort(ages);
        System.out.println(ages); //[28, 29, 29, 32, 36]

        sexSort(sexes);
        System.out.println(sexes); //[false, false, false, true, true]

        System.out.println(lNameSort(lNames)); //[Bessonov, Smirnova, Volkova, Vorobev, Vorobev]

//*Добавить возможность одновременной сортировки по двум параметрам.

        sortByAgeAndName(users);
        //Before
//        [
//        User{
//            name='Olga',
//                    patronymic='Olegovna',
//                    lNames='Smirnova',
//                    age=29,
//                    sex=true,
//        },
//        User{
//            name='Olga',
//                    patronymic='Ivanovna',
//                    lNames='Volkova',
//                    age=21,
//                    sex=true,
//        },
//        User{
//            name='Gennagiy',
//                    patronymic='Semenovich',
//                    lNames='Vorobev',
//                    age=32,
//                    sex=false,
//        },
//        User{
//            name='Anton',
//                    patronymic='Sergeevich',
//                    lNames='Bessonov',
//                    age=40,
//                    sex=false,
//        },
//        User{
//            name='Vladimir',
//                    patronymic='Viktorovich',
//                    lNames='Vorobev',
//                    age=36,
//                    sex=false,
//        }]
//        ___________________________ After
//                [
//                User{
//            name='Olga',
//                    patronymic='Olegovna',
//                    lNames='Smirnova',
//                    age=29,
//                    sex=true,
//        },
//        User{
//            name='Olga',
//                    patronymic='Ivanovna',
//                    lNames='Volkova',
//                    age=21,
//                    sex=true,
//        },
//        User{
//            name='Gennagiy',
//                    patronymic='Semenovich',
//                    lNames='Vorobev',
//                    age=32,
//                    sex=false,
//        },
//        User{
//            name='Anton',
//                    patronymic='Sergeevich',
//                    lNames='Bessonov',
//                    age=40,
//                    sex=false,
//        },
//        User{
//            name='Vladimir',
//                    patronymic='Viktorovich',
//                    lNames='Vorobev',
//                    age=36,
//                    sex=false,
//        }]

//**Добавить возможность одновременной сортировки по трём параметрам.

        sortByAgeAndNameAndSexes(users);
        System.out.println(users);
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

    public static void sortByAgeAndName(List<User> users) {
        users.sort(Comparator.comparing(User::getAge).thenComparing(User::getlNames));
    }

    public static void sortByAgeAndNameAndSexes(List<User> users) {
        users.sort(Comparator.comparing(User::getAge)
                .thenComparing(User::getlNames)
                .thenComparing(User::isSex)
        );
    }
}
