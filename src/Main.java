import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
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
        SolveZIP contentSolution = new SolveZIP();
        File directoryPath = new File("./kartaca");
        Map<String, String> fileNames = contentSolution.readNames(directoryPath);
        ArrayList<String> content = null;

        content = contentSolution.solveMap(fileNames);

        try {
            File contentFile = new File("content.txt");
            FileWriter contentWriter = new FileWriter("content.txt");

            contentWriter.write(contentSolution.displayContent(content));
            contentWriter.close();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
