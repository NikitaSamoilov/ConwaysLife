package org.arriva.gui.components.helpers.impl;


import org.arriva.core.Galaxy;
import org.arriva.gui.components.helpers.DrawPanelHelper;
import org.arriva.gui.components.helpers.GridParams;

import java.awt.*;
import java.awt.geom.Line2D;

public class DrawPanelHelperImpl implements DrawPanelHelper {


    @Override
    public void DrawCell(GridParams gridParams) {
        Graphics2D g2 = (Graphics2D)gridParams.getGraphics();
        Stroke stroke = new BasicStroke(gridParams.getThickness());

        Galaxy galaxy = gridParams.getGalaxy();
        for (int i = 0; i < galaxy.getHeight(); i++) {
            int top = (10 * i);
            Line2D line = new Line2D.Double(0, top, gridParams.getCanvasWidth(), top);
            g2.setColor(gridParams.getGridColor());
            g2.setStroke(stroke);
            g2.draw(line);
        }
    }

    @Override
    public void DrawGalaxy(Galaxy galaxy) {
        //TODO: implement it!
    }
}
