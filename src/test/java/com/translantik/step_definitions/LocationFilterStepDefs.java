package com.translantik.step_definitions;

import com.translantik.pages.VehiclesPage;
import com.translantik.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class LocationFilterStepDefs {
    VehiclesPage vehiclesPage = new VehiclesPage();


    @Then("the {string} column results should not contain the {string} keyword")
    public void theColumnResultsShouldNotContainTheKeyword(String subMethod, String keyword) {

        BrowserUtils.waitFor(2);
        List<String> columnText = BrowserUtils.getElementsText(vehiclesPage.filterColumnNames(subMethod));

        for (String s : columnText) {
            Assert.assertFalse(s.toLowerCase().contains(keyword.toLowerCase()));

        }
    }

    @Then("the {string} column results should start with the {string} keyword")
    public void theColumnResultsShouldStartWithTheKeyword(String subMethod, String keyword) {

        BrowserUtils.waitFor(2);
        List<String> columnText = BrowserUtils.getElementsText(vehiclesPage.filterColumnNames(subMethod));

        System.out.println("columnText = " + columnText);

        for (String s : columnText) {
            Assert.assertTrue(s.toLowerCase().startsWith(keyword.toLowerCase()));

        }
    }

    @Then("the {string} column results should end with the {string} keyword")
    public void theColumnResultsShouldEndWithTheKeyword(String subMethod, String keyword) {
        BrowserUtils.waitFor(2);
        List<String> columnText = BrowserUtils.getElementsText(vehiclesPage.filterColumnNames(subMethod));

        System.out.println("columnText = " + columnText);

        for (String s : columnText) {
            Assert.assertTrue(s.toLowerCase().endsWith(keyword.toLowerCase()));

        }
    }

    @Then("the {string} column results should display {string} keyword")
    public void theColumnResultsShouldDisplayKeyword(String subMethod, String keyword) {
        BrowserUtils.waitFor(2);
        List<String> columnText = BrowserUtils.getElementsText(vehiclesPage.filterColumnNames(subMethod));

        System.out.println("columnText = " + columnText);

        for (String s : columnText) {
            Assert.assertTrue(s.toLowerCase().equals(keyword.toLowerCase()));

            }

        }

    @Then("the {string} column results should contain the {string} keyword")
    public void theColumnresultsShouldContainTheKeyword(String subMethod, String keyword) {

        BrowserUtils.waitFor(2);
        List<String> columnText = BrowserUtils.getElementsText(vehiclesPage.filterColumnNames(subMethod));

        for (String s : columnText) {
            Assert.assertTrue(s.toLowerCase().contains(keyword.toLowerCase()));

        }

    }
}

