package org.arriva;


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

    public int[][] getGalaxyField() {
        return galaxyField;
    }

    public Galaxy(int width, int height) {
        this.width = width;
        this.height = height;
        initializeGalaxy();
    }

    public void buildNextGeneration() {
        List<CellParams> aliveCells = galaxyHelper.getAliveCells(this);


    }

    protected void initializeGalaxy() {
        galaxyField = new int[height][width];
        galaxyHelper.clearGalaxy(this);
    }
}
