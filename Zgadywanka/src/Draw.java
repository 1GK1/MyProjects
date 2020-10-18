import java.util.List;
import java.util.Random;

public class Draw {
    Random random = new Random();

    public String drawWordFromList(List<String> result) {
//        Random random = new Random();
        int wordPositionInList = random.nextInt(result.size());
        String wordToGuess = result.get(wordPositionInList);
        return wordToGuess;
    }


    public char drawLetterFromWord(String wordToGuess) {
//        Random random = new Random();
        int letterPositionInWord = random.nextInt(wordToGuess.length());
        char letterToShow = wordToGuess.charAt(letterPositionInWord);
        return letterToShow;
    }
}
