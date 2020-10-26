import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// creating new list with words that are longer than 3 letters
public class Validator {
    public List<String> validateList(List<String> result) {
//        List<String> finalResult = new ArrayList<>();
//        for (String s : result) {
//            if (s.length() > 3) {
//                finalResult.add(s);
//            }
//        }

        return result.stream()
                .filter(a -> a.length() > 3)
                .collect(Collectors.toList());





//        return finalResult;
    }
}
