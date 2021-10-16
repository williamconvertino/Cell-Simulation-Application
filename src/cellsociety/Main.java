package cellsociety;


import cellsociety.display.Display;
import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Feel free to completely change this code or delete it entirely. 
 */
public class Main extends Application{
    @Override
    public void start(Stage stage) {
        Display display = new Display(Color.BLACK, 15);
        stage.setScene(display.getScene());
        stage.show();
    }

    /**
     * A method to test (and a joke :).
     */
    public double getVersion () {
        return 0.001;
    }

    /**
     * Start of the program.
     */
    public static void main (String[] args) {
        launch(args);
        System.out.println("Hello world");
    }
}
