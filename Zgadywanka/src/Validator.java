import java.util.ArrayList;
import java.util.List;

// creating new list with words that are longer than 3 letters
public class Validator {
    public List<String> validateList(List<String> result) {
        List<String> finalResult = new ArrayList<>();
//        System.out.println(result.size());
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i).length() > 3) {
                finalResult.add(result.get(i));
            }
        }
        return finalResult;
    }
}
