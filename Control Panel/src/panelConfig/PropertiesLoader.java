package panelConfig;

import java.io.*;
import java.util.Properties;

class PropertiesLoader {

    private File source;
    private Properties properties;
    private FileInputStream fileInputStream;
    private DefaultPropertiesGenerator defaultPropertiesGenerator;

    private static String REQUIRED_PROPERTIES_EXTENSION = ".properties";

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
        verifySourceExtension();
        createDefaultProperties();
        if (sourceExists()) {
            createFileInputStream();
            loadPropertiesFromStream();
        } else {
            defaultPropertiesGenerator.save();
        }
    }

    private void verifySourceExtension() {
        final String extension;
        extension = PanelConfigUtilities.extractExtensionFromFile(source);
        if (!extension.equals(REQUIRED_PROPERTIES_EXTENSION)) {
            throw new PanelConfigException(PanelConfigException.REASON_INVALID_FILE_EXTENSION);
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
