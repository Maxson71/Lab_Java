import java.util.Scanner;
import java.util.ArrayList;

public class Lab3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = 2230;
        int wordLength;

        // Виведення варіанту
        System.out.print("C3 = " + number % 3);  // 1 -	StringBuffer
        System.out.print("\nC17 = " + number % 17);  // 3 - В усіх питальних реченнях заданого тексту знайти
                                                     // та надрукувати без повторень слова заданої довжини.

        // Зчитування тексту
        System.out.print("\nВведіть текст: ");
        StringBuffer text = new StringBuffer(scanner.nextLine());

        try {
            // Зчитування довжини шуканих слів
            System.out.print("Введіть довжину слів, які потрібно знайти у питальних реченнях: ");
            wordLength = Integer.parseInt(scanner.nextLine());
            text.append(" ");
        } catch (NumberFormatException e) {
            System.out.print("Число введено некоректно!\n");
            return;
        }

        //  Перевірка тексту на наявність питальних речень
        if ((text.indexOf("?")) == -1) {
            System.out.print("Потрібних слів не знайдено, оскільки у тексті немає питальних речень.");
            return;
        }
        //  видалння !
        while (text.indexOf("!") != -1) {
            text.replace(text.indexOf("!"), text.indexOf("!") + 1, ".");
        }
        //  видалння ;
        while (text.indexOf(";") != -1) {
            text.replace(text.indexOf(";"), text.indexOf(";") + 1, ".");
        }

        int index = 0;
        // Видалення всіх непитальних речень
        while (text.indexOf(".") != -1) {
            //  видалення простих речень
            if (text.indexOf(".") < text.indexOf("?") || text.indexOf("?") == -1) {
                text.delete(index, text.indexOf(".") + 1);
            } else if (text.indexOf(".") > text.indexOf("?")) {
                index = text.indexOf("?");
                text.replace(index, index + 1, "");
            }
        }

        if (text.indexOf("?") != -1){
            text.replace(text.indexOf("?"), text.indexOf("?") + 1, "");
        }

        //  видалння ,
        while (text.indexOf(",") != -1) {
            text.replace(text.indexOf(","), text.indexOf(",") + 1, "");
        }
        //  видалння :
        while (text.indexOf(":") != -1) {
            text.replace(text.indexOf(":"), text.indexOf(":") + 1, "");
        }
        //  видалння "
        while (text.indexOf("\"") != -1) {
            text.replace(text.indexOf("\""), text.indexOf("\"") + 1, "");
        }
        //  видалння '
        while (text.indexOf("\'") != -1) {
            text.replace(text.indexOf("\'"), text.indexOf("\'") + 1, "");
        }

        ArrayList<String> words = new ArrayList<>();

        //  Знаходження слів потрібної дожини
        while (text.indexOf(" ") != -1) {
            if (!words.contains(text.substring(0, text.indexOf(" "))) && text.indexOf(" ") == wordLength) {
                words.add(text.substring(0, text.indexOf(" ")));
            }
            text.delete(0, text.indexOf(" ") + 1);
        }
        words.remove("");
        words.remove("-");
        if (words.isEmpty()) {
            System.out.print("Слів такої довжини не знайдено.");
        } else {
            System.out.print("Список знайдених слів: ");
            System.out.print(words);
        }
    }
}
// 1 111 1. 2 '21' '22' 2, 22 - "222"? 3, 3, 3,!!! 4: 44 4; 5: 55? 6. 777!
