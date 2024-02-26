package org.selenium_cucumber.pages;

import net.serenitybdd.core.pages.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.selenium_cucumber.TestData;
import java.util.List;
import static org.selenium_cucumber.utils.Utils.*;

public class Shipping extends PageObject {
    public Shipping() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//*[@id='shipping']//div[@class='step-title']")
    public WebElement shippingPageTitle;
    @FindBy(xpath = "//input[@name='street[0]']")
    public WebElement address;
    @FindBy(xpath = "//select[@name='country_id']")
    public WebElement country;
    @FindBy(xpath = "//select[@name='region_id']")
    public WebElement state;
    @FindBy(xpath = "//input[@name='city']")
    public WebElement city;
    @FindBy(xpath = "//input[@name='postcode']")
    public WebElement postalCode;
    @FindBy(xpath = "//input[@name='telephone']")
    public WebElement phoneNo;
    @FindBy(xpath = "//tr[@data-bind='click: element.selectShippingMethod']")
    public List<WebElement> shippingMethodsList;
    @FindBy(id = "label_method_flatrate_flatrate")
    public WebElement shippingMethodLabel;
    @FindBy(xpath = "//button[@data-role='opc-continue']")
    public WebElement proceedOrder;

    public void waitShippingPageLoad(){
        waitUntilIsVisible(getDriver(), shippingPageTitle);
    }

    public void fillInStreetAddress(String addressValue){
        sendKeys(getDriver(), address, addressValue);
    }

    public void setCountry(String countryValue){
        selectDropdown(getDriver(), country, countryValue);
    }

    public void setState(String stateValue){
        selectDropdown(getDriver(), state, stateValue);
    }

    public void fillInCity(String cityValue){
        sendKeys(getDriver(), city, cityValue);
    }

    public void fillInPostalCode(String postCode){
        sendKeys(getDriver(), postalCode, postCode);
    }
    public void fillInPhoneNumber(String phoneNumber){
        sendKeys(getDriver(), phoneNo, phoneNumber);
    }

    public void waitShippingSecondMethodDissapear(){
        waitUntilIsNotVisible(getDriver(), shippingMethodsList.get(1));
    }

    public void waitShippingMethodLabel(String value){
        waitUntilEquals(shippingMethodLabel, value);
    }

    public void proceedWithOrder(){
        click(getDriver(), proceedOrder);
        waitPageToLoad();
    }

    public void completeShippingDetails(){
        waitShippingPageLoad();
        fillInStreetAddress(TestData.TOWN.value);
        setCountry(TestData.COUNTRY_CODE.value);
        setState(TestData.STATE_CODE.value);
        fillInCity(TestData.TOWN.value);
        fillInPostalCode(TestData.POSTAL_CODE.value);
        fillInPhoneNumber(TestData.PHONE_NUMBER.value);
        waitShippingSecondMethodDissapear();
        waitShippingMethodLabel("Fixed");
    }
}