package cellsociety.logic.grid;

import cellsociety.logic.neighborhoodpatterns.NeighborhoodPattern;
import cellsociety.logic.shapes.ShapeManager;

import java.util.LinkedList;
import java.util.List;

public class ToroidalGrid extends Grid{



    /**
     * Constructs a new grid with a specified array of states
     *
     * @param states
     * @param shapeManager
     */
    public ToroidalGrid(int[][] states, ShapeManager shapeManager) {
        super(states, shapeManager);
    }

    @Override
    public List<Cell> getNeighbors(Cell cell, NeighborhoodPattern myPattern) {
        List<Coordinate> potentialNeighbors = generateNeighborCoordinates(cell, myPattern);
        List<Cell> myNeighbors = new LinkedList<>();
        for (Coordinate coord: potentialNeighbors) {
            if(coord.r() < 0 || coord.r() > getHeight() || coord.c() < 0 || coord.c() > getWidth()){
                myNeighbors.add(getCell(coord.r()%getWidth(), coord.c()%getHeight()));
            }else{
                myNeighbors.add(getCell(coord.r(), coord.c()));
            }
        }
        return myNeighbors;
    }
}
