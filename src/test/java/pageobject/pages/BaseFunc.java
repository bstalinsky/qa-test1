package pageobject.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class BaseFunc {
    private static WebDriver driver;
    private static WebDriverWait wait;


    public BaseFunc() {
        System.setProperty("webdriver.chrome.driver", "/Users/stalinskyi/Desktop/TESTING/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);

//        WebDriverWait wait = new WebDriverWait(driver, 5);
    }

    public static void openUrl(String url) {
//        if (url.startsWith("http://") || url.startsWith("https://")){
//
//        } else {
//            url = "http://" + url;
//        }
//       true -> false    ! = не , && = и , || = или

        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "http://" + url;
        }
        driver.get(url);
    }

    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        WebElement we = driver.findElement(locator);
        try {
            we.click();
        } catch (ElementClickInterceptedException e) {
            System.out.println("Can't click");
            we.click();
        }

    }
    public List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    public void type(By locator, String text){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        WebElement inputField = driver.findElement(locator);

        inputField.clear();
        inputField.sendKeys(text);
    }
    public void type(By locator, int text){
    type(locator, String.valueOf(text));
    }

    public void pressKey(By locator, Keys key){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        WebElement we = driver.findElement(locator);

        we.sendKeys(key);
    }
//    public WebElement findElement(By locator){
//        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
//    }
    public WebElement findElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return  wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void select(By locator, String value){
        Select select = new Select(findElement(locator));
        select.selectByValue(value);
    }
    public void selectByVisibleText(By locator,String value){
        Select select = new Select(findElement(locator));
        select.selectByVisibleText(value);
    }
}

