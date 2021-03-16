import java.io.File;
import java.util.Map;

/**
 * Project: Kartaca
 * Package: PACKAGE_NAME
 * <p>
 *
 * @author İbrahim Başar YARGICI
 * Date 16.03.2021
 */
public class Main {

    public static void main(String[] args) throws Exception {
        SolveZIP solution = new SolveZIP();
        File directoryPath = new File("./kartaca");
        Map<String, String> fileNames = solution.readNames(directoryPath);

        for (String key : fileNames.keySet()) {
            // sort keys and assign to the fileNames
            System.out.println(key + "\t" + fileNames.get(key));
        }
    }
}
