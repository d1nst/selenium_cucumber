package org.selenium_cucumber.pages;

import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.selenium_cucumber.utils.Utils.*;

public class SuccessOrder extends PageObject {
    public SuccessOrder() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//span[@data-ui-id='page-title-wrapper']")
    public WebElement orderConfirmation;
    @FindBy(xpath = "//p[contains(text(),'Your order number is: ')]")
    public WebElement textOrderNumberIs;
    @FindBy(xpath = "//div[@class='checkout-success']//strong")
    public WebElement orderNumber;

    public void assertOrderSuccess(String expectedValue){
        Assert.assertEquals(orderConfirmation.getText(), expectedValue);
    }

    public void assertOrderText(){
        waitUntilIsVisible(getDriver(), textOrderNumberIs);
        Assert.assertTrue(textOrderNumberIs.isDisplayed());
    }

    public String getOrderNumber(){
        assertOrderText();
        return orderNumber.getText();
    }
}