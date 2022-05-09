package com.translantik.step_definitions;

import com.translantik.pages.GeneralInformationPage;
import com.translantik.pages.LoginPage;
import com.translantik.pages.VehiclesPage;
import com.translantik.utilities.BrowserUtils;
import com.translantik.utilities.ConfigurationReader;
import com.translantik.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class DeleteCarStepDefinitions {

    VehiclesPage vehiclesPage = new VehiclesPage();
    GeneralInformationPage genInfoPage = new GeneralInformationPage();
    String deletedCarValue;
    String recordsBeforeDelete;
    String recordsAfterDelete;

    @When("the user hovers over the three dots of row whose {string} equals {string}")
    public void theUserHoversOverTheThreeDotsOfRowWhoseEquals(String columnName, String value) {
        recordsBeforeDelete = vehiclesPage.getTotalRecords();
        vehiclesPage.selectPerPage(100);
        vehiclesPage.waitUntilLoaderScreenDisappear();
        vehiclesPage.goThreeDot(columnName,value);
    }

    @Then("the user should be able to see the delete button")
    public void theUserShouldBeAbleToSeeTheDeleteButton() {
        Assert.assertTrue("the delete button is NOT displayed",vehiclesPage.deleteButton.isDisplayed());
    }

    @And("the user clicks on the delete button")
    public void theUserClicksOnTheDeleteButton() {
        vehiclesPage.deleteButton.click();
        BrowserUtils.waitForVisibility(vehiclesPage.deleteConfirmation,3);
    }

    @Then("The Delete Confirmation pop up should be displayed")
    public void theDeleteConfirmationPopUpShouldBeDisplayed() {
        Assert.assertTrue("Delete Confirmation pop up is NOT displayed ",vehiclesPage.deleteConfirmation.isDisplayed());
    }

    @And("the user clicks on the -Yes,Delete- confirmation button")
    public void theUserClicksOnTheYesDeleteConfirmationButton() {
        BrowserUtils.waitForVisibility(vehiclesPage.deleteConfirmation,5);
        vehiclesPage.yesDeleteButton.click();
        vehiclesPage.waitUntilLoaderScreenDisappear();
        recordsAfterDelete = vehiclesPage.getTotalRecords();
    }

    @Then("the user should delete the car and {string} message should be displayed")
    public void theUserShouldDeleteTheCarAndMessageShouldBeDisplayed(String expectedMessage) {
        vehiclesPage.waitUntilLoaderScreenDisappear();
        String actualMessage = vehiclesPage.itemDeletedMessage.getText();
        Assert.assertEquals("Message is NOT as expected",expectedMessage,actualMessage);
        Assert.assertNotEquals("Records are SAME", recordsBeforeDelete,recordsAfterDelete);
    }

    @When("the user clicks on a row whose {string} equals {string}")
    public void theUserClicksOnARowWhoseEquals(String columnName, String value) {
        deletedCarValue = value;
        vehiclesPage.selectPerPage(100);
        vehiclesPage.waitUntilLoaderScreenDisappear();
        vehiclesPage.selectRowWithAny(columnName,value).click();
    }

    @And("the user clicks on the delete button and Yes,Delete confirmation button on the General Information page")
    public void theUserClicksOnTheDeleteButtonAndYesDeleteConfirmationButtonOnTheGeneralInformationPage() {
        BrowserUtils.waitForClickablility(genInfoPage.deleteButton,10);
        genInfoPage.deleteButton.click();
        BrowserUtils.waitFor(1);
        genInfoPage.yesDeleteButton.click();
        genInfoPage.waitUntilLoaderScreenDisappear();
    }

    @Then("the car is deleted and the {string} message should be displayed")
    public void theCarIsDeletedAndTheMessageShouldBeDisplayed(String expectedMessage) {
        String actualMessage = genInfoPage.carDeletedMessage.getText();
        Assert.assertEquals("Message is NOT as expected",expectedMessage,actualMessage);
    }

    @Then("the car can not be found in the car list")
    public void theCarCanNotBeFoundInTheCarList() {
        recordsAfterDelete = vehiclesPage.getTotalRecords();
        vehiclesPage.selectPerPage(100);
        String pageSource = Driver.get().getPageSource();
        Assert.assertNotEquals("Records are SAME",recordsBeforeDelete,recordsAfterDelete);
        Assert.assertFalse(pageSource.contains(deletedCarValue));
    }
}
