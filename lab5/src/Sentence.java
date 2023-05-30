public class Sentence {

    private final Word[] wordsArray = new Word[]{}; // Масив слів
    private final Punctuation[] punctuationsArray = new Punctuation[]{}; // Масив пунктуаційних знаків

    public Sentence(){} // Порожній конструктор класу Sentence

    public String getSentence(){ // Метод для отримання речення у вигляді рядка
        StringBuilder sentence = new StringBuilder(); // Об'єкт класу StringBuilder для збереження речення
        for(int i = 0; i < wordsArray.length; i++){ // Цикл для обходу всіх слів у масиві
            // Якщо в масиві слів зустрічається null, то на цьому місці має бути пунктуаційний знак
            if(wordsArray[i] != null){ // Якщо слово не є null, додаємо його до речення
                if (i == 0){
                    sentence.append(wordsArray[i].getWord()); // Якщо це перше слово, додаємо його без пробілу
                } else {
                    sentence.append(" ").append(wordsArray[i].getWord()); // Якщо це не перше слово, додаємо його з пробілом
                }
            } else { // Якщо слово є null, додаємо на його місце пунктуаційний знак
                sentence.append(punctuationsArray[i].getSymbol());
            }
        }
        return sentence.toString(); // Повертаємо речення у вигляді рядка
    }
}
