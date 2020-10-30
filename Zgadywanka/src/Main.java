public class Main {

    public static void main(String[] args) {


        boolean startNewGame = true;
        Game game = new Game();

        do {
            switch (Game.gameNo) {
                case 1:
                    final String fileName = args[0];
                    game.init(fileName);
                    game.start();
                    game.playGame();
                    break;
                default:
                    System.out.println("default");
                    Game game1 = new Game();
                    game1.start();
                    game1.playGame();
                    break;
            }
        } while (startNewGame);
    }

//    public void increaseGameNo(){
//        gameNo++;
//    }
}

//    private static void prepareListOfWords() {
//        try {
//            FileReader reader = new FileReader();
//            Validator validator = new Validator();
//            result = reader.getListFromFile(fileName);
//            result = validator.validateList(result);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//    }

//    private static String prepareWordToGuess() {
//        Draw random = new Draw();
//        wordToGuess = random.drawWordFromList(result);
//        letterToShow = random.drawLetterFromWord(wordToGuess);
//        return wordToGuess;
//    }

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
//    }

//      what else can be change here?
//    private static String codeWordToGuess(String wordToGuess, char letterToShow) {
//        StringBuilder stringBuilder = new StringBuilder();
//        for (char c : wordToGuess.toCharArray()) {
//            if (c == letterToShow) {
//                stringBuilder.append(letterToShow);
//            } else {
//                stringBuilder.append("*");
//            }
//        }
//        return stringBuilder.toString();
//    }
