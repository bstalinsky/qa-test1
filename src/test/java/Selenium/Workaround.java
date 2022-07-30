package Selenium;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
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

public class Workaround {

    private final String HOME_PAGE_URL = "http://1a.lv";
    private final String CATALOG_URL = "https://www.1a.lv/c/sadzives-tehnika/virtuvei-maza-sadzives-tehnika/tejkannas-elektriskas/2y2";
    private final By ACCEPT_COOKIE = By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll");
    private final By MENU_ITEM = By.xpath(".//li[contains(@class, 'submenu-lvl1__list-item--has-child')]");
    private final By MENU = By.xpath(".//div[contains(@class, 'invisible submenu-lvl1--index')]");
    private final String MENU_ITEM_TO_OPEN = "Sadzīves tehnika";
    private final By CATALOG_ITEM = By.xpath(".//div[contains(@class, 'catalog-taxons-product catalog-taxons-product--grid-view')]");
    private final By CATALOG_ITEM_NAME = By.xpath(".//a[contains(@class , 'catalog-taxons-product__name')]");
    private WebDriver driver;

//        @BeforeEach
//        public void before(){
//            System.setProperty("webdriver.chrome.driver", "/Users/stalinskyi/Desktop/TESTING/chromedriver");
//            driver = new ChromeDriver();
//            driver.manage().window().maximize();
//            driver.get(HOME_PAGE_URL);
//
//
//            WebDriverWait wait = new WebDriverWait(driver, 5);
//            wait.until(ExpectedConditions.elementToBeClickable(ACCEPT_COOKIE));
//            driver.findElement(ACCEPT_COOKIE).click();
//        }

    @Test
    public void menuWorkaround() {
        System.setProperty("webdriver.chrome.driver", "/Users/stalinskyi/Desktop/TESTING/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(HOME_PAGE_URL);


        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(ACCEPT_COOKIE));
        driver.findElement(ACCEPT_COOKIE).click();

        List<WebElement> menuItems = driver.findElement(MENU).findElements(MENU_ITEM);

        for (WebElement we : menuItems) {
            if (we.getText().equals(MENU_ITEM_TO_OPEN)) {
                we.click();
                break;
            }

        }

    }

    @Test
    public void catalogWorkaround() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/stalinskyi/Desktop/TESTING/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(HOME_PAGE_URL);


        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(ACCEPT_COOKIE));
        driver.findElement(ACCEPT_COOKIE).click();

        driver.get(CATALOG_URL);

        List<WebElement> caralogItems = driver.findElements(CATALOG_ITEM);
        try {
            caralogItems.get(14).click();
        } catch (ElementClickInterceptedException e) {
            caralogItems.get(14);
        }

        caralogItems.get(14).findElement(CATALOG_ITEM_NAME).click();

        Thread.sleep(3000);

        driver.quit();


    }
}
//        @AfterEach
//    public void closeBrowser(){
//            System.setProperty("webdriver.chrome.driver", "/Users/stalinskyi/Desktop/TESTING/chromedriver");
//            WebDriver driver = new ChromeDriver();
////            driver.close();
//        }
