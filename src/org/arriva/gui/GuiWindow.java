package org.arriva.gui;

import org.arriva.core.Galaxy;

import javax.swing.*;

public abstract class GuiWindow extends JFrame {

    protected Galaxy galaxy;

    protected GuiWindow(GuiWindowParams params) {
        this.galaxy = params.getGalaxy();
        initMainWindow(params.getWidth(), params.getHeight());
        buildAndAttachElements();
    }

    public static GuiWindow getWindow(GuiWindowType type,GuiWindowParams params) {
        switch (type) {
            case SIMPLE:
                return new SimpleGuiWindow(params);
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
