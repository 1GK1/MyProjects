import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Game {
    private char letterAnswered;
    public static String wordToGuess;
    public String codedWord;
    public List<String> result;
    public Scanner scanner;
    public char letterToShow;
    private Draw draw;


    public Game() {
        System.out.println("Game starts...");
        scanner = new Scanner(System.in);
        draw = new Draw();
    }

    public void prepareListOfWords(String fileName) {
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
//        System.out.println("codeWord");
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

    public void init(String fileName) {
        prepareListOfWords(fileName);
        wordToGuess = prepareWordToGuess();
        codedWord = codeWordToGuess(wordToGuess, letterToShow);
    }
    // how to change this method using charArryay
    private String checkUserAnswer(String wordToGuess, String codedWord, char letterFromUser) {

        if (letterAnswered == '1') {
            System.out.println("\nThe player has stopped the game.");
            System.exit(0);
        }

        char[] outputWordChars = codedWord.toCharArray();
        for (int i = 0; i < outputWordChars.length; i++) {
            if (wordToGuess.charAt(i) == letterFromUser) {
                outputWordChars[i] = letterFromUser;
            }
        }
        return String.valueOf(outputWordChars);
    }

    public void start() {
        int attempt = 1;
        int numberOfAttempts = (int) (wordToGuess.length() * 1.5);
        System.out.printf("Your coded word has %d letters. You have %d attempts to guess it.\n\n", wordToGuess.length(), numberOfAttempts);
        System.out.println("Coded word: " + codedWord);

        do {
            System.out.print("Input letter [or press 1 to exit]: ");
            letterAnswered = scanner.next().charAt(0);
            codedWord = checkUserAnswer(wordToGuess, codedWord, letterAnswered);
            System.out.printf("\nCoded word after %d attempt: %s %n", attempt, codedWord);

            if (codedWord.equals(wordToGuess)) {
                System.out.println("You guessed the coded word! Congrat!");
                System.exit(0);
//                return;
            }

            attempt++;
        } while (attempt <= numberOfAttempts);

        System.out.printf("\nSorry, but you lost all your attempts. The coded word was: \"%S\".", wordToGuess);
        System.exit(0);
    }
}

