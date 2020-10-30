import java.io.FileNotFoundException;

public class Main {

  public static void main(String[] args) {

    final Game game = new Game();
    final String fileName;
    try {
      fileName = getFileNameFromProgramArguments(args);
      game.init(fileName);
      //todo this is my handler for situation where no file was loaded
      while (!game.isGameOver() && !game.wordsFromFile.isEmpty()) {
        game.start();
        game.playGame();
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  private static String getFileNameFromProgramArguments(final String[] args) throws FileNotFoundException {
    if (args.length > 0) {
      return args[0];
    } else {
      throw new FileNotFoundException("Cannot find program argument, please specify them in the: Run/Debug configuration -> Program Arguments.");
    }
  }
}
