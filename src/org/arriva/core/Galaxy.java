package org.arriva.core;


import java.util.List;

public class Galaxy {

    public static final int EMPTY = 0;
    public static final int LIFE = 1;
    public static final int NEW_BORN = 2;
    public static final int OLD = 3;

    private int[][] galaxyField;
    private GalaxyHelper galaxyHelper = new GalaxyHelper();

    protected int width;
    protected int height;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int[][] getGalaxyField() {
        return galaxyField;
    }

    public Galaxy(int width, int height) {
        this.width = width;
        this.height = height;
        initializeGalaxy();
    }

    public void buildNextGeneration() {
        for (int i = 0; i < galaxyField.length; i++) {
            for (int j = 0; j < galaxyField[i].length; j++) {
                processNextGenCell(i, j);
            }
        }

        for (int i = 0; i < galaxyField.length; i++) {
            for (int j = 0; j < galaxyField[i].length; j++) {
                processClearing(i, j);
            }
        }
    }

    protected void processClearing(int row, int col) {
        switch (galaxyField[row][col]) {
            case NEW_BORN:
                galaxyField[row][col] = LIFE;
                break;
            case OLD:
                galaxyField[row][col] = EMPTY;
                break;
            default:
                break;
        }
    }

    protected void processNextGenCell(int row, int col) {
        int neighboursCount = galaxyHelper.getNeighboursCount(this, new CellParams(row, col));
        switch (galaxyField[row][col]) {
            case EMPTY:
                if (neighboursCount == 3) {
                    galaxyField[row][col] = NEW_BORN;
                }
                break;
            case LIFE:
                if ((neighboursCount < 2) || (neighboursCount > 3)) {
                    galaxyField[row][col] = OLD;
                }
                break;
               default:
                   break;
        }
    }

    public List<CellParams> getAliveCells() {
        return galaxyHelper.getAliveCells(this);
    }

    protected void initializeGalaxy() {
        galaxyField = new int[height][width];
        galaxyHelper.clearGalaxy(this);
        galaxyField[3][3] = LIFE;
        galaxyField[3][4] = LIFE;
        galaxyField[3][5] = LIFE;
    }
}
