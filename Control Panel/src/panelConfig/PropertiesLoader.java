package panelConfig;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

class PropertiesLoader {

    private File source;
    private Properties properties;
    private FileInputStream fileInputStream;
    private DefaultPropertiesGenerator defaultPropertiesGenerator;

    PropertiesLoader() {
        super();
    }

    void setSource(final File source) {
        this.source = source;
    }

    Properties getProperties() {
        return properties;
    }

    void loadProperties() {
        createDefaultProperties();
        if (sourceExists()) {
            createFileInputStream();
            loadPropertiesFromStream();
        } else {
            defaultPropertiesGenerator.save();
        }
    }

    private void createDefaultProperties() {
        final Properties defaultProperties;
        defaultPropertiesGenerator = new DefaultPropertiesGenerator(source);
        defaultPropertiesGenerator.generate();
        defaultProperties = defaultPropertiesGenerator.getDefaultProperties();
        properties = new Properties(defaultProperties);
    }

    private boolean sourceExists() {
        return fileInputStream != null;
    }

    private void createFileInputStream() {
        try {
            fileInputStream = new FileInputStream(source);
        } catch (final FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void loadPropertiesFromStream() {
        try {
            properties.load(fileInputStream);
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

}
