package org.arriva.gui;


import org.arriva.core.Galaxy;

public class GuiWindowParams {
    private int width = 400;
    private int height = 300;
    private Galaxy galaxy;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Galaxy getGalaxy() {
        return galaxy;
    }

    public void setGalaxy(Galaxy galaxy) {
        this.galaxy = galaxy;
    }

    public GuiWindowParams() {
        //
    }

    public GuiWindowParams(Galaxy galaxy) {
        setGalaxy(galaxy);
    }

    public GuiWindowParams(Galaxy galaxy, int width, int height) {
        setGalaxy(galaxy);
        setWidth(width);
        setHeight(height);
    }
 }
