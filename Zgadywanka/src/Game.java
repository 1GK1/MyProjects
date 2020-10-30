import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Game {
  private final FileReader reader;
  private final Validator validator;
  public String wordToGuess;
  public String codedWord;
  public List<String> wordsFromFile;
  public Scanner scanner;
  public char letterToShow;
  private char letterAnswered;
  private int numberOfAttempts;
  private int attempt;
  private boolean gameOver;

  public Game() {
    System.out.println("Game starts...");
    scanner = new Scanner(System.in);
    gameOver = false;
    reader = new FileReader();
    validator = new Validator();
    wordsFromFile = new ArrayList<>();
  }

  // I want to invoke this method only once, when the game begins; if the player wants to continue
  // the game, the same list of words must be used
  public void init(String fileName) {
    // todo i add this return value because it is more readable;
    wordsFromFile = prepareListOfWords(fileName);
    final String message =
        wordsFromFile.isEmpty()
            ? "File not found or is empty"
            : "The list has words: {}" + wordsFromFile.size();
    System.out.println(message);
  }

  private String prepareWordToGuess() {
    Draw random = new Draw();
    wordToGuess = random.drawWordFromList(wordsFromFile);
    // todo here you delete current words so it will not be considered in the next round.
    wordsFromFile.remove(wordToGuess);
    System.out.println("The list has words: " + wordsFromFile.size());
    System.out.println();
    letterToShow = random.drawLetterFromWord(wordToGuess);
    return wordToGuess;
  }

  public List<String> prepareListOfWords(String fileName) {
    try {
      System.out.println("Preparing list of words");
      return validator.validateList(reader.getListFromFile(fileName));
    } catch (IOException e) {
      // todo this is critical problem - please create strategy to handle it.
      e.printStackTrace();
      // todo this method should provide list of words or end program !
      return Collections.emptyList();
    }
  }

  private String codeWordToGuess(String wordToGuess, char letterToShow) {
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

  public void start() {
    wordToGuess = prepareWordToGuess();
    codedWord = codeWordToGuess(wordToGuess, letterToShow);

    numberOfAttempts = (int) (wordToGuess.length() * 1.5);
    System.out.printf(
        "Your coded words has %d letters. You have %d attempts to guess it.\n\n",
        wordToGuess.length(), numberOfAttempts);
    System.out.println("Coded words: " + codedWord);
  }

  public void playGame() {

    System.out.print("Input letter [or press 1 to exit]: ");
    letterAnswered = scanner.next().charAt(0);
    codedWord = checkUserAnswer(wordToGuess, codedWord, letterAnswered);
    System.out.printf("\nCoded words after %d attempt: %s %n", attempt, codedWord);

    if (codedWord.equals(wordToGuess)) {
      System.out.println("You guessed the coded words! Congrat!");
      // todo set gameOver flag - ask user if he want to continue or not.
      gameOver = true;
    }
  }

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

  public boolean isGameOver() {
    return gameOver;
  }

  public void setGameOver(final boolean gameOver) {
    this.gameOver = gameOver;
  }
}
