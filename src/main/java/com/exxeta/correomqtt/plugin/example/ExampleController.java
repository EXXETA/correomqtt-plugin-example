package com.exxeta.correomqtt.plugin.example;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;
import lombok.Setter;

public class ExampleController {

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

    public void onStop() {
        if (pluginBox != null) {
            pluginBox.getChildren().remove(exampleLogCheckBox);
        }
    }
}
