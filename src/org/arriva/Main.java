package org.arriva;

import org.arriva.core.Galaxy;
import org.arriva.gui.GuiWindow;
import org.arriva.gui.GuiWindowType;

public class Main {

    public static final int GALAXY_WIDTH = 11;
    public static final int GALAXY_HEIGHT= 11;


    public static void main(String[] args) {
        Galaxy galaxy = new Galaxy(GALAXY_WIDTH, GALAXY_HEIGHT);
        GuiWindow window = GuiWindow.getWindow(GuiWindowType.SIMPLE, 400, 300, galaxy);
        window.setVisible(true);
    }



}
