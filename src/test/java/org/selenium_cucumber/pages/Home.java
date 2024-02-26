package org.selenium_cucumber.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.selenium_cucumber.myRunner.TestRunner;

import static org.selenium_cucumber.utils.Utils.*;

public class Home extends PageObject {

    public Home() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//header[@class='page-header']//a[contains(text(),'Create an Account')]")
    public WebElement createAccountButton;

    @FindBy(xpath = "//div[@class='panel header']//a[contains(text(),'Sign In')]")
    public WebElement signInButton;

    @FindBy(id = "ui-id-5")
    public WebElement menMenu;

    @FindBy(id = "ui-id-17")
    public WebElement menTopsMenu;

    @FindBy(id = "ui-id-19")
    public WebElement menTopsJacketsMenu;

    @FindBy(xpath = "(//button[@class='action switch'])[1]")
    public WebElement userMenuDropDown;

    @FindBy(xpath = "//a[contains(text(),'My Account')]")
    public WebElement myAccount;

    @FindBy(xpath = "//a[contains(text(),'My Orders')]")
    public WebElement myOrders;

    public void navigateHomePage(){
        getDriver().navigate().to(TestRunner.URL);
        waitPageToLoad();
        getDriver().manage().deleteAllCookies();
        getDriver().navigate().refresh();
        getDriver().manage().window().maximize();
    }

    public void clickCreateAccountButton(){
        click(getDriver(), createAccountButton);
    }

    public void clickSignInButton(){
        click(getDriver(), signInButton);
    }

    public void hoverMenMenu(){
        hoverElement(getDriver(), menMenu);
    }

    public void hoverMenTopsMenu(){
        hoverElement(getDriver(), menTopsMenu);
    }

    public void clickMenTopsJacketsMenu(){
        click(getDriver(), menTopsJacketsMenu);
    }

    public void navigateToMensJackets(){
        hoverMenMenu();
        hoverMenTopsMenu();
        clickMenTopsJacketsMenu();
    }

    public void clickUserMenu(){
        click(getDriver(), userMenuDropDown);
    }

    public void clickMyAccount(){
        click(getDriver(), myAccount);
    }

    public void clickMyOrders(){
        click(getDriver(), myOrders);
    }

    public void navigateToMyOrders(){
        clickUserMenu();
        clickMyAccount();
        clickMyOrders();

    }
}