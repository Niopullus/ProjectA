package panelConfig;

import java.io.File;
import java.util.Properties;
import static panelConfig.PropertyKeys.*;

public class PanelConfig {

    private Properties properties;

    public PanelConfig(final File source) {
        super();
        loadProperties(source);
    }

    private void loadProperties(final File source) {
        final PropertiesLoader propertiesLoader;
        propertiesLoader = new PropertiesLoader();
        propertiesLoader.setSource(source);
        propertiesLoader.loadProperties();
        properties = propertiesLoader.getProperties();
    }

    public int getServerPort() {
        final String portString;
        portString = properties.getProperty(SERVER_PORT);
        return Integer.parseInt(portString);
    }

    public int getMaxServerQuantity() {
        final String maximumString;
        maximumString = properties.getProperty(SERVER_MAX_QUANT);
        return Integer.parseInt(maximumString);
    }

    public String getServerProgramPath() {
        return properties.getProperty(SERVER_PROGRAM_PATH);
    }

}
