package util;

import com.google.gson.Gson;
import jsonDataReader.ErrorMessages;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ErrorMessageReader {
    private final String errorMessagesFilePath = FileReaderManager.getInstance().getConfigReader().getErrorMessagesResourcePath();



    public ErrorMessages getErrorMessage() {
        Gson gson = new Gson();
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(errorMessagesFilePath));
            ErrorMessages errorMessages = gson.fromJson(bufferedReader, ErrorMessages.class);
            return errorMessages;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
