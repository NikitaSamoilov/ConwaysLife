package org.arriva.gui;

import org.arriva.core.Galaxy;

import javax.swing.*;

public abstract class GuiWindow extends JFrame {

    protected Galaxy galaxy;

    protected GuiWindow(int width, int height, Galaxy galaxy) {
        this.galaxy = galaxy;
        initMainWindow(width, height);
        buildAndAttachElements();
    }

    public static GuiWindow getWindow(GuiWindowType type,int width, int height, Galaxy galaxy) {
        switch (type) {
            case SIMPLE:
                return new SimpleGuiWindow(width, height, galaxy);
            default:
                return null;
        }
    }

    protected void initMainWindow(int width, int height) {
        setSize(width, height);
        getContentPane().setLayout(null);
    }

    protected abstract void buildAndAttachElements();
}
