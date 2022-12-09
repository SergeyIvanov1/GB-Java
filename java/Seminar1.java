import java.util.*;

public class Seminar1 {
    public static void main(String[] args) {
        int i = new Random().nextInt(0, 2000 );
        System.out.println(i);

        List<Integer> numbers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("input number: ");
        int n = scanner.nextInt();

        for (int j = i; j < Short.MAX_VALUE; j++) {
            if (j % n == 0){
                numbers.add(j);
            }
        }
        Integer[] m1 = numbers.toArray(Integer[]::new);
        System.out.println(Arrays.toString(m1));

        numbers.clear();
        for (int k = Short.MAX_VALUE; k > i; k--) {
            if (k % n != 0){
                numbers.add(k);
            }
        }

        Integer[] m2 = numbers.toArray(Integer[]::new);
        System.out.println(Arrays.toString(m2));
    }
}
