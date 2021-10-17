package cellsociety.controller;

import cellsociety.io.SIMFileReader;
import cellsociety.logic.GameOfLife;
import cellsociety.logic.Grid;
import cellsociety.logic.Logic;
import java.awt.Dimension;
import java.util.Map;
import org.apache.commons.logging.Log;

/**
 * Controls the Logic portion of Cell Society, allowing the different
 * algorithms to be loaded, unloaded, and updated. Also communicates
 * the current grid state of the loaded algorithm.
 *
 * @author William Convertino
 * @since 0.0.1
 */
public class LogicController {


  //The current algorithm with which the grid should be updated.
  private Logic currentAlgorithm;

  //The current program grid to display to the user.
  private Grid gridToDisplay;

  /**
   * Constructs a new LogicController.
   *
   */
  public LogicController () {

  }

  /**
   * Initializes a new simulation based on a SIM file input.
   *
   * @param fileName the name of the SIM file with the initialization configuration data.
   * @throws Exception if the file cannot be found or is improperly formatted.
   */
  public void initializeFromFile (String fileName) throws Exception {

    Map<String, String> metadata;
    try {
      metadata = SIMFileReader.getMetadataFromFile(fileName);


    } catch (Exception e) { //TODO: Fix error handling.
      throw e;
    }

  }

  private void loadGameOfLife(Dimension gridSize) {
    this.currentAlgorithm = new GameOfLife(gridSize.width, gridSize.height);
  }

  /**
   * Returns the current grid state of the currently loaded
   * algorithm.
   *
   * @return the grid state of  the currently loaded algorithm.
   */
  public Grid getActiveGrid() {
    return gridToDisplay;
  }


}
