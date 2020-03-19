package org.correomqtt.plugin.example.menu;

import org.correomqtt.plugin.example.ExamplePlugin;
import org.correomqtt.plugin.spi.PublishMenuHook;
import javafx.scene.layout.HBox;
import org.jdom2.Element;
import org.pf4j.Extension;
import org.pf4j.Plugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Extension
public class MenuExampleExtension implements PublishMenuHook {

    private Logger LOGGER = LoggerFactory.getLogger(MenuExampleExtension.class);

    private ExamplePlugin examplePlugin;

    public MenuExampleExtension(Plugin plugin) {
        this.examplePlugin = (ExamplePlugin) plugin;
    }

    @Override
    public void onConfigReceived(Element config) {
        LOGGER.info("Config received. Color is: {}", config.getChildText("color"));
    }

    @Override
    public void onInstantiatePublishMenu(String connectionId, HBox hBox) {
        MenuExampleController controller = new MenuExampleController();
        ExamplePlugin.loadFXML("/pluginSettings.fxml", controller);
        controller.addItems(hBox);
        examplePlugin.putExampleController(connectionId, controller);
    }
}
