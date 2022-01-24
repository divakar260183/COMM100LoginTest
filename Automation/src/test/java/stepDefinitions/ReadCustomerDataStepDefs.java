package stepDefinitions;

import io.cucumber.java.en.Given;
import lombok.extern.log4j.Log4j2;
import jsonDataReader.Customer;
import util.FileReaderManager;

@Log4j2
public class ReadCustomerDataStepDefs extends Base {

    @Given("I read Customer Data for {string}")
    public void iReadCustomerDataFor(String customerName) {

        log.info("Read Customer Data for: {}", customerName);
        Customer customer = FileReaderManager.getInstance().getCustomerJsonReader().getCustomerByName(customerName);
        log.info("Customer Name : {}",customer.firstName + " " + customer.lastName);
        log.info("Customer Image : {}",customer.age);
        log.info("emailAddress :{}",customer.emailAddress);
        log.info("address.streetAddress {}",customer.address.streetAddress);
        log.info("address.city {}", customer.address.city);
        log.info("address.postCode {}", customer.address.postCode);
        log.info("address.state {}", customer.address.state);
        log.info("address.country {}", customer.address.country);
        log.info("phoneNumber.home {}", customer.phoneNumber.home);
        log.info("phoneNumber.mob {}", customer.phoneNumber.mob);
    }
}
