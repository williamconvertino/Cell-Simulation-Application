package cellsociety.io;

import cellsociety.logic.Grid;
import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    /**
     * saves a grid configuration to a CSV file based on a file name that is passed in to this method
     * @param grid the current grid configuration to be saved
     * @param fileName the name of the file to be saved
     */
    public static void saveFile(Grid grid, String fileName) {
        List<String[]> csvData = createCsvData(grid);


        // default separator is a comma
        try (FileWriter outputfile = new FileWriter(fileName);
             CSVWriter writer = new CSVWriter(outputfile, ',',
                     CSVWriter.NO_QUOTE_CHARACTER,
                     CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                     CSVWriter.DEFAULT_LINE_END)) {
            writer.writeAll(csvData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * creates CSV data based on the grid that will be saved
     * @param grid the grid configuration to be saved
     * @return a list of string arrays where each string array will be a row in the CSV file
     */
    private static List<String[]> createCsvData(Grid grid) {
        List<String[]> list = new ArrayList<>();
        String[] dimensions = {String.valueOf(grid.getWidth()), String.valueOf(grid.getHeight())};
        list.add(dimensions);

        String[] eachRow = new String[grid.getWidth()];
        for (int i = 0; i < grid.getHeight(); i++) {
            for (int j = 0; j < grid.getWidth(); j++) {
                eachRow[j] = String.valueOf(grid.getCell(i, j));
            }
            list.add(eachRow);
            eachRow = new String[grid.getWidth()];
        }
        return list;
    }
}
