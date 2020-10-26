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

//        Game game = new Game();

        fileName = args[0];
//
        prepareListOfWords();
        System.out.println(result);
        System.out.println();
        wordToGuess = prepareWordToGuess();
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
//                return;
            }
            attempt++;
        } while (attempt <= numberOfAttempts);

        System.out.printf("\nSorry, but you lost all your attempts. The coded word was: \"%S\".", wordToGuess);
        System.exit(0);
    }


    // how to change this method using charArryay
    private static String checkUserAnswer(String wordToGuess, String codedWord, char letterFromUser) {

        char[] outputWordChars = codedWord.toCharArray();
        for (int i = 0; i < outputWordChars.length; i++) {
            if (wordToGuess.charAt(i) == letterFromUser) {
                outputWordChars[i] = letterFromUser;
            }
        }
        return String.valueOf(outputWordChars);
    }

//    private static String checkUserAnswer(String wordToGuess, String codedWord, char letterFromUser) {
//        char[] outputWordChars = codedWord.toCharArray();
//        for (int i = 0; i < outputWordChars.length; i++) {
//            if (wordToGuess.charAt(i) == letterFromUser) {
//                outputWordChars[i] = letterFromUser;
//            }
//        }
//        return String.valueOf(outputWordChars);
//    }


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
        Draw random = new Draw();
        wordToGuess = random.drawWordFromList(result);
        letterToShow = random.drawLetterFromWord(wordToGuess);
        return wordToGuess;
    }

//    private static String codeWordToGuess(String wordToGuess, char letterToShow) {
//        String hiddenWord = "";
//        for (char c : wordToGuess.toCharArray()) {
//            if (c == letterToShow) {
//                hiddenWord += letterToShow;
//            } else {
//                hiddenWord += "*";
//            }
//        }
//        return hiddenWord;

    //  what else can be change here?
    private static String codeWordToGuess(String wordToGuess, char letterToShow) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : wordToGuess.toCharArray()) {
            if (c == letterToShow) {
                stringBuilder.append(letterToShow);
            } else {
                stringBuilder.append("*");
            }
        }
        return stringBuilder.toString();
    }
}
