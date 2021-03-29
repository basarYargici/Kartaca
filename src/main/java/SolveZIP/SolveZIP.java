package SolveZIP;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * @author İbrahim Başar YARGICI
 * @date 16.03.2021
 */
public class SolveZIP {

    /**
     * This function takes binary code and convert it to String.
     *
     * @param binaryInStringForm is the binary code
     * @return converted String
     */
    public String binaryToString(String binaryInStringForm) {
        String[] ss = binaryInStringForm.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ss.length; i++) {
            sb.append((char) Integer.parseInt(ss[i], 2));
        }
        return sb.toString();
    }

    /**
     * This method reads and displays the content beautifully.
     *
     * @param directoryPath is the path of directory which will be examined.
     * @return name of all files in directoryPath
     * @throws Exception if file not found
     */
    public String[] displayFile(File directoryPath) throws Exception {
        //Creating a File object for directory
        try {
            //List of all files and directories
            File[] filesList = directoryPath.listFiles();
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

        } catch (IllegalArgumentException | FileNotFoundException iae) {
            throw new Exception("File Not Found");
        }
    }

    /**
     * This method returns list of files that directory contains.
     *
     * @param directoryPath is the path of directory which will be examined.
     * @return all files that directoryPath contains
     * @throws Exception if any exception occurs
     */
    public File[] getFileList(File directoryPath) throws Exception {
        try {
            return directoryPath.listFiles();
        } catch (Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }

    /**
     * This method takes all file names and returns map whose key is name of file and value is the String form of binary content.
     *
     * @param directoryPath is the path of directory which will be examined.
     * @return Map of file name and content
     * @throws Exception if any error occures
     */
    public Map<String, String> readFiles(File directoryPath) throws Exception {
        File[] filesList = getFileList(directoryPath);
        Map<String, String> names = new HashMap<>();

        Scanner sc = null;
        for (File file: filesList) {
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

    /**
     * This method is the decoder of given Map. It will decode the files as requested.
     *
     * @param fileMap is the map which contains all name of files and contents.
     * @return String type of ArrayList which only contains contents of Map as requested.
     */
    public ArrayList<String> solveMap(Map<String, String> fileMap) {
        Map<String, String> tempMap = new TreeMap<>();
        Map<String, String> twoDigits = new HashMap<>();
        Map<String, String> threeDigits = new HashMap<>();
        Map<String, String> fourDigits = new HashMap<>();
        ArrayList<String> content = new ArrayList<>();

        for (String key: fileMap.keySet()) {
            if (key.startsWith("==", 2)) {
                twoDigits.put(key, fileMap.get(key));
            } else if (key.charAt(3) == '=') {
                threeDigits.put(key, fileMap.get(key));
            } else {
                fourDigits.put(key, fileMap.get(key));
            }
        }

        Map<String, String> treeMap = new TreeMap<>(twoDigits);
        for (String key: treeMap.keySet()) {
            content.add(treeMap.get(key));
        }

        treeMap = new TreeMap<>(threeDigits);
        for (String key: treeMap.keySet()) {
            content.add(treeMap.get(key));
        }

        // last digit of all four digit names contains characters and numbers. In TreeMap sorting, characters
        // comes first, but numbers wanted first.
        treeMap = new TreeMap<>(fourDigits);
        int count = 0, chCount = 0;
        for (String key: treeMap.keySet()) {
            if (key.charAt(key.length() - 1) >= 97 && key.charAt(key.length() - 1) <= 122 && count == 6) {
                content.add(treeMap.get(key));
                chCount++;
                if (chCount >= 4) {
                    count = 0;
                    chCount = 0;
                    for (String key2: tempMap.keySet()) {
                        content.add(tempMap.get(key2));
                    }
                    tempMap.clear();
                }
            } else {
                tempMap.put(key, treeMap.get(key));
                count++;
            }
        }

        // for last 6 names
        for (String key2: tempMap.keySet()) {
            content.add(tempMap.get(key2));
        }

        return content;
    }

    /**
     * This method takes String type of ArrayList and converts it to String with the help of StringBuilder.
     *
     * @param content is the list of content
     * @return String type of content
     */
    public String displayContent(ArrayList<String> content) {
        StringBuilder correctedContentHelper = new StringBuilder();
        String correctedContent;
        content.forEach(correctedContentHelper::append);

        correctedContent = correctedContentHelper.toString();

        return correctedContent;
    }
}