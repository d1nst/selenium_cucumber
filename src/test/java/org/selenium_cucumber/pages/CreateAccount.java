package org.selenium_cucumber.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.selenium_cucumber.utils.Utils.*;

public class CreateAccount extends PageObject {

    public CreateAccount() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(id = "firstname")
    public WebElement firstName;
    @FindBy(id = "lastname")
    public WebElement lastName;
    @FindBy(id = "email_address")
    public WebElement email;
    @FindBy(id = "password")
    public WebElement password;
    @FindBy(id = "password-confirmation")
    public WebElement confirmPassword;
    @FindBy(xpath = "//form[@id='form-validate']//button[@type='submit']")
    public WebElement createAccountButton;

    public void setFirstName(String value){
        sendKeys(getDriver(), firstName, value);
    }
    public void setLastName(String value){
        sendKeys(getDriver(), lastName, value);
    }
    public void setEmail(String value){
        sendKeys(getDriver(), email, value);
    }
    public void setPassword(String value){
        sendKeys(getDriver(), password, value);
    }
    public void setConfirmPassword(String value){
        sendKeys(getDriver(), confirmPassword, value);
    }
    public void clickCreateAccountButton(){
        click(createAccountButton);
    }

    public void createAccount(String firstName, String lastName, String email, String password){
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setPassword(password);
        setConfirmPassword(password);
        clickCreateAccountButton();
    }
}