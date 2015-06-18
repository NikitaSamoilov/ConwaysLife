package org.arriva.gui.components;

import org.arriva.core.Galaxy;

import java.awt.*;

public interface GalaxyFieldDisplayer {
    Galaxy getGalaxy();
    void setGalaxy(Galaxy galaxy);
    void setBounds(int left, int top, int width, int height);
    Component getComponent();
    void update();
}
