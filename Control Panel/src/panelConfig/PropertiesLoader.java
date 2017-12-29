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

    PropertiesLoader() {
        super();
        properties = new Properties();
    }

    void setSource(final File source) {
        this.source = source;
    }

    Properties getProperties() {
        return properties;
    }

    void loadProperties() {
        fileInputStream = getFileInputStream();
        try {
            properties.load(fileInputStream);
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    private FileInputStream getFileInputStream() {
        try {
            return new FileInputStream(source);
        } catch (final FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

}
