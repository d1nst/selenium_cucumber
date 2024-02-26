package org.selenium_cucumber.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.selenium_cucumber.TestData;

import static org.selenium_cucumber.utils.Utils.*;


public class CustomerLogin extends PageObject {

    public CustomerLogin() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(id = "email")
    public WebElement email;
    @FindBy(id = "pass")
    public WebElement password;
    @FindBy(id = "send2")
    public WebElement loginButton;

    public void loginWithValidCredentials(){
        sendKeys(getDriver(), email, TestData.EMAIL.value);
        sendKeys(getDriver(), password, TestData.PASSWORD.value);
        click(getDriver(), loginButton);
    }
}

