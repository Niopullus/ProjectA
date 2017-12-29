package panelConfig;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

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

    public int getPort() {
        return 0; //temp
    }

}
