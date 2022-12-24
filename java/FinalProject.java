import java.util.*;

public class FinalProject {
    public static void main(String[] args) {
//Объявить и инициализировать экземпляр класса HashSet. Обобщение String.
//Добавить пять элементов в множество.

        Set<String> strings = new HashSet<>();
        strings.add("first");
        strings.add("second");
        strings.add("third");
        strings.add("fourth");
        strings.add("fifth");

//Отсортировать значения используя итератор.

        List<String> stringList = new ArrayList<>();
        Iterator<String> stringIterator = strings.iterator();
        while (stringIterator.hasNext()){
            stringList.add(stringIterator.next());
        }
        System.out.println(stringList); //[third, fifth, fourth, first, second][third, fifth, fourth, first, second]
        Collections.sort(stringList);
        System.out.println(stringList); //[fifth, first, fourth, second, third]


//Отсортированный результат сохранить в LinkedHashSet

        Set<String> stringSet = new LinkedHashSet<>();
        stringSet.addAll(stringList);
        System.out.println(stringSet); //[fifth, first, fourth, second, third]

//Создать TreeSet с компаратором.

        Set<String> treeSet = new TreeSet<>((o1, o2) -> {
            if(o1.equals(o2)){
                return 0;
            } else if (o1.compareTo(o2) > 0) {
                return 1;
            } else return -1;
        });

//Скопировать содержимое первого множества (HashSet) в TreeSet.

        treeSet.addAll(strings);
        System.out.println(treeSet); //[fifth, first, fourth, second, third]

//*Скорректировать компаратор так, чтобы поля хранились в обратном порядке.
        Set<String> treeSet2 = new TreeSet<>((o1, o2) -> {
            if(o1.equals(o2)){
                return 0;
            } else if (o1.compareTo(o2) > 0) {
                return - 1;
            } else return 1;
        });

        treeSet2.addAll(strings);
        System.out.println(treeSet2); //[third, second, fourth, first, fifth]
    }
}
