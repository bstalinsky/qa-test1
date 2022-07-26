package Selenium;

import net.bytebuddy.asm.Advice;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebShopTest {
    private final String HOME_PAGE_URL = "http://1a.lv";
    private final By SEARCH_INPUT_FIELD = By.id("q");
private final By PRODUCT_TYPE = By.xpath(".//span[@class = 'single-title']");

    @Test
    public void searchFieldsCheck(){
        System.setProperty("webdriver.chrome.driver", "/Users/stalinskyi/Desktop/TESTING/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(HOME_PAGE_URL );
        WebElement searchField = driver.findElement(SEARCH_INPUT_FIELD);
        searchField.sendKeys("Apple");
        searchField.sendKeys(Keys.ENTER);
    }
}
