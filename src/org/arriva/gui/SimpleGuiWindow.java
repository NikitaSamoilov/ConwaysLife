package org.arriva.gui;

import org.arriva.core.Galaxy;
import org.arriva.gui.components.GalaxyFieldDisplayer;
import org.arriva.gui.components.GalaxyTextArea;
import org.arriva.gui.listeners.NextButtonListener;

import javax.swing.*;

public class SimpleGuiWindow extends GuiWindow {

    private JButton nextButton;
    private GalaxyFieldDisplayer fieldDisplayer;

    public SimpleGuiWindow(GuiWindowParams params) {
        super(params);
    }

    @Override
    protected void buildAndAttachElements() {
        nextButton = buildNextButton();
        add(nextButton);

        fieldDisplayer = buildFieldDisplayer();
        add(fieldDisplayer.getComponent());
        fieldDisplayer.update();

        nextButton.addActionListener(new NextButtonListener(fieldDisplayer));
    }

    protected JButton buildNextButton() {
        JButton button = new JButton("Next");
        button.setBounds(10, 10, 80, 30);
        return button;
    }

    protected GalaxyFieldDisplayer buildFieldDisplayer() {
        GalaxyTextArea textArea = new GalaxyTextArea();
        textArea.setGalaxy(galaxy);
        textArea.setRows(galaxy.getHeight());
        textArea.setColumns(galaxy.getWidth());
        textArea.setBounds(10, 50, 200, 200);
        return textArea;
    }
}
