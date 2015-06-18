package org.arriva.gui.components;

import org.arriva.core.Galaxy;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class GalaxyDrawPanel extends JPanel implements GalaxyFieldDisplayer {

    private Galaxy galaxy;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        Stroke stroke = new BasicStroke(2);

        for (int i = 0; i < galaxy.getHeight(); i++) {
            int top = (10 * i);
            Line2D line = new Line2D.Double(0, top, getWidth(), top);
            g2.setColor(Color.black);
            g2.setStroke(stroke);
            g2.draw(line);
        }
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
