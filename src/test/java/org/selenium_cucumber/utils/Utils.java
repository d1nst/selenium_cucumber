package org.selenium_cucumber.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class Utils {

    public Utils() {
        PageFactory.initElements(getDriver(), this);
    }

    public static void scrollToElement(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }

    public static void waitUntilIsClickable(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 10, 50);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitUntilIsClickable(WebDriver driver, WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout, 50);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitUntilIsVisible(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static void waitUntilIsNotVisible(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public static boolean checkIfElementIsVisible(WebElement element) {
        try{
            return element.isDisplayed();
        } catch (Exception e){
            return false;
        }
    }

    public static void waitPageToLoad() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor) getDriver()).executeScript("return document.readyState")
                .toString().equals("complete");
        wait.until(jsLoad);
    }

    public static void sendKeys(WebDriver driver, WebElement element, String value){
        waitUntilIsVisible(driver, element);
        element.clear();
        element.sendKeys(value);
    }

    public static void click(WebDriver driver, WebElement element){
        waitUntilIsVisible(driver, element);
        element.click();
    }

    public static void hoverElement(WebDriver driver, WebElement element){
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }

    public static int generateRandomNumber(){
        Random random = new Random();
        return random.nextInt(9999) + 1;
    }
    public static String generateEmail(){
        int randomNumber = generateRandomNumber();
        return "testDan" + randomNumber + "@magento.com";
    }

    public static void waitUntilEquals(WebElement element, String expectedValue){
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.textToBePresentInElement(element, expectedValue));
    }

    public static void selectDropdown(WebDriver driver, WebElement element, String option){
        waitUntilIsVisible(driver, element);
        Select dropdown = new Select(element);
        dropdown.selectByValue(option);
    }

    public static void waitUntilLoaderEnds(WebElement element){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until((ExpectedCondition<Boolean>) driver1 -> {
            String style = element.getAttribute("style");
            return !style.contains("display: block;");
        });
    }

    public static void click(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor)getDriver();
        js.executeScript("arguments[0].click();", element);
    }

    public static String generateTodayDate(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("M/d/yy");
        Date currentDate = new Date();
        return dateFormat.format(currentDate);
    }
}