package org.selenium_cucumber.steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.selenium_cucumber.pages.*;

public class HomeSteps {

    public HomeSteps(){}

    public static String productName;
    public static String productSku;
    public static String productPrice;
    public static final String size = "XL";
    public static final String quantity = "3";
    public static final String color = "Blue";

    Home home = new Home();
    Men men = new Men();
    CustomerLogin login = new CustomerLogin();
    MyOrders myOrders = new MyOrders();

    @Before
    public void set_the_stage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("I am an user navigating to homepage")
    public void iAmAnUserNavigatingToHomepage() {
        home.navigateHomePage();
    }

    @Given("I log in with a created account")
    public void iLoginWithACreatedAccount() {
        home.navigateHomePage();
        home.clickSignInButton();
        login.loginWithValidCredentials();
    }

    @When("I click on Create Account button")
    public void iClickOnCreateAccountButton() {
        home.clickCreateAccountButton();
    }

    @When("I fill in my basket and proceed to checkout")
    public void iFillInMyBasketAndProceedToCheckout() {
        home.navigateToMensJackets();
        men.assertMenJacketsTitle();
        men.clickFirstProductFromMensJackets();
        productName = men.getProductName();
        productSku = men.getProductSku();
        productPrice = men.getProductPrice();
        men.addProductToCart(size, color, quantity);
        men.assertCartTotalProducts(quantity);
        men.navigateToCart();
        men.clickCheckoutButton();
    }

    @When("I navigate to My Orders")
    public void iNavigateToMyOrders() {
        home.navigateToMyOrders();
        myOrders.assertMyOrdersTitle();
    }
}