package util;


import com.google.gson.Gson;
import jsonDataReader.Customer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CustomerDataReader {
    private final String customerFilePath = FileReaderManager.getInstance().getConfigReader().getTestDataResourcePath();
    private final List<Customer> customerList;

    public CustomerDataReader(){
        customerList = getCustomerData();
    }

    private List<Customer> getCustomerData() {
        Gson gson = new Gson();
        BufferedReader bufferedReader;

        try  {
            bufferedReader = new BufferedReader(new FileReader(customerFilePath));
            Customer[] customers = gson.fromJson(bufferedReader, Customer[].class);
            return Arrays.asList(customers);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public final Customer getCustomerByName(final String customerName){
        return customerList.stream().filter(x -> x.firstName.equalsIgnoreCase(customerName)).findAny().get();
    }
}
