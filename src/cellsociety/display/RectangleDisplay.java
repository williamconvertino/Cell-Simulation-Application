package cellsociety.display;

import cellsociety.logic.grid.Cell;
import cellsociety.logic.grid.Coordinate;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RectangleDisplay extends Display{
    Map<Coordinate, Rectangle> cellMap = new HashMap<>();

    public RectangleDisplay(Stage stage, Color background){
        super(stage, background);
    }

    public void initializeGrid(List<Cell> cells){
        if(cells.size() == 0) return;

        for(int i = 0; i < cells.size(); i++){
            Rectangle cell = new Rectangle(cells.get(i).getCoordinates().r() * (cellLength + cellOffset) + gridLeftOffset,
                    cells.get(i).getCoordinates().c() * (cellOffset + cellLength) + gridTopOffset, cellLength, cellLength);

            cellMap.put(cells.get(i).getCoordinates(), cell);
        }



    }


}
