package org.correomqtt.plugin.example;

import org.correomqtt.plugin.example.menu.MenuExampleController;
import javafx.fxml.FXMLLoader;
import org.pf4j.Plugin;
import org.pf4j.PluginRuntimeException;
import org.pf4j.PluginWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;

public class ExamplePlugin extends Plugin {

    private Logger LOGGER = LoggerFactory.getLogger(ExamplePlugin.class);

    private final HashMap<String, MenuExampleController> exampleControllers;

    public ExamplePlugin(PluginWrapper wrapper) {
        super(wrapper);
        exampleControllers = new HashMap<>();
    }

    @Override
    public void start() {
        super.start();
        LOGGER.info("Hello CorreoMQTT!");
    }

    @Override
    public void stop() {
        super.stop();
        LOGGER.info("Good bye.");
    }

    public MenuExampleController getExampleController(String connectionId) {
        return exampleControllers.get(connectionId);
    }

    public void putExampleController(String connectionId, MenuExampleController controller) {
        exampleControllers.put(connectionId, controller);
    }

    public static void loadFXML(String resourceName, Object controller) {
        FXMLLoader loader = new FXMLLoader(controller.getClass().getResource(resourceName));
        loader.setController(controller);
        try {
            loader.load();
        } catch (IOException e) {
            throw new PluginRuntimeException("Failed to load layout file");
        }
    }
}
