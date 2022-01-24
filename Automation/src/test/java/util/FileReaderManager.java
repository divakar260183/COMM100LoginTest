package util;

public class FileReaderManager {
    private static final FileReaderManager FILE_READER_MANAGER = new FileReaderManager();
    private static ConfigFileReader configFileReader;
    private static CustomerDataReader customerDataReader;
    private static ErrorMessageReader errorMessageReader;

    private FileReaderManager() {
    }

    public static FileReaderManager getInstance( ) {
        return FILE_READER_MANAGER;
    }

    public ConfigFileReader getConfigReader() {
        return (configFileReader == null) ? new ConfigFileReader() : configFileReader;
    }

    public CustomerDataReader getCustomerJsonReader(){
        return (customerDataReader == null) ? new CustomerDataReader() : customerDataReader;
    }

    public ErrorMessageReader getErrorMessageJsonReader() {
        return (errorMessageReader == null) ? new ErrorMessageReader() : errorMessageReader;
    }
}
