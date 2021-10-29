package cellsociety.logic.neighborhoodpatterns;

import cellsociety.logic.grid.Coordinate;
import cellsociety.logic.shapes.ShapeManager;

import java.util.List;

public class CornerNeighborPattern extends NeighborhoodPattern{

    @Override
    public List<Coordinate> getNeighborhoodGroup(Coordinate myCenter, ShapeManager myShape) {
        List<Coordinate> result = myShape.getAllNeighbors(myCenter);



        return result;
    }
}
