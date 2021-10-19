package cellsociety.display;

import cellsociety.errors.UnhandledExceptionError;
import cellsociety.io.FilePickerEventHandler;
import java.io.File;
import java.lang.reflect.Method;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.Map;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.w3c.dom.css.Rect;


public class Display {

    public static Map<Integer, Color> COLOR_MAP = new HashMap();
    static {
        COLOR_MAP.put(0, Color.WHITE);
        COLOR_MAP.put(1, Color.BLUE);
        COLOR_MAP.put(2, Color.RED);
    }
    public final static int LEFT_OFFSET_GRID = 100;
    public final static int TOP_OFFSET_GRID = 50;
    public final static double CELL_LENGTH = 29;
    public final static double CELL_OFFSET = 1.5;
    private Stage myStage;
    private Rectangle[][] displayGrid;

    private Group root;

    /**
     * Create display based on given background color and Grid Cell length.
     */
    public Display (Stage myStage, Color background) {
        this.myStage = myStage;
        root = (Group)myStage.getScene().getRoot();
        myStage.getScene().setFill(background);

    }

    public void initializeGrid(int[][] grid) {
        resetGrid();
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return;
        }
        displayGrid = new Rectangle[grid.length][grid[0].length];

        for(int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                Rectangle cell = new Rectangle(x*(CELL_LENGTH + CELL_OFFSET) + LEFT_OFFSET_GRID,
                    y*(CELL_LENGTH + CELL_OFFSET) + TOP_OFFSET_GRID , CELL_LENGTH, CELL_LENGTH);
                displayGrid[x][y] = cell;
                root.getChildren().add(cell);
            }
        }
        updateScene(grid);
    }

    //Removes all elements of the displayGrid from the display.
    private void resetGrid() {
        if (displayGrid != null) {
            for (int i = 0; i < displayGrid.length; i++) {
                for (int j = 0; j < displayGrid[0].length; j++) {
                    root.getChildren().remove(displayGrid[i][j]);
                }
            }
        }
    }

    /**
     * Update Scene
     */
    public void updateScene (int[][] grid) {
        if (displayGrid == null || grid.length != displayGrid.length) {
            initializeGrid(grid);
            return;
        }
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid.length; j++){
                displayGrid[i][j].setFill(COLOR_MAP.get(grid[i][j]));
            }
        }
    }

    //Adds a new button to the screen with the passed method as its event.
    private Button addButton(Method myMethod, Object instance) {
        Button myButton = new Button();
        myButton.setOnAction(e -> {try {myMethod.invoke(instance);} catch (Exception exception) {}});
        root.getChildren().add(myButton);
        return myButton;
    }

    public void addFileChoser(Method loadFile, Object instance) {

        Button fileChooserButton = addButton(loadFile, instance);
        fileChooserButton.setOnAction(e-> {
            try {
                FileChooser myFileChoser = new FileChooser();
                myFileChoser.setInitialDirectory(
                    new File(Paths.get(".").toAbsolutePath().normalize().toString() + "/data"));
                loadFile.invoke(instance, myFileChoser.showOpenDialog(myStage));
            } catch (Exception exception) {}
        } );

        fileChooserButton.setLayoutX(0);
        fileChooserButton.setLayoutY(0);
        fileChooserButton.setText("Choose File"); //TODO: Format button and fix language
        root.getChildren().add(fileChooserButton);
    }


}
