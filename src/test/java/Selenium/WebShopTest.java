package Selenium;

import net.bytebuddy.asm.Advice;
import org.junit.Test;
import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

    public class WebShopTest {
    private final String HOME_PAGE_URL = "http://1a.lv";
    private final By SEARCH_INPUT_FIELD = By.id("q");
    private final By PRODUCT_TYPE = By.xpath(".//span[@class = 'single-title']");
    private final By ACCEPT_COOKIE = By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll");

    private final String CATEGORY_NAME = "Apple Airpods" ;


    @Test
    public void searchFieldsCheck(){
        System.setProperty("webdriver.chrome.driver", "/Users/stalinskyi/Desktop/TESTING/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(HOME_PAGE_URL);


       WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(ACCEPT_COOKIE));
        driver.findElement(ACCEPT_COOKIE).click();

        WebElement searchField = driver.findElement(SEARCH_INPUT_FIELD);
        searchField.sendKeys("Apple");
        searchField.sendKeys(Keys.ENTER);

       List<WebElement> subMenuItems = driver.findElements(PRODUCT_TYPE);


       boolean flag = false;
       for (WebElement item : subMenuItems) {
            if (item.getText().equals(CATEGORY_NAME)){
                flag = true;
                wait.until(ExpectedConditions.elementToBeClickable(item));
                try {
                    item.click();
                } catch (ElementClickInterceptedException e) {
                    item.click();
                }
                break;
            }
        }
        Assertions.assertTrue(flag, "Category not found");
    }
}
