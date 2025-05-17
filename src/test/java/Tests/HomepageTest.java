package Tests;

import Base.BaseTest;
import Base.ExcelReader;
import Pages.HomepagePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.IOException;
import static Helpers.URLs.HOME_PAGE_URL;

public class HomepageTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() throws IOException {
        homepagePage = new HomepagePage();
        excelReader = new ExcelReader("DemoQATestData.xlsx");
        driver.navigate().to(HOME_PAGE_URL);
    }

    @Test
    public void testIfHomepageIsReached() {
        String currentUrl = driver.getCurrentUrl();
        int expectedCardsNumber = 6;
        Assert.assertEquals(currentUrl, HOME_PAGE_URL);
        Assert.assertEquals(homepagePage.cardsList.size(), expectedCardsNumber);
    }
}
