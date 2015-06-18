package org.arriva.gui.components.helpers;

import org.arriva.core.Galaxy;

import java.awt.*;


public class GridParams {
    private int thickness;
    private Galaxy galaxy;
    private Graphics graphics;
    private int canvasWidth;
    private int canvasHeight;
    private Color gridColor;
    private int indent = 0;

    public int getThickness() {
        return thickness;
    }

    public void setThickness(int thickness) {
        this.thickness = thickness;
    }

    public Galaxy getGalaxy() {
        return galaxy;
    }

    public void setGalaxy(Galaxy galaxy) {
        this.galaxy = galaxy;
    }

    public Graphics getGraphics() {
        return graphics;
    }

    public void setGraphics(Graphics graphics) {
        this.graphics = graphics;
    }

    public int getCanvasWidth() {
        return canvasWidth;
    }

    public void setCanvasWidth(int canvasWidth) {
        this.canvasWidth = canvasWidth;
    }

    public int getCanvasHeight() {
        return canvasHeight;
    }

    public void setCanvasHeight(int canvasHeight) {
        this.canvasHeight = canvasHeight;
    }

    public Color getGridColor() {
        return gridColor;
    }

    public void setGridColor(Color gridColor) {
        this.gridColor = gridColor;
    }

    public int getIndent() {
        return indent;
    }

    public void setIndent(int indent) {
        this.indent = indent;
    }


}
