package Selenium;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSeleniumTest {
    @Test
    public void openWebPage () {
        System.setProperty("webdriver.chrome.driver", "/Users/stalinskyi/Desktop/TESTING/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://qaguru.lv/");




    }


}
