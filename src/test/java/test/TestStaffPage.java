package test;

import constants.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.StaffPage;
import java.util.Arrays;


public class TestStaffPage extends TestBase {

    /**
     * Test adds one employee and checks if it has been added
     *
     * @author Luka.Ivancic
     *
     * */
    @Test(priority = 0)
    public void testAddNewEmployee(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.logIn(Constants.EMAIL, Constants.PASSWORD);
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.clickStaffButton();
        StaffPage staffPage = new StaffPage(driver);
        staffPage.clickAddEmployeeButton();
        staffPage.addNewEmployee(Constants.EMPLOYEE1_FIRST_NAME, Constants.EMPLOYEE1_LAST_NAME, Constants.EMPLOYEE1_EMAIL);
        dashboardPage.clickStaffButton();
        Assert.assertTrue(staffPage.isEmployeeAdded(Constants.EMPLOYEE1), "Employee not added");;
    }

    /**
     * Test adds 3 employees and checks if they have been added
     *
     * @author Luka.Ivancic
     *
     * */
    @Test(priority = 1)
    public void testAddingMultipleEmployees(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.logIn(Constants.EMAIL, Constants.PASSWORD);
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.clickStaffButton();
        StaffPage staffPage = new StaffPage(driver);
        staffPage.clickAddEmployeeButton();
        staffPage.enterMultipleEmployees();
        staffPage.clickSaveEmployeeButton();
        dashboardPage.clickStaffButton();
        System.out.println(Arrays.toString(staffPage.allEmployeesList().toArray()));
        System.out.println(Arrays.toString(staffPage.addedEmployeesList().toArray()));
        Assert.assertTrue(staffPage.verifyMultipleEmployeesAdded(staffPage.allEmployeesList()), "Employees not added");

    }


}
