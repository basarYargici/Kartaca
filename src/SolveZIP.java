import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Project: Kartaca
 * Package: PACKAGE_NAME
 * <p>
 *
 * @author İbrahim Başar YARGICI
 * Date 16.03.2021
 */
public class SolveZIP {

    public String binaryToString(String s) {
        String[] ss = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ss.length; i++) {
            sb.append((char) Integer.parseInt(ss[i], 2));
        }
        return sb.toString();
    }

    public String[] displayFile(File directoryPath) throws Exception {
        //Creating a File object for directory
        try {
            //List of all files and directories
            File[] filesList = directoryPath.listFiles();
            if (filesList != null) {
                String[] fileNames = new String[filesList.length];
                System.out.println("List of files and directories in the specified directory:");
                Scanner sc = null;
                int counter = 1;

                System.out.println("ct\tName\tContent Binary\t\t\t\t\t\t\t\t\tContent String");
                System.out.println("--------------------------------------------------------------------------");

                for (int i = 0; i < filesList.length; i++) {
                    fileNames[i] = filesList[i].getName();
                    System.out.print(counter + "\t" + filesList[i].getName());
                    //Instantiating the Scanner class
                    sc = new Scanner(filesList[i]);
                    String input;
                    StringBuffer sb = new StringBuffer();
                    while (sc.hasNextLine()) {
                        input = sc.nextLine();
                        sb.append(input);
                    }
                    System.out.println("\t" + sb.toString() + "\t" + binaryToString(sb.toString()));
                    counter++;
                }
                return fileNames;
            }
            throw new Exception("Empty Folder");
        } catch (IllegalArgumentException | FileNotFoundException iae) {
            throw new Exception("File Not Found");
        }
    }

    public File[] getFileList(File directoryPath) throws Exception {
        try {
            return directoryPath.listFiles();
        } catch (Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }

    public Map<String, String> readNames(File directoryPath) throws Exception {
        File[] filesList = getFileList(directoryPath);
        Map<String, String> names = new HashMap<>();

        Scanner sc = null;
        for (File file : filesList) {
            sc = new Scanner(file);
            String input;
            StringBuilder sb = new StringBuilder();
            while (sc.hasNextLine()) {
                input = sc.nextLine();
                sb.append(input);
            }
            names.put(file.getName(), binaryToString(sb.toString()));
        }
        return names;
    }
}