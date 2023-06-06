package game.SaveFunction;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import game.GameRuleRegulation.MillCondition;
import game.Players.Player;
import game.UIComponents.Board;
import game.UIComponents.GamePage;
import game.UndoFunction.GameStateEditor;

import java.io.*;

/**
 * This class is a save strategy used to save the gamestate as a .txt and restore from .txt
 *
 * @author Garret Yong Shern Min
 * @version 1.0 3/6/2023
 */
public class txtSaveStrategy extends SaveStrategy {
    public txtSaveStrategy(SaveObj saveObj) {
        super.saveStrategy(saveObj);
    }
    @Override
    public SaveObj restoreToProgress() {
        String filePath = getDirectorySaveProgress();

        try {
            // Read the contents of the text file
            String jsonString = readTextFile(filePath);

            // Remove the surrounding quotes if present
            if (jsonString.startsWith("\"") && jsonString.endsWith("\"")) {
                jsonString = jsonString.substring(1, jsonString.length() - 1);
            }

            // Create a Gson object
            Gson gson = new Gson();

            // Parse the JSON string into an object
            LinkedTreeMap<String,Object> data = gson.fromJson(jsonString, LinkedTreeMap.class);
            this.getSaveObj().restore(data);

            return this.getSaveObj();

        } catch (IOException e) {
            System.out.println("Error reading the text file: " + e.getMessage());
        }
        return null;
    }

    @Override
    public void saveProgress() {
        String filePath = getDirectorySaveProgress();
        Object result = getSaveObj().shelve();
        String json = objectToJson(result);

        // Check if the file exists
        File file = new File(filePath);
        if (file.exists()) {
            // File exists, rewrite the contents
            rewriteFileContents(file, json);
            System.out.println("File contents rewritten.");
        } else {
            // File does not exist, create a new file and write to it
            createAndWriteToFile(file, json);
            System.out.println("New file created and written.");
        }
    }

    /**
     * Parse given object to String
     *
     * @param object that is required to be turned into a String
     * @return a json string
     */
    private String objectToJson(Object object) {
        Gson gson = new Gson();
        String jsonString = gson.toJson(object);
        return jsonString;
    }

    /**
     * Retrieve current file directory to the 9MM save file
     *
     * @return current filepath
     */
    private String getDirectorySaveProgress() {
        String workingDir = System.getProperty("user.dir");
        String filePath = workingDir + File.separator + "9MMsaveFile.txt";
        return filePath;
    }

    /**
     * Method used to rewrite the data of an existing file
     *
     * @param file the file that needs to be written to
     * @param writeData the data that needs to be written on the file
     */
    private static void rewriteFileContents(File file, String writeData) {

        try {
            // Create a FileWriter with append mode set to false (overwrite)
            FileWriter writer = new FileWriter(file, false);

            // Write the desired contents to the file
            writer.write(writeData);
            writer.write("\n");

            // Close the FileWriter
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method used to create a file and write data to said file
     *
     * @param file the file that needs to be written to
     * @param writeData the data that needs to be written on the file
     */
    private static void createAndWriteToFile(File file,String writeData) {
        try {
            // Create a new file
            file.createNewFile();

            // Create a FileWriter
            FileWriter writer = new FileWriter(file);

            // Write the desired contents to the file
            writer.write(writeData);
            writer.write("\n");;

            // Close the FileWriter
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Helper method to read the contents of a text file into a string

    /**
     * Method used to read the content of a txt file and convert it into a string
     *
     * @param filePath is the file path to read the file from
     * @return string representation of the data saved on txt file
     * @throws IOException
     */
    private static String readTextFile(String filePath) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        }
        return sb.toString();
    }
}
