package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationFormPage extends BaseTest {

    public RegistrationFormPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "firstName")
    public WebElement firstNameField;

    @FindBy(id = "lastName")
    public WebElement lastNameField;

    @FindBy(id = "userEmail")
    public WebElement userEmailField;

    @FindBy(id = "age")
    public WebElement ageField;

    @FindBy(id = "salary")
    public WebElement salaryField;

    @FindBy(id = "department")
    public WebElement departmentField;

    @FindBy(id = "submit")
    public WebElement submitButton;


    //--------------------

    public void inputFirstName(String firstName) {
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
    }

    public void inputLastName(String lastName) {
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }

    public void inputEmail(String email) {
        userEmailField.clear();
        userEmailField.sendKeys(email);
    }

    public void inputAge(String age) {
        ageField.clear();
        ageField.sendKeys(age);
    }

    public void inputSalary(String salary) {
        salaryField.clear();
        salaryField.sendKeys(salary);
    }

    public void inputDepartment(String department) {
        departmentField.clear();
        departmentField.sendKeys(department);
    }
}
