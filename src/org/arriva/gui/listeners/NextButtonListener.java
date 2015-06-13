package org.arriva.gui.listeners;

import org.arriva.gui.components.GalaxyFieldDisplayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NextButtonListener implements ActionListener {

    protected GalaxyFieldDisplayer displayer;

    public NextButtonListener(GalaxyFieldDisplayer displayer) {
        this.displayer = displayer;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        displayer.getGalaxy().buildNextGeneration();
        displayer.update();
    }
}
