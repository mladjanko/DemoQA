package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public Actions actions;
    public ExcelReader excelReader;
    public HomepagePage homepagePage;
    public LeftsidemenuPage leftsidemenuPage;
    public TextBoxPage textBoxPage;
    public CheckBoxPage checkBoxPage;
    public RadioButtonPage radioButtonPage;
    public WebTablesPage webTablesPage;
    public RegistrationFormPage registrationFormPage;
    public ButtonsPage buttonsPage;
    public LinksPage linksPage;
    public BrokenLinksImagesPage brokenLinksImagesPage;
    public UploadAndDownloadPage uploadAndDownloadPage;
    public DynamicPropertiesPage dynamicPropertiesPage;
    public PracticeFormPage practiceFormPage;
    public PracticeFormModalPage practiceFormModalPage;
    public BrowserWindowsPage browserWindowsPage;
    public NewWindowPage newWindowPage;
    public NewWindowMessagePage newWindowMessagePage;
    public AlertsPage alertsPage;
    public FramesPage framesPage;
    public Frame1Page frame1Page;
    public Frame2Page frame2Page;
    public NestedFramesPage nestedFramesPage;
    public ParentIframePage parentIframePage;
    public ChildIframePage childIframePage;
    public ModalDialogsPage modalDialogsPage;
    public LargeModalPage largeModalPage;
    public SmallModalPage smallModalPage;
    public AccordionPage accordionPage;

    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        excelReader = new ExcelReader("DemoQATestData.xlsx");
    }

    @BeforeMethod
    public void driverSetUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterMethod
    public static void tearDown() {
        if (driver != null) {
            driver.quit(); // Quit the WebDriver instance after all tests.
        }
    }

    public boolean testedPageIsReached(String currentURL, String expectedURL) {
        return currentURL.equalsIgnoreCase(expectedURL);
    }

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void clickElementJS(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
    }

    public void waitUntilVisibilityOf(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void waitUntilInvisibilityOf(WebElement webElement) {
        wait.until(ExpectedConditions.invisibilityOf(webElement));
    }

    public void waitUntilElementToBeClickable(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void waitUntilCssPropertyValueChange(WebElement webElement, String cssProperty, String expectedValue) {
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                String currentPropertyValue = webElement.getCssValue(cssProperty);
                return currentPropertyValue.equals(expectedValue);
            }
        });
    }
}
