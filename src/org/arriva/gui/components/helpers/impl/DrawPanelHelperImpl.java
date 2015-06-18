package org.arriva.gui.components.helpers.impl;


import org.arriva.core.CellParams;
import org.arriva.core.Galaxy;
import org.arriva.gui.components.helpers.DrawPanelHelper;
import org.arriva.gui.components.helpers.GridParams;

import java.awt.*;
import java.awt.geom.Line2D;

public class DrawPanelHelperImpl implements DrawPanelHelper {

    @Override
    public void drawGalaxy(GridParams gridParams) {
        java.util.List<CellParams> aliveCells = gridParams.getGalaxy().getAliveCells();

        for (CellParams cell : aliveCells) {
            //gridParams.getGraphics().fillRect();
        }
    }

    @Override
    public void drawCell(GridParams gridParams) {
        drawHorizontalLines(gridParams);
        drawVerticalLines(gridParams);
    }

    private void drawHorizontalLines(GridParams gridParams) {
        Galaxy galaxy = gridParams.getGalaxy();
        Stroke stroke = new BasicStroke(gridParams.getThickness());
        Graphics2D g2 = (Graphics2D)gridParams.getGraphics();
        int canvasHeight = gridParams.getCanvasHeight() - 2 * gridParams.getIndent();

        int cellHeight = canvasHeight / galaxy.getHeight();
        for (int i = 0; i < galaxy.getHeight() + 1; i++) {
            int yCoord = (cellHeight * i) + gridParams.getIndent();
            Line2D line = new Line2D.Double(gridParams.getIndent(), yCoord, gridParams.getCanvasWidth() - gridParams.getIndent(), yCoord);
            g2.setColor(gridParams.getGridColor());
            g2.setStroke(stroke);
            g2.draw(line);
        }
    }

    private void drawVerticalLines(GridParams gridParams) {
        Galaxy galaxy = gridParams.getGalaxy();
        Stroke stroke = new BasicStroke(gridParams.getThickness());
        Graphics2D g2 = (Graphics2D)gridParams.getGraphics();
        int canvasWidth = gridParams.getCanvasWidth() - 2 * gridParams.getIndent();

        int cellWidth = canvasWidth / galaxy.getWidth();
        for (int i = 0; i < galaxy.getHeight() + 1; i++) {
            int xCoord = (cellWidth * i) + gridParams.getIndent();
            Line2D line = new Line2D.Double(xCoord, gridParams.getIndent(), xCoord, gridParams.getCanvasHeight()- gridParams.getIndent());
            g2.setColor(gridParams.getGridColor());
            g2.setStroke(stroke);
            g2.draw(line);
        }
    }

}
