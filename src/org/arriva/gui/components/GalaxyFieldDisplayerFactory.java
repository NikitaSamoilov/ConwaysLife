package org.arriva.gui.components;

public class GalaxyFieldDisplayerFactory {

    public static GalaxyFieldDisplayer getDisplayer(GalaxyFieldDisplayerType type) {
        switch (type) {
            case TextArea:
                return new GalaxyTextArea();
            case DrawPanel:
                return new GalaxyDrawPanel();
            default:
                return null;
        }
    }
}
