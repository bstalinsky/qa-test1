package tickets;

import org.openqa.selenium.By;
import pageobject.pages.BaseFunc;

public class SeatSelectionPage {
    private final By SEAT = By.xpath(".//div[@class = 'seat']");
    private final By SEAT_NR = By.xpath(".//[@class = 'line']");
    private final By BOOK_BT = By.id("book3");
    private BaseFunc baseFunc;

    public SeatSelectionPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }
    public void selectSeat(int seatNr){
        for (WebElement we:baseFunc.findElements(SEAT) {
            if (Integer.parseInt(we.getText()) == seatNr {
                we.click();
                break;
            }
        }
    }
    public int getSelectedSeat(){
        return Integer.parseInt(baseFunc.findElement(SEAT_NR).getText().split(":")[1]);
    }
    public void book(){
        baseFunc.click(BOOK_BT);
    }
}
