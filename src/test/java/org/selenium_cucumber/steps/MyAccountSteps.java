package org.selenium_cucumber.steps;

import io.cucumber.java.en.Then;
import org.selenium_cucumber.pages.MyAccount;

public class MyAccountSteps {
    MyAccount myAccount = new MyAccount();

    public MyAccountSteps() {
    }

    @Then("New account is created")
    public void newAccountIsCreated() {
        myAccount.confirmationMessageVisible();
        myAccount.assertUserValues();
    }
}
