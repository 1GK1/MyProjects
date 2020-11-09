import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTestJ4 {

    private static final String FILE_NAME = "input1.txt";
    private String expectedResult;
    private List<String> result;
    Game game;



    // if the list has 100 elements the only way to prepare test list
    // is to use the same method prepareListOfWords - but using the same method we don't test anything, list will be the same...
    //if we change the method test will not help us to find errors...
    @BeforeEach
    void setup() {
        game = new Game();
//        expectedResult = new ArrayList<>(game.prepareListOfWords(FILE_NAME));
        expectedResult = "[variable, songs, attack, popcorn, bites, chin, brake, wrist, rhythm, pump, steel, deer, beetle, operation, toes, goose, rose, need, women, vase, clover, alarm, leaf, volleyball, soup, cheese, walk, things, iron, curtain, toad]";
//        expectedResult.add("mean");
//        expectedResult.add("bite1");

    }

    @Test
    void checkIfFileReaderWorks() {
        result = game.prepareListOfWords(FILE_NAME);
//        System.out.println(result.toString());
        assertEquals(expectedResult, result.toString());
    }
}