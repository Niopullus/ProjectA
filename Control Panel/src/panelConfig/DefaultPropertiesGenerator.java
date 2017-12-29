package panelConfig;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import static panelConfig.PropertyKeys.*;

class DefaultPropertiesGenerator {

    private File source;
    private Properties defaultProperties;
    private FileOutputStream fileOutputStream;

    private static final String DEFAULT_SERVER_PORT = "00000";

    DefaultPropertiesGenerator(final File source) {
        super();
        this.source = source;
        defaultProperties = new Properties();
    }

    Properties getDefaultProperties() {
        return defaultProperties;
    }

    void generate() {
        defaultProperties.setProperty(SERVERPORT, DEFAULT_SERVER_PORT);
    }

    void save() {
        createFile();
        createFileOutputStream();
        saveToOutputStream();
    }

    private void createFile() {
        try {
            source.createNewFile();
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    private void createFileOutputStream() {
        try {
            fileOutputStream = new FileOutputStream(source);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void saveToOutputStream() {
        try {
            defaultProperties.store(fileOutputStream, null);
            fileOutputStream.close();
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

}
