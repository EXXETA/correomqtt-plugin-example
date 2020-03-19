package org.correomqtt.plugin.example.io;

import org.correomqtt.plugin.example.ExamplePlugin;
import org.correomqtt.plugin.example.menu.MenuExampleController;
import org.correomqtt.plugin.model.MessageExtensionDTO;
import org.correomqtt.plugin.spi.PublishMessageHook;
import org.pf4j.Extension;
import org.pf4j.Plugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Extension
public class PublishMessageExtension implements PublishMessageHook {

    private Logger LOGGER = LoggerFactory.getLogger(PublishMessageExtension.class);

    private ExamplePlugin examplePlugin;

    public PublishMessageExtension(Plugin plugin) {
        this.examplePlugin = (ExamplePlugin) plugin;
    }

    @Override
    public MessageExtensionDTO onPublishMessage(String connectionId, MessageExtensionDTO messageExtensionDTO) {
        MenuExampleController controller = examplePlugin.getExampleController(connectionId);
        if (controller.isLogEnabled()) {
            LOGGER.info("Message sent, payload is: {}", messageExtensionDTO.getPayload());
        }
        return messageExtensionDTO;
    }
}
