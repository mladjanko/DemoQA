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
import static Helpers.URLs.HOMEPAGEURL;

public class TextBoxTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        homepagePage = new HomepagePage();
        leftsidemenuPage = new LeftsidemenuPage();
        textBoxPage = new TextBoxPage();

        driver.navigate().to(HOMEPAGEURL);
        homepagePage.clickOnCard(ELEMENTS);
        leftsidemenuPage.clickOnLeftMenuItem(excelReader.getStringData("Left Side Menu", 1, 1));
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
        String[] testData = getTestData(0); // Using row 0 for valid data
        String userName = testData[0];
        String userEmail = testData[1];
        String currentAddress = testData[2];
        String permanentAddress = testData[3];

        fillOutForm(userName, userEmail, currentAddress, permanentAddress);
        submitButton.click();

        // Verify that the correct output is displayed
        waitUntilVisibilityOf(outputTextBox);
        Assert.assertEquals(outputTextBox.getText(), "Name:" + userName + "\nEmail:" + userEmail + "\nCurrent Address :" + currentAddress + "\nPermananet Address :" + permanentAddress);
    }

    @Test(priority = 20)
    public void testWithInvalidEmail() {
        WebElement userEmailField = textBoxPage.userEmailField;
        WebElement submitButton = textBoxPage.submitButton;
        String[] testData = getTestData(1); // Using row 1 for invalid email
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
}
