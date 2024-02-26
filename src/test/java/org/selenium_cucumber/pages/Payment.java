package org.selenium_cucumber.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.selenium_cucumber.utils.Utils.*;

public class Payment extends PageObject {
    public Payment() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//span[contains(text(),'Place Order')]")
    public WebElement placeOrder;
    @FindBy(xpath = "//td[@data-th='Order Total']//span")
    public WebElement orderTotal;
    @FindBy(xpath = "//span[@data-th='Shipping']")
    public WebElement shippingCost;
    @FindBy(xpath = "//div[@data-role='loader']")
    public WebElement checkoutLoader;

    public static String orderAmount;
    public static String shippingAmount;

    public void clickPlaceOrderButton(){
        waitUntilIsClickable(getDriver(), placeOrder, 60);
        orderAmount = orderTotal.getText().replace("$", "").replace(".00", "");
        shippingAmount= shippingCost.getText().replace("$", "").replace(".00", "");
        click(placeOrder);
    }

    public void waitForCheckoutPageToLoad(){
        waitUntilLoaderEnds(checkoutLoader);
    }
}