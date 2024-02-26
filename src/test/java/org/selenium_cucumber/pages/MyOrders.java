package org.selenium_cucumber.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.selenium_cucumber.utils.Utils.checkIfElementIsVisible;
import static org.selenium_cucumber.utils.Utils.click;

public class MyOrders extends PageObject {

    public MyOrders() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//span[@data-ui-id='page-title-wrapper' and contains(text(), 'My Orders')]")
    public WebElement myOrdersPageTitle;
    @FindBy(xpath = "//*[@data-ui-id='page-title-wrapper']")
    public WebElement myOrdersNumberTitle;
    @FindBy(xpath = "//td[@data-th='Order #']")
    public List<WebElement> orderNumberList;
    @FindBy(xpath = "//td[@data-th='Date']")
    public List<WebElement> orderDateList;
    @FindBy(xpath = "//td[@data-th='Ship To']")
    public List<WebElement> orderShipToList;
    @FindBy(xpath = "//td[@data-th='Order Total']")
    public List<WebElement> orderTotalList;
    @FindBy(xpath = "//span[contains(text(),'View Order')]")
    public List<WebElement> viewOrderButtonList;
    @FindBy(xpath = "//strong[@class='product name product-item-name']")
    public WebElement productName;
    @FindBy(xpath = "//td[@data-th='SKU']")
    public WebElement productSku;
    @FindBy(xpath = "//*[@class='cart-price']//span")
    public List<WebElement> productPrice;
    @FindBy(xpath = "//*[@class='items-qty']//span")
    public List<WebElement> productQuantity;
    @FindBy(xpath = "//*[@data-th='Product Name']//dd")
    public List<WebElement> productSizeAndColor;
    @FindBy(xpath = "//tr[@class='subtotal']//td[@data-th='Subtotal']//span")
    public WebElement orderSubtotal;
    @FindBy(xpath = "//tr[@class='grand_total']//td[@data-th='Grand Total']//span")
    public WebElement orderGrandTotal;
    @FindBy(xpath = "//div[@class='box box-order-shipping-address']//address")
    public WebElement shippingAddress;
    @FindBy(xpath = "//div[@class='box box-order-billing-address']//address")
    public WebElement billingAddress;
    @FindBy(xpath = "//div[@class='box box-order-shipping-address']//address//a")
    public WebElement shippingAddressPhoneNumber;
    @FindBy(xpath = "//div[@class='box box-order-billing-address']//address//a")
    public WebElement billingAddressPhoneNumber;

    public void assertMyOrdersTitle(){
        checkIfElementIsVisible(myOrdersPageTitle);
    }

    public void assertLatestOrderValues(String orderNumber, String date, String shipTo, String orderTotal){
        assertEquals(orderNumber, orderNumberList.get(0).getText());
        assertEquals(date, orderDateList.get(0).getText());
        assertEquals(shipTo, orderShipToList.get(0).getText());
        assertEquals(orderTotal, orderTotalList.get(0).getText().replace("$", "").replace(".00", ""));
    }

    public void openOrder(int index){
        click(getDriver(),viewOrderButtonList.get(index));
    }

    public void checkOrderNumberInTitle(String orderNo){
        assertTrue("Order number doesn't match in title", myOrdersNumberTitle.getText().contains(orderNo));
    }

    public void checkProductName(String productName){
        assertEquals("Product name doesn't match in order details page", productName, this.productName.getText());
    }

    public void checkProductSku(String productSku){
        assertEquals("Product sku doesn't match in order details page", productSku, this.productSku.getText());
    }

    public void checkProductPrice(String productPrice){
        assertEquals("Product price doesn't match in order details page", productPrice, this.productPrice.get(0).getText().replace("$", "").replace(".00", ""));
    }

    public void checkProductQuantity(String productQuantity){
        assertEquals("Product quantity doesn't match in order details page", productQuantity, this.productQuantity.get(1).getText());
    }

    public void checkProductSubtotal(String productSubtotal){
        assertEquals("Product subtotal doesn't match in order details page", productSubtotal, productPrice.get(1).getText().replace("$", "").replace(".00", ""));
    }

    public void checkProductSize(String size){
        assertEquals("Product size doesn't match in order details page", size, productSizeAndColor.get(0).getText());
    }

    public void checkProductColor(String color){
        assertEquals("Product color doesn't match in order details page", color, productSizeAndColor.get(1).getText());
    }

    public void checkSubtotalForOrder(String subtotalForOrder){
        assertEquals("Order subtotal doesn't match in order details page", subtotalForOrder, orderSubtotal.getText().replace("$","").replace(".00",""));
    }

    public void checkGrandTotalForOrder(String grandTotalForOrder){
        assertEquals("Order grand total doesn't match in order details page", grandTotalForOrder, orderGrandTotal.getText().replace("$","").replace(".00",""));
    }

    public void checkShippingAddressForOrder(String shippingName, String shippingTown, String shippingAddress, String shippingCountry, String shippingPhoneNumber){
        String[] addressDetails = this.shippingAddress.getText().split("\n");
        assertTrue("Order shipping name doesn't match in order details page", addressDetails[0].contains(shippingName));
        assertTrue("Order shipping town doesn't match in order details page", addressDetails[1].contains(shippingTown));
        assertTrue("Order shipping address doesn't match in order details page", addressDetails[2].contains(shippingAddress));
        assertTrue("Order shipping country doesn't match in order details page", addressDetails[3].contains(shippingCountry));
        assertTrue("Order shipping town doesn't match in order details page", shippingAddressPhoneNumber.getText().contains(shippingPhoneNumber));
    }

    public void checkBillingAddressForOrder(String billingName, String billingTown, String billingAddress, String billingCountry, String billingPhoneNumber){
        String[] addressDetails = this.billingAddress.getText().split("\n");
        assertTrue("Order billing name doesn't match in order details page", addressDetails[0].contains(billingName));
        assertTrue("Order billing town doesn't match in order details page", addressDetails[1].contains(billingTown));
        assertTrue("Order billing address doesn't match in order details page", addressDetails[2].contains(billingAddress));
        assertTrue("Order billing country doesn't match in order details page", addressDetails[3].contains(billingCountry));
        assertTrue("Order billing town doesn't match in order details page", billingAddressPhoneNumber.getText().contains(billingPhoneNumber));
    }

    public void checkProductDetails(String name, String sku, String price, String quantity, String subtotal, String size, String color){
        checkProductName(name);
        checkProductSku(sku);
        checkProductPrice(price);
        checkProductQuantity(quantity);
        checkProductSubtotal(subtotal);
        checkProductSize(size);
        checkProductColor(color);
    }
}