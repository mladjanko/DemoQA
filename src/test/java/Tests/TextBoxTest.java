package Tests;

import Base.BaseTest;
import Pages.HomepagePage;
import Pages.LeftsidemenuPage;
import Pages.TextBoxPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Helpers.HomepageCards.ELEMENTS;
import static Helpers.URLs.TEXT_BOX_PAGE_URL;
import static Helpers.URLs.HOME_PAGE_URL;

public class TextBoxTest extends BaseTest {

    private static final int VALID_DATA_ROW = 0;
    private static final int INVALID_EMAIL_ROW = 1;

    @BeforeMethod
    public void pageSetUp() {
        homepagePage = new HomepagePage();
        leftsidemenuPage = new LeftsidemenuPage();
        textBoxPage = new TextBoxPage();

        driver.navigate().to(HOME_PAGE_URL);
        homepagePage.clickOnCard(ELEMENTS);
        leftsidemenuPage.clickOnLeftMenuItem(excelReader.getStringData("Left Side Menu", 1, 1));

        String currentURL = driver.getCurrentUrl();
        assert currentURL != null;
        Assert.assertTrue(testedPageIsReached(currentURL, TEXT_BOX_PAGE_URL), "Tested page is not reached!");
    }

    private void inputTextField(WebElement field, String value) {
        field.clear();
        field.sendKeys(value);
    }

    private String[] getTestData(int row) {
        return new String[]{
                excelReader.getStringData("Text Box", row, 1),  // userName
                excelReader.getStringData("Text Box", row, 2),  // userEmail
                excelReader.getStringData("Text Box", row, 3),  // currentAddress
                excelReader.getStringData("Text Box", row, 4)   // permanentAddress
        };
    }

    private void fillOutForm(String userName, String userEmail, String currentAddress, String permanentAddress) {
        inputTextField(textBoxPage.userNameField, userName);
        inputTextField(textBoxPage.userEmailField, userEmail);
        inputTextField(textBoxPage.currentAddressField, currentAddress);
        inputTextField(textBoxPage.permanentAddressField, permanentAddress);
        scrollToElement(textBoxPage.submitButton);
    }

    @Test(priority = 10)
    public void testWithValidData() {
        WebElement submitButton = textBoxPage.submitButton;
        WebElement outputTextBox = textBoxPage.outputTextBox;
        String[] testData = getTestData(VALID_DATA_ROW); // Using row 0 for valid data
        String userName = testData[0];
        String userEmail = testData[1];
        String currentAddress = testData[2];
        String permanentAddress = testData[3];

        fillOutForm(userName, userEmail, currentAddress, permanentAddress);
        submitButton.click();

        // Verify that the correct output is displayed
        waitUntilVisibilityOf(outputTextBox);
        String outputTextBoxText = outputTextBox.getText();
        Assert.assertTrue(outputTextBoxText.contains("Name:" + userName), "Name not found in output.");
        Assert.assertTrue(outputTextBoxText.contains("Email:" + userEmail), "Email not found in output.");
        Assert.assertTrue(outputTextBoxText.contains("Current Address :" + currentAddress), "Current Address not found.");
        Assert.assertTrue(outputTextBoxText.contains("Permanent Address :" + permanentAddress), "Permanent Address not found.");
    }

    @Test(priority = 20)
    public void testWithInvalidEmail() {
        WebElement userEmailField = textBoxPage.userEmailField;
        WebElement submitButton = textBoxPage.submitButton;
        String[] testData = getTestData(INVALID_EMAIL_ROW); // Using row 1 for invalid email
        String userName = testData[0];
        String userEmail = testData[1];
        String currentAddress = testData[2];
        String permanentAddress = testData[3];
        String expectedClassValue = "mr-sm-2 field-error form-control";

        // Verify the class before change
        String actualClassValueBeforeChange = userEmailField.getDomAttribute("class");
        Assert.assertNotEquals(actualClassValueBeforeChange, expectedClassValue, "The class before change is already the expected one.");

        fillOutForm(userName, userEmail, currentAddress, permanentAddress);
        submitButton.click();

        // Verify the class after change
        String actualClassValueAfterChange = userEmailField.getDomAttribute("class");
        Assert.assertEquals(actualClassValueAfterChange, expectedClassValue, "The class did not change to the expected one.");
    }

    @Test(priority = 30)
    public void testWithEmptyFields() {
        WebElement submitButton = textBoxPage.submitButton;
        WebElement outputTextBox = textBoxPage.outputTextBox;
        fillOutForm("", "", "", "");
        submitButton.click();

        //Test for blank fields / edge cases
        String outputTextBoxText = outputTextBox.getText();
        Assert.assertTrue(outputTextBoxText.isEmpty(), "Output should not be visible for empty input.");
    }
}
