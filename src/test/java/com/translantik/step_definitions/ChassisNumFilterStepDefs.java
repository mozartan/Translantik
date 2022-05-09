package com.translantik.step_definitions;

import com.translantik.pages.VehiclesPage;
import com.translantik.utilities.BrowserUtils;
import com.translantik.utilities.ConfigurationReader;
import com.translantik.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ChassisNumFilterStepDefs {

    VehiclesPage vehiclesPage = new VehiclesPage();

    @When("the user clicks on Chassis Number checkbox")
    public void the_user_clicks_on_Chassis_Number_checkbox() {
        BrowserUtils.waitForClickablility(vehiclesPage.chassisNumberBox, 10);
        vehiclesPage.chassisNumberBox.click();
        BrowserUtils.waitFor(2);
    }

    @Then("the Chassis Number checkbox should be selected")
    public void theChassisNumberCheckboxShouldBeSelected() {
        Assert.assertTrue(vehiclesPage.chassisNumberBox.isSelected());
    }

    @And("the user clicks on Chassis Number All button")
    public void theUserClicksOnChassisNumberAllButton() {
        BrowserUtils.waitForClickablility(vehiclesPage.chassisNumberAllButton, 10);
        vehiclesPage.chassisNumberAllButton.click();
        BrowserUtils.waitFor(1);
    }

    @And("the user clicks on dropdown menu")
    public void theUserClicksOnDropdownMenu() {
        BrowserUtils.waitFor(3);
        vehiclesPage.chassisDropdownMenu.click();
        System.out.println("clicked on the chassisDropdownMenu button ");
        BrowserUtils.waitFor(2);
    }

    @Then("Chassis Number filter should provide the methods shown as below")
    public void chassisNumberFilterShouldProvideTheMethodsShownAsBelow(List<String> menuOptions) throws Throwable {
        BrowserUtils.waitFor(3);
//        List<String> actualChassisOptions = BrowserUtils.getElementsText(new VehiclesPage().chassisDDMenuOpts);
        List<String> actualChassisOptions = BrowserUtils.getElementsText(new VehiclesPage().chassisDDMenuOpts);

        System.out.println("actualChassisOptions = " + actualChassisOptions);
        System.out.println("actualChassisOptions.size() = " + actualChassisOptions.size());
        System.out.println("actualChassisOptions.get(1) = " + actualChassisOptions.get(1));
        System.out.println("menuOptions = " + menuOptions);

        Assert.assertEquals(null, menuOptions, actualChassisOptions);
    }

    @And("the user clicks More Than button")
    public void theUserClicksMoreThanButton() {
        vehiclesPage.moreThanButton.click();
    }

    @And("enter numeric values")
    public void enterNumericValues() {
        vehiclesPage.inputBox.sendKeys(ConfigurationReader.get("requestedChassisNumber"));
        BrowserUtils.waitFor(1);
    }

    @And("click update button")
    public void clickUpdateButton() {
        vehiclesPage.updateButton.click();
        BrowserUtils.waitFor(2);
    }

    @Then("the results should be more than specified value")
    public void theResultsShouldBeMoreThanSpecifiedValue() {
        List<String> chassisNumResList = new ArrayList<>();

        int i = 1;
        String lastPageStr;
        int lastPageAsNum;

        do {
            if (i == 1) {
                chassisNumResList = BrowserUtils.getElementsText(vehiclesPage.chassisNumResults);
            } else if (i > 1) {
                BrowserUtils.waitFor(3);
                vehiclesPage.forwardPageArrow.click();

                BrowserUtils.waitFor(3);
                List<String> chassisNumResList_Temp = BrowserUtils.getElementsText(vehiclesPage.chassisNumResults);

                chassisNumResList.addAll(chassisNumResList_Temp);
            }
             i++;

            lastPageStr = vehiclesPage.lastPageNum.getText().split(" ")[1];
            lastPageAsNum = Integer.parseInt(lastPageStr);

        } while (i <= lastPageAsNum);

        List<String> result = new ArrayList<>();
        for (String s : chassisNumResList) {
            result.add(s.replaceAll(",", ""));
        }

        //Below line and for loop converts result List<String> to chassisNumAsNum List<Integer>
        List<Integer> chassisNumAsNum = new ArrayList<>();
        for (String str : result) {
            chassisNumAsNum.add(Integer.parseInt(str));
        }

        System.out.println("chassisNumAsNum.size() = " + chassisNumAsNum.size());
        System.out.println("chassisNumAsNum = " + chassisNumAsNum);

        int userEnteredValue = Integer.parseInt(ConfigurationReader.get("requestedChassisNumber"));
        boolean flag = true;
        for (Integer integer : chassisNumAsNum) {
            if (integer <= userEnteredValue) {
                flag = false;
                break;
            }
        }
        Assert.assertTrue(flag);
    }

    @And("the user clicks on Less Than button")
    public void theUserClicksOnLessThanButton() {
        vehiclesPage.lessThanButton.click();
    }

    @Then("the results should be less than specified value")
    public void theResultsShouldBeLessThanSpecifiedValue() {
        List<String> chassisNumResList = new ArrayList<>();

        int i = 1;
        String lastPageStr;
        int lastPageAsNum;

        do {
            if (i == 1) {
                chassisNumResList = BrowserUtils.getElementsText(vehiclesPage.chassisNumResults);
            } else if (i > 1) {
                BrowserUtils.waitFor(3);
                vehiclesPage.forwardPageArrow.click();

                BrowserUtils.waitFor(3);
                List<String> chassisNumResList_Temp = BrowserUtils.getElementsText(vehiclesPage.chassisNumResults);

                chassisNumResList.addAll(chassisNumResList_Temp);
            }
            i++;

            lastPageStr = vehiclesPage.lastPageNum.getText().split(" ")[1];
            lastPageAsNum = Integer.parseInt(lastPageStr);

        } while (i <= lastPageAsNum);

        List<String> result = new ArrayList<>();
        for (String s : chassisNumResList) {
            result.add(s.replaceAll(",", ""));
        }

        //Below line and for loop converts result List<String> to chassisNumAsNum List<Integer>
        List<Integer> chassisNumAsNum = new ArrayList<>();
        for (String str : result) {
            chassisNumAsNum.add(Integer.parseInt(str));
        }

        System.out.println("chassisNumAsNum.size() = " + chassisNumAsNum.size());
        System.out.println("chassisNumAsNum = " + chassisNumAsNum);

        int userEnteredValue = Integer.parseInt(ConfigurationReader.get("requestedChassisNumber"));
        boolean flag = true;
        for (Integer integer : chassisNumAsNum) {
            if (integer >= userEnteredValue) {
                flag = false;
                break;
            }
        }
        Assert.assertTrue(flag);
    }

    @Then("only empty values should be displayed")
    public void onlyEmptyValuesShouldBeDisplayed() {
        boolean flag = true;
        if(vehiclesPage.isClickable(vehiclesPage.noDataInformer)){
            System.out.println("There is no data with empty chassis field");
        } else {flag = false;}
        Assert.assertTrue(flag);
    }

    @And("the user clicks on chassis number column headline button")
    public void theUserClicksOnChassisNumberColumnHeadlineButton() {
        vehiclesPage.chassisNumTableHead.click();
        BrowserUtils.waitFor(3);
    }
}
