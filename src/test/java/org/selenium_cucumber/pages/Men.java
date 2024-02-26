package org.selenium_cucumber.pages;

import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import static org.selenium_cucumber.utils.Utils.*;

public class Men extends PageObject {

    public Men() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//h1//span[contains(text(),'Jackets')]")
    public WebElement menJacketsTitle;
    @FindBy(xpath = "//img[@class='product-image-photo']")
    public List<WebElement> menJacketsItemsPhoto;
    @FindBy(xpath = "//button[@title='Add to Cart']")
    public List<WebElement> addToCartButtons;
    @FindBy(xpath = "//span[@data-ui-id='page-title-wrapper']")
    public WebElement productName;
    @FindBy(xpath = "//div[@itemprop='sku']")
    public WebElement productSku;
    @FindBy(className = "price")
    public WebElement productPrice;
    @FindBy(id = "qty")
    public WebElement quantity;
    @FindBy(xpath = "//*[@class='product-info-main']")
    public WebElement productInfoSection;
    @FindBy(id = "product-addtocart-button")
    public WebElement addToCartProductButton;
    @FindBy(id = "top-cart-btn-checkout")
    public WebElement cartCheckout;
    @FindBy(xpath = "//span[@class='counter-number']")
    public WebElement cartTotalProducts;

    public void assertMenJacketsTitle(){
        Assert.assertTrue(checkIfElementIsVisible(menJacketsTitle));
    }

    public void clickFirstProductFromMensJackets(){
        hoverElement(getDriver(), menJacketsItemsPhoto.get(0));
        click(getDriver(), addToCartButtons.get(0));
    }

    public void waitProductPageToLoad(){
        waitUntilIsVisible(getDriver(), productInfoSection);
    }

    public void chooseSize(String size){
        click(getDriver(),getDriver().findElement(By.xpath("//div[@option-label='"+size+"']")));
    }

    public void chooseColor(String color){
        chooseSize(color);
    }

    public void setQuantity(String value){
        sendKeys(getDriver(), quantity, value);
    }

    public void clickAddToCartProductButton(){
        click(getDriver(), addToCartProductButton);
    }

    public void assertCartTotalProducts(String value){
        waitUntilEquals(cartTotalProducts, value);
    }

    public void navigateToCart(){
        click(getDriver(), cartTotalProducts);
    }

    public void clickCheckoutButton(){
        click(getDriver(), cartCheckout);
    }

    public void addProductToCart(String size, String color, String quantity){
        waitProductPageToLoad();
        chooseSize(size);
        chooseColor(color);
        setQuantity(quantity);
        clickAddToCartProductButton();
    }

    public String getProductName(){
        waitProductPageToLoad();
        return productName.getText();
    }

    public String getProductSku(){
        return productSku.getText();
    }

    public String getProductPrice(){
        return productPrice.getText().replace("$", "").replace(".00", "");
    }

}