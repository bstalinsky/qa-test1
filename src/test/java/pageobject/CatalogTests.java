package pageobject;

import org.junit.Test;
import pageobject.pages.BaseFunc;
import pageobject.pages.HomePage;

public class CatalogTests {
    private final String HOME_PAGE_URL = "1a.lv";
    private final String PRODUCT_FIND = "Apple";

    @Test
    public void productDetailsCheck(){

        BaseFunc baseFunc = new BaseFunc();
        BaseFunc.openUrl(HOME_PAGE_URL);

        HomePage homePage = new HomePage(baseFunc);
        homePage.acceptCookies();
        homePage.searchFor(PRODUCT_FIND);
    }
}
