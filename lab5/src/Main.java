import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // В усіх питальних реченнях заданого тексту знайти
        // та надрукувати без повторень слова заданої довжини.

        ArrayList<String> words = new ArrayList<>(); // масив для збереження знайдених слів

        System.out.println("Введіть текст:");
        String textString = scanner.nextLine();

        System.out.println("Введіть довжину слова:");
        int wordLength = scanner.nextInt();

        // Ділимо текст на речення
        String[] textSentences = textString.replaceAll("\\s+", " ").split("(?<=[.!?;])\\s*");

        // Додаємо до масиву лише речення що закінчуються на знаки питання (тобто питальні речення)
        ArrayList<String> result = new ArrayList<>();
        for (String element : textSentences) {
            if (element.endsWith("?")) {
                result.add(element);
            }
        }
        String[] textSentencesQuestion = result.toArray(new String[0]);

        // Проходимо кожне речення
        for (String s : textSentencesQuestion) {

            //Ділимо кожне речення на слова та пункутацію

            String[] textWords = s.split("(?U)\\b");
            // (?U) - це прапорець, який вказує на включення режиму Unicode-aware для регулярного виразу.
            // Це означає, що регулярний вираз буде працювати з Unicode-символами правильно.
            //
            //  \\b - це метасимвол, який відповідає границі слова. Використовується для розділення слів.

            //Ітеруємо кожне слово та пунктуаційний знак в масиві слів речення
            for (String currentWord : textWords) {

                // Перевірка на пустий символ
                if (!currentWord.matches("\\s+") && !currentWord.equals(" ")) {
                    // Зберігаємо слово, якщо воно потрібної довжини
                    if (currentWord.length() == wordLength) {
                        // Перевірка на пунктуаційний знак
                        if (currentWord.length() == 1) {
                            char character = currentWord.charAt(0);
                            if (Character.isLetter(character) || Character.isDigit(character)) {

                                Word word = new Word();
                                word.addLetter(new Letter(character));
                                // Перевірка чи немає ще таких самих слів
                                if (!words.contains(word.getWord())) {
                                    words.add(word.getWord());
                                }
                            }
                        } else {
                            // Складання слова
                            Word word = new Word();
                            for (int letterIndex = 0; letterIndex < currentWord.length(); letterIndex++) {
                                word.addLetter(new Letter(currentWord.charAt(letterIndex)));
                            }
                            // Перевірка чи немає ще таких самих слів
                            if (!words.contains(word.getWord())) {
                                words.add(word.getWord());
                            }
                        }
                    }
                }
            }
        }
        // Перевірка чи знайшлись такі слова і вививід їх
        if (words.isEmpty()) {
            System.out.println("Слів такої довжини не знайдено.");
        } else {
            System.out.println("Список знайдених слів: ");
            System.out.println(words);
        }
    }
}