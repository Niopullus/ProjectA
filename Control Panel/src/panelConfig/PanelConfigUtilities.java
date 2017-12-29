package panelConfig;

import java.io.File;

public class PanelConfigUtilities {

    private PanelConfigUtilities() {
        super();
    }

    static String extractExtensionFromFile(final File file) {
        final int dotIndex;
        final String filePath;
        filePath = file.getPath();
        dotIndex = filePath.lastIndexOf('.');
        return filePath.substring(dotIndex);
    }

}
