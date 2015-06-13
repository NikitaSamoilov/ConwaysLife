package org.arriva.gui.components;

import org.arriva.core.Galaxy;

import javax.swing.*;
import java.awt.*;

public class GalaxyTextArea extends JTextArea implements GalaxyFieldDisplayer {

    private Galaxy galaxy;

    public void setGalaxy(Galaxy galaxy) {
        this.galaxy = galaxy;
    }

    public Galaxy getGalaxy() {
        return galaxy;
    }

    @Override
    public Component getComponent() {
        return this;
    }

    @Override
    public void update() {
        int[][] field = galaxy.getGalaxyField();

        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == Galaxy.LIFE) {
                    strBuilder.append("*");
                } else {
                    strBuilder.append(" ");
                }
            }
            strBuilder.append("\n");
        }

        setText(strBuilder.toString());
    }
}
