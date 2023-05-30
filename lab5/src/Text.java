public class Text {

    private final Sentence[] sentencesArray; // Масив речень

    public Text(Sentence[] sentences){ // Конструктор класу Text, приймає масив речень
        this.sentencesArray = sentences;
    }

    public Sentence[] getSentencesArray() { // Метод для отримання масиву речень
        return sentencesArray;
    }

    public String getText(){ // Метод для отримання тексту, утвореного з речень
        StringBuilder text = new StringBuilder();
        for (Sentence sentence : sentencesArray) { // Цикл для обходу всіх речень у масиві
            text.append(sentence.getSentence()); // Додавання речення до тексту
        }
        return text.toString(); // Повертаємо текст у вигляді рядка
    }
}
