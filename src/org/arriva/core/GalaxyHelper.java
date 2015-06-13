package org.arriva.core;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nikita.samoilov on 09.06.2015.
 */
public class GalaxyHelper {

    public void clearGalaxy(Galaxy galaxy) {
        int[][] galaxyField = getField(galaxy);

        for (int[] row : galaxyField) {
            for (int cell : row) {
                cell = Galaxy.EMPTY;
            }
        }
    }

    public void drawConsole(Galaxy galaxy) {
        int[][] galaxyField = getField(galaxy);
        for (int[] row : galaxyField) {
            for (int cell : row) {
                if (cell == Galaxy.LIFE) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
                //System.out.print(String.format("%d ", cell));
            }
            System.out.println();
        }
        System.out.println();
    }

    public List<CellParams> getAliveCells(Galaxy galaxy) {
        int[][] galaxyField = getField(galaxy);
        List<CellParams> aliveCells = new ArrayList<CellParams>();

        for (int i = 0; i < galaxyField.length; i++) {
            for (int j = 0; j < galaxyField[i].length; j++) {
                if (isAlive(galaxyField[i][j])) {
                    aliveCells.add(new CellParams(i, j));
                }
            }
        }

        return aliveCells;
    }

    public int getNeighboursCount(Galaxy galaxy, CellParams cellParams) {
        List<CellParams> alives = getAliveCells(galaxy);
        if (alives.isEmpty()) {
            return 0;
        }

        int neightboursCount = 0;

        for (CellParams alive : alives) {
            if (areNeighbourCells(alive, cellParams)) {
                neightboursCount += 1;
            }
        }

        return neightboursCount;
    }

    private boolean areNeighbourCells(CellParams firstCell, CellParams secondCell) {
        int deltaRow = Math.abs(firstCell.row - secondCell.row);
        int deltaCol = Math.abs(firstCell.col - secondCell.col);

        if ((deltaRow == deltaCol) && (deltaRow == 0)) {
            return false;
        }

        return (deltaRow <= 1) && (deltaCol <= 1);
    }

    private boolean isAlive(int value) {
        return value == Galaxy.LIFE || value == Galaxy.OLD;
    }

    private int[][] getField(Galaxy galaxy) {
        return galaxy.getGalaxyField();
    }
}
