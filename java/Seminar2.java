public class Seminar2 {
    public static void main(String[] args) {
//Напишите программу, чтобы найти вхождение в строке (содержащей все символы другой строки).

        String str1 = "hello";
        String str2 = "world, hello";
        int index = str2.indexOf(str1);
        System.out.println(index);

//Напишите программу, чтобы проверить, являются ли две данные строки вращением друг друга (вхождение в обратном порядке).

        String string1 = "hello";
        String string2 = "olleh";
        StringBuilder builder = new StringBuilder();
        String reversString = builder.append(string2).reverse().toString();
        System.out.println(string1.equals(reversString) ? "yes" : "no");


//Дано два числа, например 3 и 56, необходимо составить следующие строки: 3 + 56 = 59 3 – 56 = -53 3 * 56 = 168
// Используем метод StringBuilder.append().

        int first = 3;
        int second = 56;

        StringBuilder builder2 = new StringBuilder();
        builder2.append(first + " + " + second + " = " + (first + second) + " ");
        builder2.append(first + " - " + second + " = " + (first - second) + " ");
        builder2.append(first + " * " + second + " = " + (first * second) + " ");
        System.out.println(builder2); // 3 + 56 = 59 3 - 56 = -53 3 * 56 = 168

//Замените символ “=” на слово “равно”. Используйте методы StringBuilder.insert(),StringBuilder.deleteCharAt().
        int indexOf;
        do {
            indexOf = builder2.indexOf("=");
            if (indexOf != -1) {
                builder2.deleteCharAt(indexOf);
                builder2.insert(indexOf, "равно");
            }
        } while (indexOf != -1);
        System.out.println(builder2); //3 + 56 равно 59 3 - 56 равно -53 3 * 56 равно 168

//*Замените символ “=” на слово “равно”. Используйте методы StringBuilder.replace().

        int x;
        do {
            x = builder2.indexOf("=");
            if (x != -1) {
                builder2.replace(x, x + 1, "равно");
            }
        } while (x != -1);
        System.out.println(builder2); //3 + 56 равно 59 3 - 56 равно -53 3 * 56 равно 168

//**Сравнить время выполнения пунка 6 со строкой содержащей 10000 символов "=" средствами String и StringBuilder.

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            stringBuilder.append('=');
        }

        long time = System.currentTimeMillis();
        int ind;
        do {
            ind = stringBuilder.indexOf("=");
            if (ind != -1) {
                stringBuilder.replace(ind, ind + 1, "равно");
            }
        } while (ind != -1);
        System.out.print("For stringBuilder need Millis: ");
        System.out.println(System.currentTimeMillis() - time); // 255



        StringBuilder stringBuilder2 = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            stringBuilder2.append('=');
        }
        String test = stringBuilder2.toString();

        long time2 = System.currentTimeMillis();
        String value = test.replace("=", "равно");
        System.out.println(value);
        System.out.print("For String need Millis: ");
        System.out.println(System.currentTimeMillis() - time2); // 24
    }


    //*Напишите программу, чтобы перевернуть строку с помощью рекурсии.
    public static String reverseString(String String) {
        String firstStr;
        String secondStr;
        int length = String.length();

        if (length <= 1) {
            return String;
        }

        secondStr = String.substring(0, length / 2);
        firstStr = String.substring(length / 2, length);

        return reverseString(firstStr) + reverseString(secondStr);
    }
}
