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
    private static final String DEFAULT_SERVER_PROGRAM_PATH = "/programs/server/Server.jar";
    private static final String DEFAULT_SERVER_MAX_QUANT = "5";

    DefaultPropertiesGenerator(final File source) {
        super();
        this.source = source;
        defaultProperties = new Properties();
    }

    Properties getDefaultProperties() {
        return defaultProperties;
    }

    void generate() {
        defaultProperties.setProperty(SERVER_PORT, DEFAULT_SERVER_PORT);
        defaultProperties.setProperty(SERVER_PROGRAM_PATH, DEFAULT_SERVER_PROGRAM_PATH);
        defaultProperties.setProperty(SERVER_MAX_QUANT, DEFAULT_SERVER_MAX_QUANT);
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
