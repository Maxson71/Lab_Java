import java.util.Arrays;

public class Word {
    private Letter[] letters = new Letter[]{}; // Масив літер

    public Word(){} // Порожній конструктор класу Word

    public void addLetter(Letter letter){
        // Копіюємо масив та збільшуємо його розмір на 1
        letters = Arrays.copyOf(letters, letters.length+1);
        letters[letters.length - 1] = letter; // Додаємо літеру в кінець масиву
    }

    public String getWord(){
        StringBuilder word = new StringBuilder();
        for (Letter letter : letters) {
            word.append(letter.getCharacter()); // Додаємо кожну літеру до слова
        }
        return word.toString(); // Повертаємо слово у вигляді рядка
    }
}
