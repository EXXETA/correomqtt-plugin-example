package com.exxeta.correomqtt.plugin.example;

import com.exxeta.correomqtt.plugin.model.MessageExtensionDTO;
import com.exxeta.correomqtt.plugin.spi.PublishMenuHook;
import com.exxeta.correomqtt.plugin.spi.PublishMessageHook;
import javafx.scene.layout.HBox;
import org.jdom2.Element;
import org.pf4j.Extension;
import org.pf4j.Plugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Extension
public class ExampleExtension implements PublishMenuHook, PublishMessageHook {

    private Logger LOGGER = LoggerFactory.getLogger(ExampleExtension.class);

    private ExamplePlugin examplePlugin;

    public ExampleExtension(Plugin plugin) {
        this.examplePlugin = (ExamplePlugin) plugin;
    }

    @Override
    public void onConfigReceived(Element config) {
        LOGGER.info("Config received. Color is: {}", config.getChildText("color"));
    }

    @Override
    public void onInstantiatePublishMenu(String connectionId, HBox hBox) {
        ExampleController controller = new ExampleController();
        ExamplePlugin.loadFXML("/pluginSettings.fxml", controller);
        controller.addItems(hBox);
        examplePlugin.putExampleController(connectionId, controller);
    }

    @Override
    public MessageExtensionDTO onPublishMessage(String connectionId, MessageExtensionDTO messageExtensionDTO) {
        ExampleController controller = examplePlugin.getExampleController(connectionId);
        if (controller.isLogEnabled()) {
            LOGGER.info("Message sent, payload is: {}", messageExtensionDTO.getPayload());
        }
        return messageExtensionDTO;
    }
}
