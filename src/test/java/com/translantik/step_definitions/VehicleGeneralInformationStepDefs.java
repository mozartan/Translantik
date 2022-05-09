package com.translantik.step_definitions;

import com.translantik.pages.GeneralInformationPage;
import com.translantik.pages.VehiclesPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


import java.util.List;

public class VehicleGeneralInformationStepDefs {

    @When("^the store manager clicks (\\d+) .row")
    public void theStoreManagerClicksRowNumberRow(int rowNumber) {
        new VehiclesPage().selectAnyRowOfAllCarsTable(rowNumber);
    }

    @Then("the General Information page should be displayed")
    public void theGeneralInformationPageShouldBeDisplayed() {
        String actualTitle = new GeneralInformationPage().pageTitle.getText();
        Assert.assertEquals("General Information Page Title", "General Information", actualTitle);
    }

    @Then("the store manager clicks any three dot at the end of the row")
    public void theStoreManagerClicksAnyThreeDotAtTheEndOfTheRow() {
        new VehiclesPage().goThreeDot("ChassisNumber", "264,783");
    }

    @When("the store manager clicks on the Eye {string} icon")
    public void theStoreManagerClicksOnTheEyeIcon(String iconName) {
        new VehiclesPage().getThreeDotIcon(iconName).click();
    }

    @Then("Edit, Delete, and Add Event button should be displayed")
    public void editDeleteAndAddEventButtonShouldBeDisplayed() {
        Assert.assertTrue("Edit Button", new GeneralInformationPage().editButton.isDisplayed());
        Assert.assertTrue("Delete Button", new GeneralInformationPage().deleteButton.isDisplayed());
        Assert.assertTrue("Add Event Button", new GeneralInformationPage().addEventButton.isDisplayed());
    }

    List<String> allInfoOfVehiclePage;

    @Then("^check and store all information of (\\d+) .row")
    public void checkAndStoreAllInformationOfRowNumberRow(int rowNumber) {
        allInfoOfVehiclePage = new VehiclesPage().getAllInfoOfRow(rowNumber);
    }

    @Then("verify the all information are all same for both pages")
    public void verifyTheAllInformationAreAllSameForBothPages() {
        List<String> allInfoOfGeneralInformationPage = new GeneralInformationPage().getAllInfo();
        System.out.println("allInfoOfVehiclePage = " + allInfoOfVehiclePage);
        System.out.println("allInfoOfGeneralInformationPage = " + allInfoOfGeneralInformationPage);
        Assert.assertEquals("Compare All Info of 2 Pages", allInfoOfVehiclePage, allInfoOfGeneralInformationPage);
    }
}
