package cellsociety.logic;

//import cellsociety.io.CSVFileReader;

import cellsociety.io.CSVFileReader;
import cellsociety.io.SIMFileReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.util.HashMap;
import java.util.Properties;

/**
 * The base Logic class for the individual games
 *
 * @author Alexis Cruz
 */
public abstract class Logic {
    private Grid grid;
    // a hashmap containing the data collected from sim files
    private HashMap<String, String> metadata;

    public Logic(int width, int height) {
        grid = new Grid(width, height);
        metadata = new HashMap<>();
    }


    /**
     * initializes the game using a specified CSV file
     *
     * @param file the string of the CSV file to be used
     * @return returns true if the CSV file was read successfully, false other wise
     */
    public boolean initializeWithCSVFile(String file) {
        grid = CSVFileReader.readFile(file);
        return grid != null;
    }

    /**
     * initializes the game using a specified Sim file
     * and sets the parameters to the metadata map
     *
     * @param file the string of the Sim file to be used
     * @return returns true if the Sim file was read successfully, false otherwise
     */
    public boolean initializeWithSimFile(String file) {
        metadata = SIMFileReader.getMetadataFromFile(file);
        return metadata != null;
    }


    /**
     * @return the grid held by the logic
     */
    public Grid getGrid() {
        return grid;
    }

    /**
     * @return the metadata of the Logic
     */
    public HashMap getMetaData() {
        return metadata;
    }

    /**
     * the update function to be run every tick of the game
     */
    public abstract void update();

}
