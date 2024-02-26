package org.selenium_cucumber.steps;

import io.cucumber.java.en.Then;
import lombok.SneakyThrows;
import org.selenium_cucumber.pages.*;
import static org.selenium_cucumber.utils.Utils.waitPageToLoad;

public class ShippingSteps {

    Shipping shipping = new Shipping();
    Payment payment = new Payment();
    SuccessOrder successOrder = new SuccessOrder();

    public static String orderNo;
    public ShippingSteps() {}

    @SneakyThrows
    @Then("I can complete shipping details and successfully place an order")
    public void iCanCompleteShippingDetailsAndSuccessfullyPlaceAnOrder() {
        waitPageToLoad();
        shipping.completeShippingDetails();
        shipping.proceedWithOrder();
        payment.waitForCheckoutPageToLoad();
        payment.clickPlaceOrderButton();
        orderNo = successOrder.getOrderNumber();
        successOrder.assertOrderSuccess("Thank you for your purchase!");
    }
}