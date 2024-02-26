package org.selenium_cucumber.steps;

import io.cucumber.java.en.And;
import org.selenium_cucumber.TestData;
import org.selenium_cucumber.pages.CreateAccount;

public class CreateAccountSteps {
    CreateAccount createAccount = new CreateAccount();

    public CreateAccountSteps() {
    }

    @And("I complete the form with desired values")
    public void iCompleteTheFormWithDesiredValues() {
        createAccount.createAccount(TestData.FIRST_NAME.value, TestData.LAST_NAME.value, TestData.EMAIL.value, TestData.PASSWORD.value);
    }
}