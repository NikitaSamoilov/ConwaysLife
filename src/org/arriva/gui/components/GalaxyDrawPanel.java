package org.arriva.gui.components;

import org.arriva.core.Galaxy;
import org.arriva.gui.components.helpers.DrawPanelHelper;
import org.arriva.gui.components.helpers.GridParams;
import org.arriva.gui.components.helpers.impl.DrawPanelHelperImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class GalaxyDrawPanel extends JPanel implements GalaxyFieldDisplayer {

    private Galaxy galaxy;
    private DrawPanelHelper drawHelper;

    public DrawPanelHelper getDrawHelper() {
        if (drawHelper == null) {
            drawHelper = new DrawPanelHelperImpl();
        }
        return drawHelper;
    }

    public void setDrawHelper(DrawPanelHelper drawHelper) {
        this.drawHelper = drawHelper;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        GridParams gridParams =  new GridParams();
        gridParams.setGalaxy(galaxy);
        gridParams.setGraphics(g);
        gridParams.setCanvasHeight(getHeight());
        gridParams.setCanvasWidth(getWidth());
        gridParams.setGridColor(Color.black);
        gridParams.setThickness(2);
        getDrawHelper().DrawCell(gridParams);
    }

    @Override
    public Galaxy getGalaxy() {
        return galaxy;
    }

    @Override
    public void setGalaxy(Galaxy galaxy) {
        this.galaxy = galaxy;
    }

    @Override
    public Component getComponent() {
        return this;
    }

    @Override
    public void update() {
        repaint();
    }
}
