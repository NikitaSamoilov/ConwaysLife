package org.arriva;

public class Main {

    public static final int GALAXY_WIDTH = 11;
    public static final int GALAXY_HEIGHT= 11;


    public static void main(String[] args) {
	    int[][] galaxy = new int[GALAXY_HEIGHT][GALAXY_WIDTH];
        buildLineConfiguration(galaxy);
        draw(galaxy);

        for (int i = 0; i < 10; i++)
        {
            BuildNewGeneration(galaxy);
            draw(galaxy);
        }

    }

    private static void buildLineConfiguration(int[][] galaxy) {
        clearGalaxy(galaxy);
        int centerRow = (galaxy.length / 2) - 1;
        int centerCol = (galaxy[centerRow].length / 2) - 1;

        galaxy[centerRow][centerCol] = LIFE;
        galaxy[centerRow - 1][centerCol] = LIFE;
        galaxy[centerRow + 1][centerCol] = LIFE;
    }

    private static void buildCrossConfiguration(int[][] galaxy) {
        clearGalaxy(galaxy);
        for (int i = 0; i < galaxy.length; i++) {
            for (int j = 0; j < galaxy[i].length; j++) {
                if (i==j) {
                    galaxy[i][j] = LIFE;
                }
            }
        }

        for (int i = 0; i < galaxy.length; i++) {
            for (int j = 0; j < galaxy[i].length; j++) {
                if (i == (galaxy[i].length - j - 1)) {
                    galaxy[i][j] = LIFE;
                }
            }
        }
    }


    private static void BuildNewGeneration(int[][] galaxy) {
        for (int i = 0; i < galaxy.length; i++) {
            for (int j = 0; j < galaxy[i].length; j++) {
                if (galaxy[i][j] == EMPTY) {
                    if (ProcessEmptyCell(galaxy, i, j)) {
                        galaxy[i][j] = NEW_BORN;
                    }
                }
            }
        }

        for (int i = 0; i < galaxy.length; i++) {
            for (int j = 0; j < galaxy[i].length; j++) {
                if (galaxy[i][j] == LIFE) {
                    if (ProcessLifeCell(galaxy, i, j)) {
                        galaxy[i][j] = OLD;
                    }
                }
            }
        }

        for (int i = 0; i < galaxy.length; i++) {
            for (int j = 0; j < galaxy[i].length; j++) {
                if (galaxy[i][j] == NEW_BORN) {
                    galaxy[i][j] = LIFE;
                }
            }
        }
    }


    private static boolean ProcessLifeCell(int[][] galaxy, int i, int j) {
        int neighboursCount = 0;
        if (i > 0) {
            if (j > 0) {
                neighboursCount += galaxy[i -1][j-1];
            }
            neighboursCount += galaxy[i-1][j];
            if (j < (galaxy[i-1].length -1)) {
                neighboursCount += galaxy[i-1][j+1];
            }
        }

        if (j > 0) {
            neighboursCount += galaxy[i][j-1];
        }

        if (j < (galaxy[i].length -1)) {
            neighboursCount += galaxy[i][j+1];
        }

        if ((neighboursCount <= 3) && (neighboursCount >= 2)) {
            return false;
        }

        if (i < (galaxy.length - 1)) {
            if (j > 0) {
                neighboursCount += galaxy[i+1][j-1];
            }
            neighboursCount += galaxy[i+1][j];
            if (j < (galaxy[i+1].length -1)) {
                neighboursCount += galaxy[i+1][j+1];
            }
        }

        return (neighboursCount > 3) || (neighboursCount < 2);
    }


    private static boolean ProcessEmptyCell(int[][] galaxy, int i, int j) {
        int neighboursCount = 0;
        if (i > 0) {
            if (j > 0) {
              neighboursCount += galaxy[i -1][j-1];
            }
            neighboursCount += galaxy[i-1][j];
            if (j < (galaxy[i-1].length -1)) {
                neighboursCount += galaxy[i-1][j+1];
            }
        }

        if (j > 0) {
            neighboursCount += galaxy[i][j-1];
        }

        if (j < (galaxy[i].length -1)) {
            neighboursCount += galaxy[i][j+1];
        }

        if (neighboursCount > 3) {
            return false;
        }

        if (i < (galaxy.length - 1)) {
            if (j > 0) {
                neighboursCount += galaxy[i+1][j-1];
            }
            neighboursCount += galaxy[i+1][j];
            if (j < (galaxy[i+1].length -1 )) {
                neighboursCount += galaxy[i+1][j+1];
            }
        }

        return neighboursCount == 3;
    }

}
