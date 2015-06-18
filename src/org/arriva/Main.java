package org.arriva;

import org.arriva.core.Galaxy;
import org.arriva.gui.GuiWindow;
import org.arriva.gui.GuiWindowParams;
import org.arriva.gui.GuiWindowType;

public class Main {

    public static final int GALAXY_WIDTH = 11;
    public static final int GALAXY_HEIGHT= 11;


    public static void main(String[] args) {
        Galaxy galaxy = new Galaxy(GALAXY_WIDTH, GALAXY_HEIGHT);
        GuiWindowParams params = new GuiWindowParams(galaxy, 400, 300);
        GuiWindow window = GuiWindow.getWindow(GuiWindowType.SIMPLE, params);
        window.setVisible(true);
    }



}
