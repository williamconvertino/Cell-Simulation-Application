package cellsociety.display;

import cellsociety.controller.Controller;
import cellsociety.controller.LogicController;
import java.io.File;
import java.nio.file.Paths;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ButtonManager {

  /**
   * Initializes all the buttons for the controller.
   *
   * This class is a bit ugly, hopefully we will find the time to replace it.
   */
  public static void initializeButtons(Display myDisplay, LogicController myLogicController, Controller myController, Stage myStage) {
    Button saveButton = new Button();
    saveButton.setText("Save");
    saveButton.setOnAction(e -> myController.saveCurrentGrid());
    Button playButton = new Button();
    playButton.setText("Play");
    playButton.setOnAction(e -> myLogicController.playSimulation());
    Button pauseButton = new Button();
    pauseButton.setText("Pause");
    pauseButton.setOnAction(e -> myLogicController.pauseSimulation());
    Button resetButton = new Button();
    resetButton.setText("Reset");
    resetButton.setOnAction(e -> myDisplay.resetGrid());
    Button loadButton = new Button();
    loadButton.setText("Load");

    loadButton.setOnAction(e -> {
      try {
        FileChooser myFileChoser = new FileChooser();
        myFileChoser.setInitialDirectory(
            new File(Paths.get(".").toAbsolutePath().normalize() + "/data"));
        myController.loadFile(myFileChoser.showOpenDialog(myStage));
      } catch (Exception exception) {
      }
    });

//    myStage.getScene().setOnMouseClicked(mouseEvent -> {
//      try {
//      if (myLogicController.getActiveGrid()!=null) {
//        int[] s = myDisplay.changeCell(mouseEvent.getX(), mouseEvent.getY(), myLogicController.getActiveGrid());
//        //myLogicController.getCurrentSimulation().getGrid().changeCell(new Coordinate(s[0], s[1]), myLogicController.getSimulationDefaultValue());
//      }} catch (Exception e) {}
//    });

    Slider speedSlider = new Slider(1.0, 4.0, 1.0);
    speedSlider.setMajorTickUnit(1);
    speedSlider.setMinorTickCount(0);
    speedSlider.snapToTicksProperty().set(true);
    speedSlider.showTickLabelsProperty().set(true);
    speedSlider.valueProperty()
        .addListener(e -> myLogicController.setSpeed((int) speedSlider.getValue()));
    speedSlider.setShowTickLabels(true);
    myDisplay.addButtons(loadButton, saveButton, playButton, pauseButton, resetButton, speedSlider);
  }
}
