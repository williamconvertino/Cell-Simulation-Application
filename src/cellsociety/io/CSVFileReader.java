package cellsociety.io;

import cellsociety.errors.FileNotFoundError;
import cellsociety.errors.UnhandledExceptionError;
import cellsociety.logic.grid.Grid;
import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;


/**
 * A class to read CVS files.
 *
 *
 */
public class CSVFileReader {

  public static Grid readFile(String fileName) throws FileNotFoundError, UnhandledExceptionError { //TODO: Refactor this
    try{
      // Create an object of filereader
      // class with CSV file as a parameter.
      FileReader filereader = new FileReader(fileName);

      // create csvReader object passing
      // file reader as a parameter
      CSVReader csvReader = new CSVReader(filereader);
      int i = 0, j = 0;

      String[] nextRecord;
      nextRecord = csvReader.readNext();
      //make a dimensions array to just read the width and height first
      int[] dimensions = new int[2];
      for (String cell : nextRecord) {
        dimensions[i] = Integer.parseInt(cell); i++;
      }
      //set i =0 because we'll be using it to iterate
      i = 0;
      //dimensions[0] is width and dimensions[1] is height
      Grid grid = new Grid(dimensions[0], dimensions[1]);
      while ((nextRecord = csvReader.readNext()) != null) {
        for (String cell : nextRecord) {
          grid.setCell(i% grid.getWidth(), j% grid.getHeight(), Integer.parseInt(cell));
          j++;
        }
        i++;
      }
      grid.updateGrid();
      return grid;
    } catch (FileNotFoundException e){
      throw new FileNotFoundError(fileName);
    } catch (Exception e) {
      throw new UnhandledExceptionError();
    }

  }

}
