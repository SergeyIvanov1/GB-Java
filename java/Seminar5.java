import java.util.*;
import java.util.stream.Stream;

public class Seminar5 {
    public static void main(String[] args) {
//Создать словарь HashMap. Обобщение <Integer, String>.

        Map<Integer, String> map = new HashMap<>();

//Заполнить пятью ключами (индекс, ФИО+Возраст+Пол "Иванов Иван Иванович 28 м"), добавить ключь, если не было!)

        map.put(0, "Иванов Иван Иванович 32 м");
        map.put(1, "Петров Петр Петрович 31 м");
        map.put(2, "Сидоров Сидр Сидорович 30 м");
        map.put(3, "Жукова Светлана Владимировна 29 ж");
        map.put(4, "Громова Екатеринна Васильевна 28 ж");
        System.out.println("map = " + map);

//Изменить значения сделав пол большой буквой.

        map.entrySet().stream()
                .flatMap(entrySet -> {
                    String[] strings = entrySet.getValue().split(" ");
                    strings[4] = strings[4].toUpperCase();
                    String value = String.join(" ", strings);
                    entrySet.setValue(value);
                    return Stream.of(entrySet);
                })
                .forEach(System.out::println);

//        0=Иванов Иван Иванович 32 М
//        1=Петров Петр Петрович 31 М
//        2=Сидоров Сидр Сидорович 30 М
//        3=Жукова Светлана Владимировна 29 Ж
//        4=Громова Екатеринна Васильевна 28 Ж

//Пройти по коллекции и вывести значения в формате Фамилия инициалы "Иванов И.И."

        map.entrySet().stream()
                .flatMap(entrySet -> {
                    String[] strings = entrySet.getValue().split(" ");
                    String lastName = strings[0];
                    String firstLetter = strings[1].charAt(0) + ".";
                    String secondLetter = strings[2].charAt(0) + ".";
                    return Stream.of(lastName + " " + firstLetter + secondLetter);
                })
                .forEach(System.out::println);

//                Иванов И.И.
//                Петров П.П.
//                Сидоров С.С.
//                Жукова С.В.
//                Громова Е.В.

//*Сортировать значения по возрасту и вывести отсортированную коллекция как в четвёртом пункте.

        map.entrySet().stream()
                .sorted(Comparator.comparingInt(o -> Integer.parseInt(o.getValue().split(" ")[3])))
                .forEach(System.out::println);

//        4=Громова Екатеринна Васильевна 28 Ж
//        3=Жукова Светлана Владимировна 29 Ж
//        2=Сидоров Сидр Сидорович 30 М
//        1=Петров Петр Петрович 31 М
//        0=Иванов Иван Иванович 32 М
    }
}
