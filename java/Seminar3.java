import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Seminar3 {
    public static void main(String[] args) {

//Создать новый список, добавить несколько строк и вывести коллекцию на экран.
        List<String> strings = new ArrayList<>();
        strings.add("hello");
        strings.add("world");
        strings.add("white");
        System.out.println(strings);//[hello, world, white]

//Итерация всех элементов списка цветов и добавления к каждому символа '!'.
        List<String> colors = new ArrayList<>();
        colors.add("red");
        colors.add("green");
        colors.add("blue");
        colors.add("black");
        colors.add("white");

        List<String> newColors = colors.stream()
                .map(s -> s + "!")
                .collect(Collectors.toList());

        System.out.println(newColors);//[red!, green!, blue!, black!, white!]

//Вставить элемент в список в первой позиции.
        strings.add(0, "first");
        System.out.println(strings);//[first, hello, world, white]

//Извлечь элемент (по указанному индексу) из заданного списка.
        System.out.println(strings.get(0)); //first

//Обновить определенный элемент списка по заданному индексу.
        strings.set(0, "second");
        System.out.println(strings);
        //before: [first, hello, world, white]
        //after: [second, hello, world, white]

//Удалить третий элемент из списка.
        newColors.remove(3);
        System.out.println(newColors);
        //before: [red!, green!, blue!, black!, white!]
        //after: [red!, green!, blue!, white!]

//Поиска элемента в списке по строке.
        System.out.println(newColors.indexOf("red!"));//0

//Создать новый список и добавить в него несколько елементов первого списка.
        List<String> list = new ArrayList<>();
        list.add(strings.get(0));
        list.add(strings.get(1));
        System.out.println(list); //[second, hello]

        System.out.println("__________________________");

//Удалить из первого списка все элементы отсутствующие во втором списке.
        List<String> copy = new ArrayList<>(strings.size());
        copy.addAll(0, strings);
        System.out.println(copy); //[second, hello, world, white]
        System.out.println("First list" + strings); //First list[second, hello, world, white]
        System.out.println("Second list" + colors); //Second list[red, green, blue, black, white]
        for (int i = 0; i < copy.size(); i++) {
            String value = copy.get(i);
                if (!colors.contains(value)) {
                    strings.remove(value);
            }
        }
        System.out.println("First list" + strings); //First list[white]
        System.out.println("Second list" + colors); //Second list[red, green, blue, black, white]

        System.out.println("__________________________");

//*Сортировка списка.
        Collections.sort(colors);
        System.out.println(colors);//[black, blue, green, red, white]

//*Сравнить время работы тысячи повторений пункта 3 для ArrayList и LinkedList.

        long time = System.currentTimeMillis();
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            stringList.add(0, "first");
        }
        System.out.print("For ArrayList need Millis: ");
        System.out.println(System.currentTimeMillis() - time);//6

        long time2 = System.currentTimeMillis();
        List<String> stringList2 = new LinkedList<>();
        for (int i = 0; i < 1000; i++) {
            stringList2.add(0, "first");
        }
        System.out.print("For LinkedList need Millis: ");
        System.out.println(System.currentTimeMillis() - time2);//2
    }
}


