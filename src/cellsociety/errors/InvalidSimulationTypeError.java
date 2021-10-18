package cellsociety.errors;

import java.io.FileNotFoundException;

/**
 * Signals that the user attempted to run a non-supported simulation type.
 *
 * @author William Convertino
 */
public class InvalidSimulationType extends Exception {

  //The type of simulation that was given.
  private String type;

  /**
   * Constructs a new InvalidSimulationType with the type of simulation
   * that was attempted.
   *
   * @param type the type of simulation that the user attempted to run.
   */
  public InvalidSimulationType(String type) {
    this.type = type;
  }

  /**
   * Returns the name of the file that the user attempted to open.
   *
   * @return the name of the file that the user attempted to open.
   */
  public String getFilename() {
    return type;
  }

}
