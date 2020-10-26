import java.io.FileNotFoundException;

public class Game {
    private final String wordToGuess;
    private final String codedWord;
    private String fileName;
//     constructor
//     what to put here?
    public Game() {
        System.out.println("Game starts...");
        prepareListOfWords();
        wordToGuess = prepareWordToGuess();
        codedWord = codeWordToGuess(wordToGuess, letterToShow);
    }

    private static void prepareListOfWords() {
        try {
            FileReader reader = new FileReader();
            Validator validator = new Validator();
            result = reader.getListFromFile(fileName);
            result = validator.validateList(result);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    private String codeWordToGuess(String wordToGuess, char letterToShow) {
        // StringBuilder! charArray!
        String hiddenWord = "";
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == letterToShow) {
                hiddenWord += letterToShow;
            } else {
                hiddenWord += "*";
            }
        }
        return hiddenWord;
    }

    private String prepareWordToGuess() {
        Draw random = new Draw();
        wordToGuess = random.drawWordFromList(result);
        letterToShow = random.drawLetterFromWord(wordToGuess);
        return wordToGuess;
    }
}

