import java.io.FileNotFoundException;
import java.util.List;

public class Game {
    private String wordToGuess;
    private final String codedWord;
    private String fileName;
    private List<String> result;
    //     constructor
    //     what to put here?
    public Game() {
        System.out.println("Game starts...");
        prepareListOfWords();
        wordToGuess = prepareWordToGuess();
        //todo: brak importu tej zmiennej, dodalem ten import poprzez: Main.letterToShow (tak sie zdobywa dostep do zmiennych statycznych) mimo wszystko nie polecam z nich korzystac.
        codedWord = codeWordToGuess(wordToGuess, Main.letterToShow);
    }

    private void prepareListOfWords() {
        try {
            FileReader reader = new FileReader();
            Validator validator = new Validator();
            //todo tutaj brakuje ci zmiennej filename - moze trzeba ja podac z argumentu ? jezeli tworzysz stattyczna funkcje to nie mozesz w niej uzyc nie statycznego pola. ,stad nie udalo sie znalesc zmiennej filename  bedacej polem tej klasy.
            // usunalem wiec static z tej metody

            //todo tutaj brakowalo wprowadzenia zmiennej - pytanie co z nia teraz ?
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
        //todo tutaj wordToGuess byl typu final - nie mozna jej redeklarowac
        wordToGuess = random.drawWordFromList(result);
        Main.letterToShow = random.drawLetterFromWord(wordToGuess);
        return wordToGuess;
    }
}

