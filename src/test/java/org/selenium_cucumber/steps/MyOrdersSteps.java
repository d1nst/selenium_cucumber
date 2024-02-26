package org.selenium_cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.selenium_cucumber.TestData;
import org.selenium_cucumber.pages.MyOrders;

import static org.selenium_cucumber.pages.Payment.orderAmount;
import static org.selenium_cucumber.pages.Payment.shippingAmount;
import static org.selenium_cucumber.steps.HomeSteps.*;
import static org.selenium_cucumber.steps.ShippingSteps.orderNo;
import static org.selenium_cucumber.utils.Utils.generateTodayDate;

public class MyOrdersSteps {
    MyOrders myOrders = new MyOrders();

    @And("View order action opens the right order")
    public void viewOrderActionOpensTheRightOrder() {
        String productSku = HomeSteps.productSku + "-" + size + "-" + color;
        int subtotal = Integer.parseInt(productPrice) * Integer.parseInt(quantity);
        int grandTotal = Integer.parseInt(shippingAmount) + subtotal;
        String shippingName = TestData.FIRST_NAME.value + " " + TestData.LAST_NAME.value;
        String shippingAddress = TestData.TOWN.value + ", " + TestData.TOWN.value + ", " + TestData.POSTAL_CODE.value;
        myOrders.openOrder(0);
        myOrders.checkOrderNumberInTitle(orderNo);
        myOrders.checkProductDetails(productName, productSku, productPrice, quantity, String.valueOf(subtotal), size, color);
        myOrders.checkShippingAddressForOrder(shippingName, TestData.TOWN.value, shippingAddress, TestData.COUNTRY.value, TestData.PHONE_NUMBER.value);
        myOrders.checkBillingAddressForOrder(shippingName, TestData.TOWN.value, shippingAddress, TestData.COUNTRY.value, TestData.PHONE_NUMBER.value);
        myOrders.checkSubtotalForOrder(String.valueOf(subtotal));
        myOrders.checkGrandTotalForOrder(String.valueOf(grandTotal));
    }

    @Then("Latest order from My Orders details are correct")
    public void latestOrderFromMyOrdersDetailsAreCorrect() {
        String shipTo = TestData.FIRST_NAME.value + " " + TestData.LAST_NAME.value;
        String date = generateTodayDate();
        myOrders.assertLatestOrderValues(orderNo, date, shipTo, orderAmount);
    }
}