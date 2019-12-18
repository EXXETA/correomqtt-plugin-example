# ExamplePlugin for the CorreoMQTT-Client

This plugin adds a CheckBox to the PublishView and creates a log for each message sent.  
It's main purpose is to simplify plugin creation for new developers
and to demonstrate how CorreoMQTT can be extended using plugins.

## Installation

1. Compile the source code using `mvn clean package`
2. Place the `CorreoMqttExamplePlugin.jar` into the `plugins/jars` directory (open through the application)  

## Configuration
This plugin provides implementations for two extension points.

You may want to define their order in the `protocol.xml`.

The `PublishMessageHook` takes an optional color configuration.

```xml
<lists>
    <PublishMenuHook>
        <plugin name="example-plugin" />
    </PublishMenuHook>

    <PublishMessageHook>
        <plugin name="example-plugin">
            <color>blue</color>
        </plugin>
    </PublishMessageHook>
</lists>
````
