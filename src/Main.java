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
        File directoryPath = new File("./kartaca");

        SolveZIP contentSolution = new SolveZIP();
        Map<String, String> fileNames = contentSolution.readFiles(directoryPath);

        ArrayList<String> content = contentSolution.solveMap(fileNames);

        // Creating and writing to the .txt file
        try {
            FileWriter contentWriter = new FileWriter("content.txt");

            contentWriter.write(contentSolution.displayContent(content));
            contentWriter.close();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
