import java.util.Arrays;

public class Word {

    private Letter[] letters = new Letter[]{};

    public Word(){}

    public void addLetter(Letter letter){
        //Копіюємо масив та збільшуємо його розмір на 1
        letters = Arrays.copyOf(letters, letters.length+1);
        letters[letters.length - 1] = letter;
    }

    public String getWord(){
        StringBuilder word = new StringBuilder();
        for(int i = 0; i < letters.length; i++){
            word.append(letters[i].getCharacter());
        }
        return word.toString();
    }
}
