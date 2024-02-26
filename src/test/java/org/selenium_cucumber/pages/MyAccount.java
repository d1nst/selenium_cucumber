package org.selenium_cucumber.pages;

import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.selenium_cucumber.TestData;
import static org.selenium_cucumber.utils.Utils.*;

public class MyAccount extends PageObject {

    public MyAccount() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//*[contains(text(), 'Thank you for registering with Main Website Store.')]")
    public WebElement accountConfirmationMessage;
    @FindBy(xpath = "//div[@class='box box-information']//div//p")
    public WebElement accountInformation;

    public void confirmationMessageVisible(){
        Assert.assertTrue(checkIfElementIsVisible(accountConfirmationMessage));
    }

    public void assertUserValues(){

        String[] userDetails = accountInformation.getText().split(" ");

        Assert.assertEquals("Displayed first name didn't equal expected value", userDetails[0], TestData.FIRST_NAME.value);
        Assert.assertEquals(userDetails[1].split("\n")[0], TestData.LAST_NAME.value);
        Assert.assertEquals(userDetails[1].split("\n")[1], TestData.EMAIL.value);
    }
}