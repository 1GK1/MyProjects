import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FileReader {
    public List<String> getListFromFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);

        List<String> result = new ArrayList<>();
        while(scanner.hasNextLine()) {
//            String a = scanner.nextLine().trim();
            String a = scanner.next().trim();  // better solution than the one above because solves the problem of white spaces between words in list
//            List<String> list = Arrays.stream(a.split(" ")).collect(Collectors.toList());
            List<String> list = Arrays.asList(a.split(" "));
            result.addAll(list);
        }
        return result;
    }
}
