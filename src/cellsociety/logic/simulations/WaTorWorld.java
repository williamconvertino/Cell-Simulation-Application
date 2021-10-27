package cellsociety.logic.simulations;

import cellsociety.errors.MissingSimulationArgumentError;

import cellsociety.logic.grid.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class WaTorWorld extends Simulation {

    private int energy;
    private int reproductionTime;

    public WaTorWorld(int[][] grid, Map<String, String> metadata) throws MissingSimulationArgumentError {
        super(grid, metadata);

        // setting the cells with '1' to a WaTorCell w/ a Fish object and the cells with '2' to a WaTorCell w/ a Shark object
        for (int r = 0; r < getGrid().getHeight(); r++) {
            for (int c = 0; c < getGrid().getWidth(); c++) {
                if (getGrid().getCell(r,c).getState() == 1) { // if the cell's state is a 1 (meaning it's a fish)
                    getGrid().setCell(r, c, new WaTorCell(r,c,getGrid().getCellState(r,c), new Fish()));
                }
                else if (getGrid().getCell(r,c).getState() == 2) { // if the cell's state is a 2 (meaning it's a shark)
                    getGrid().setCell(r, c, new WaTorCell(r,c,getGrid().getCellState(r,c), new Shark()));
                }
            }
        }

        energy = Integer.parseInt(metadata.get("Energy"));
        reproductionTime = Integer.parseInt(metadata.get("ReproductionTime"));
    }

    @Override
    protected void updateNextGridFromCell(Cell cell) {
        if (cell.getState() == 0) { // if the cell is just water, do nothing
            return;
        }
        else if (cell.getState() == 1) { // if the cell is a fish
            List<Cell> neighbors = currentGrid.getNeighbors_Four(cell);
            neighbors.removeIf(e->e.getState() == 1 || e.getState() == 2); // find only the empty water around the fish
            if (neighbors.size() > 0) { // if there is a (water) spot for the fish to move
                // first, figure out where to move the fish (random spot from the adjacent water spots)
                Collections.shuffle(neighbors);

                // move the fish to the spot identified and put it in the nextGrid variable
                nextGrid.setCell(neighbors.get(0).getRow(), neighbors.get(0).getColumn(), ((WaTorCell) cell));
            }
        }
        else if (cell.getState() == 2) { // if the cell is a shark
            List<Cell> neighbors = currentGrid.getNeighbors_Four(cell);
        }

        Animal oldCell = ((WaTorCell) cell).getAnimal();
        oldCell.setTimeSurvived(oldCell.getTimeSurvived() + 1); // increase the time survived for the animal by 1
    }


}
