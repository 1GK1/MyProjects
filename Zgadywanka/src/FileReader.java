import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileReader {
  public List<String> getListFromFile(String fileName) throws IOException {
      //todo simpler solution - dont you think ?
    return Files.readAllLines(Paths.get(fileName));
  }
}
