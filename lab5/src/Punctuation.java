public class Punctuation{

    private final char symbol; // Символ пунктуаційного знаку

    public Punctuation(char symbol) { // Конструктор класу Punctuation, приймає символ пунктуації
        this.symbol = symbol;
    }

    public char getSymbol() { // Метод для отримання символу пунктуаційного знаку
        return symbol;
    }
}
