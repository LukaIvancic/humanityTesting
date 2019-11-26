package pages;

import constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.ArrayList;
import java.util.List;

public class StaffPage extends BasePage {


    public StaffPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "act_primary")
    WebElement addEmployeeButton;

    @FindBy(id = "_asf1")
    WebElement employee1FirstNameField;

    @FindBy(id = "_asl1")
    WebElement employee1LastNameField;

    @FindBy(id = "_ase1")
    WebElement employee1EmailField;

    @FindBy(id = "_asf2")
    WebElement employee2FirstNameField;

    @FindBy(id = "_asl2")
    WebElement employee2LastNameField;

    @FindBy(id = "_ase2")
    WebElement employee2EmailField;

    @FindBy(id = "_asf3")
    WebElement employee3FirstNameField;

    @FindBy(id = "_asl3")
    WebElement employee3LastNameField;

    @FindBy(id = "_ase3")
    WebElement employee3EmailField;

    @FindBy(id = "_as_save_multiple")
    WebElement saveEmployeeButton;


    @FindBy(xpath ="//table[@class='employeesList']//tr[contains(@class,'j-employee-row')]")
    List<WebElement> employees;


     /**
     * Method clicks on Add Employee Button
     *
     * @author Luka.Ivancic
     *
     * */
    public void clickAddEmployeeButton(){

        addEmployeeButton.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * Method clicks on Save Employee Button
     *
     * @author Luka.Ivancic
     *
     * */
    public void clickSaveEmployeeButton(){

        saveEmployeeButton.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    /**
     * Method enters new employees data
     *
     * @param employeeFirstName, employeeLastName, employeeEmail
     *
     * @author Luka.Ivancic
     *
     * */
    public void enterEmployeeData(String employeeFirstName, String employeeLastName, String employeeEmail){
        employee1FirstNameField.sendKeys(employeeFirstName);
        employee1LastNameField.sendKeys(employeeLastName);
        employee1EmailField.sendKeys(employeeEmail);

    }


    /**
     * Mathod adds a single employee and clicks the Save Employee Button
     *
     * @param employeeFirstName, employeeLastName, employeeEmail
     *
     * @author Luka.Ivancic
     *
     * */
    public void addNewEmployee(String employeeFirstName, String employeeLastName, String employeeEmail){
        enterEmployeeData(employeeFirstName,employeeLastName, employeeEmail);
        clickSaveEmployeeButton();

    }

    /**
     * Method enters data for three different employees
     *
     * @author Luka.Ivancic
     * */
    public void enterMultipleEmployees(){
        employee1FirstNameField.sendKeys(Constants.EMPLOYEE2_FIRST_NAME);
        employee1LastNameField.sendKeys(Constants.EMPLOYEE2_LAST_NAME);
        employee1EmailField.sendKeys(Constants.EMPLOYEE2_EMAIL);
        employee2FirstNameField.sendKeys(Constants.EMPLOYEE3_FIRST_NAME);
        employee2LastNameField.sendKeys(Constants.EMPLOYEE3_LAST_NAME);
        employee2EmailField.sendKeys(Constants.EMPLOYEE3_EMAIL);
        employee3FirstNameField.sendKeys(Constants.EMPLOYEE4_FIRST_NAME);
        employee3LastNameField.sendKeys(Constants.EMPLOYEE4_LAST_NAME);
        employee3EmailField.sendKeys(Constants.EMPLOYEE4_EMAIL);

    }



    /**
     * Method check if the added employee is in the table
     *
     * @param newEmployee
     *
     * @return true if employee added, false if otherwise
     *
     * @author Luka.Ivancic
     * */
    public boolean isEmployeeAdded(String newEmployee){
        String employee;
        for (int i = 0; i <= employees.size(); i++) {
            employee = employees.get(i).getAttribute("title");

            if (employee.equalsIgnoreCase(newEmployee)){

                return true;
            }
        }
        return false;

    }

    /**
     * Method saves all employees in a list
     *
     * @return list of all employees
     *
     * @author Luka.Ivancic
     * */
    public List allEmployeesList(){
        String employee;
        List<String> allEmployees = new ArrayList<String>();
        for (int i = 0; i < employees.size(); i++) {
            employee = employees.get(i).getAttribute("title");
            allEmployees.add(employee);

        }return allEmployees;
    }

    /**
     * Method saves all newly added employees in a list
     *
     * @return list of newly added employees
     *
     * @author Luka.Ivancic
     * */
    public List addedEmployeesList(){
        List<String> addedEmployees = new ArrayList<String>();
        addedEmployees.add(Constants.EMPLOYEE2);
        addedEmployees.add(Constants.EMPLOYEE3);
        addedEmployees.add(Constants.EMPLOYEE4);
        return addedEmployees;

    }

    /**
     * Verify if newly added employees are in the list of all employees
     *
     * @param allEmployees list
     * @return true if new employees added to all employees list, false if otherwise
     *
     * @author Luka.Ivancic
     * */
    public boolean verifyMultipleEmployeesAdded(List<String> allEmployees){
        if(allEmployees.containsAll(addedEmployeesList())){
            return true;

        }
        return false;

    }

}


