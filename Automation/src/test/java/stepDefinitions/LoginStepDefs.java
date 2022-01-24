package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j2;
import util.WebDriverUtil;

import java.util.List;

@Log4j2
public class LoginStepDefs extends Base {

    @Given("Launch the website")
    public void launchTheWebsite() {
        WebDriverUtil.launchURL();
    }

    @Given("^I navigate to login page$")
    public void iNavigateToLoginPage() throws InterruptedException {

        loginPage.navigateToLoginPage();
    }

    @Then("^I enter email address as \"([^\"]*)\"$")
    public void iEnterEmailAddressAs(String email) {
        loginPage.enterEmailAddressAs(email);
    }

    @And("^I enter password as \"([^\"]*)\"$")
    public void iEnterPasswordAs(String password)  {
        loginPage.enterPassword(password);
    }

    @And("^I click on Sign In button$")
    public void iClickOnSignInButton() {
        loginPage.clickOnSignInButton();
    }

    @Then("^I should see error message$")
    public void iShouldSeeErrorMessage() throws InterruptedException {
        loginPage.validateErrorMessage();
    }

    @Then("^I should see inline error messages for email and password$")
    public void iShouldSeeInlineErrorMessagesForEmailAndPassword() throws InterruptedException {
        loginPage.validateInlineErrorMessageForEmailAndPassword();
    }

    @Then("^I should see inline error messages for password$")
    public void iShouldSeeInlineErrorMessagesForPassword() throws InterruptedException {
        loginPage.validateInlineErrorMessageForPassword();
    }

    @Then("^I should see inline error messages for email$")
    public void iShouldSeeInlineErrorMessagesForEmail() throws InterruptedException {
        loginPage.validateInlineErrorMessageForEmailEmpty();
    }

    @Then("^I should see inline error messages for invalid email$")
    public void iShouldSeeInlineErrorMessagesForInvalidEmail() throws InterruptedException {
        loginPage.validateInlineErrorMessageForInvalidEmail();
    }


    @When("I enter account details")
    public void iEnterAccountDetails(DataTable dataTable) {
        List<List<String>> rows = dataTable.asLists(String.class);
        for (List<String> columns : rows) {
            loginPage.enterEmailAddressAs(columns.get(0));
            loginPage.enterPassword(columns.get(1));
            loginPage.clearEmailAddress();
            loginPage.clearPassword();
        }
    }
}
