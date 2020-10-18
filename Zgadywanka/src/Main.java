import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    static String wordToGuess;
    static char letterToShow;
    static List<String> result;
    static String fileName;
    static String codedWord;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        fileName = args[0];

        prepareListOfWords();
        wordToGuess = prepareWordToGuess();  //what is better: method with String return or just method without return and no assigning, but global static fields?
        codedWord = codeWordToGuess(wordToGuess, letterToShow);

        int attempt = 1;
        int numberOfAttempts = (int) (wordToGuess.length() * 1.5);
        System.out.printf("Your coded word has %d letters. You have %d attempts to guess it.\n", wordToGuess.length(), numberOfAttempts);
        System.out.println("Coded word: " + codedWord);
        do {
            System.out.print("Input letter: ");
            char letterAnswer = scanner.next().charAt(0);
            codedWord = checkUserAnswer(wordToGuess, codedWord, letterAnswer);
            System.out.printf("Coded word after %d attempt: %s %n", attempt, codedWord);
            if (codedWord.equals(wordToGuess)) {
                System.out.println("You guessed the coded word! Congrat!");
                System.exit(0);
            }
            attempt++;
        } while (attempt <= numberOfAttempts);

        if (!codedWord.equals(wordToGuess)) {
            System.out.printf("\nSorry, but you lost all your attempts. The coded word was: \"%S\".", wordToGuess);
            System.exit(0);
        }
    }


    private static String checkUserAnswer(String wordToGuess, String hiddenWord, char letterFromUser) {
        char[] outputWordChars = hiddenWord.toCharArray();
        for (int i = 0; i < outputWordChars.length; i++) {
            if (wordToGuess.charAt(i) == letterFromUser) {
                outputWordChars[i] = letterFromUser;
            }
        }
        return String.valueOf(outputWordChars);
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

    private static String prepareWordToGuess() {
        Draw randomWord = new Draw();
        Draw randomLetter = new Draw();
        wordToGuess = randomWord.drawWordFromList(result);
//        System.out.println("Word to guess: " + wordToGuess);
        letterToShow = randomLetter.drawLetterFromWord(wordToGuess);
//        System.out.println("Chosen letter: " + letterToShow);
        return wordToGuess;
    }

    private static String codeWordToGuess(String wordToGuess, char letterToShow) {
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
}
