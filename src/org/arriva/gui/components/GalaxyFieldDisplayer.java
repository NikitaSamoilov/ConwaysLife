package org.arriva.gui.components;

import org.arriva.core.Galaxy;

import java.awt.*;

public interface GalaxyFieldDisplayer {
    Galaxy getGalaxy();
    Component getComponent();
    void update();
}
