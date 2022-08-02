package tickets;

import org.openqa.selenium.By;
import pageobject.pages.BaseFunc;

public class HomePage {
    private BaseFunc baseFunc;
    private final By AIRPORT_FROM = By.id("afrom");
    private final By AIRPORT_TO = By.id("bfrom");
    private final By GoBt = By.xpath(".//span[@class = 'gogogo']");

    public HomePage(BaseFunc baseFunc){
    this.baseFunc = baseFunc;
    }
    public void selectAirports(String from, String to){
    baseFunc.select(AIRPORT_FROM, from);
    baseFunc.select(AIRPORT_TO, to);

    }

    public void pressGoBt(){
    baseFunc.click(GoBt);
    }
}
