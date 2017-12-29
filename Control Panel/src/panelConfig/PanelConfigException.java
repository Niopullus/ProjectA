package panelConfig;

public class PanelConfigException extends RuntimeException {

    static final String REASON_INVALID_FILE_EXTENSION =
            "Invalid file extension: Config file requires .properties";

    PanelConfigException(final String reason) {
        super(reason);
    }

}
