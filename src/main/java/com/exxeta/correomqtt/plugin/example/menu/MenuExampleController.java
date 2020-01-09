package com.exxeta.correomqtt.plugin.example.menu;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;
import lombok.Setter;

public class MenuExampleController {

    @Setter
    private HBox pluginBox;

    @FXML
    private CheckBox exampleLogCheckBox;

    public void addItems(HBox hBox) {
        this.pluginBox = hBox;
        pluginBox.getChildren().add(exampleLogCheckBox);
    }

    public boolean isLogEnabled() {
        return exampleLogCheckBox.isSelected();
    }
}
