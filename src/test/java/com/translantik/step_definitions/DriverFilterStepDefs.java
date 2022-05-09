package com.translantik.step_definitions;

import com.translantik.pages.BasePage;
import com.translantik.pages.Filters;
import com.translantik.pages.VehiclesPage;
import com.translantik.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Locale;

public class DriverFilterStepDefs extends BasePage {
    Filters filters = new Filters();
    VehiclesPage vehiclesPage = new VehiclesPage();

    @When("the user clicks on {string} filter under Fleet-Vehicles module")
    public void the_user_clicks_on_filter_under_module(String filterName) {

        BrowserUtils.waitForClickablility(filters.filtersButton, 10);

        filters.filtersButton.click();
        filters.manageFiltersButton.click();

        vehiclesPage.waitUntilLoaderScreenDisappear();
        filters.filterName(filterName).click();
    }

    @When("the user clicks on {string} filter")
    public void theUserClicksOnFilter(String filterName) {
        vehiclesPage.waitUntilLoaderScreenDisappear();
        filters.filterName(filterName).click();

    }

    @Then("the {string} filter should be selected")
    public void theFilterShouldBeSelected(String filterName) {
        BrowserUtils.waitFor(3);
        Assert.assertTrue(filters.filterName(filterName).isSelected());
    }

    @When("the user clicks on {string} button")
    public void the_user_clicks_on_button(String criteriaAll) {
        BrowserUtils.waitFor(3);
        vehiclesPage.filterCriteriaSelector.click();
    }


    @When("the user clicks on default dropdown of the {string} filter which is {string} dropdown")
    public void the_user_clicks_on_default_dropdown_of_the_filter_which_is_dropdown(String string, String defaultMethodOfTheFilter) {
        vehiclesPage.waitUntilLoaderScreenDisappear();
        vehiclesPage.defaultMethodOfTheFilter(defaultMethodOfTheFilter.toLowerCase()).click();
    }

    @Given("the user clicks on {string} dropdown")
    public void the_user_clicks_on_dropdown(String subMethodName) {
        vehiclesPage.waitUntilLoaderScreenDisappear();
        vehiclesPage.subMethodsOfTheFilter(subMethodName.toLowerCase()).click();
    }

    @Then("the Methods should be seen as below")
    public void the_Methods_should_be_seen_as_below(List<String> methodNames) {
        BrowserUtils.waitFor(1);
        List<String> actualMethods = BrowserUtils.getElementsText(vehiclesPage.methods);
        Assert.assertEquals(methodNames, actualMethods);
    }

    @When("the user writes the {string} keyword to {string} method input box and click update button")
    public void the_user_writes_the_keyword_to_method_input_box_and_click_update_button(String keyword, String method) {
        vehiclesPage.waitUntilLoaderScreenDisappear();
        vehiclesPage.filterInputbox.sendKeys(keyword);
        BrowserUtils.waitFor(1);
        vehiclesPage.filterUpdateButton.click();
        /*vehiclesPage.viewPerPageButton.click();
        vehiclesPage.selectPerPage(100);*/


    }

    @Then("the results should contain the {string} keyword")
    public void the_results_should_contain_the_keyword(String keyword) {
        BrowserUtils.waitFor(2);
       List<String> columnText = BrowserUtils.getElementsText(vehiclesPage.columnText);
        //List<String> columnText = BrowserUtils.getElementsText(vehiclesPage.filterColumnNames(subMethod));

        for (String s : columnText) {
            Assert.assertTrue(s.toLowerCase().contains(keyword.toLowerCase()));

        }

    }

    @Then("the results should not contain the {string} keyword")
    public void the_results_should_not_contain_the_keyword(String keyword, String subMethod) {
        BrowserUtils.waitFor(2);
        List<String> columnText = BrowserUtils.getElementsText(vehiclesPage.columnText3(subMethod));

        for (String s : columnText) {
            Assert.assertFalse(s.toLowerCase().contains(keyword.toLowerCase()));

        }
    }

    @Then("the results should start with the {string} keyword")
    public void the_results_should_start_with_the_keyword(String keyword) {
        BrowserUtils.waitFor(2);
        List<String> columnText = BrowserUtils.getElementsText(vehiclesPage.columnText);

        System.out.println("columnText = " + columnText);

        for (String s : columnText) {
            Assert.assertTrue(s.toLowerCase().startsWith(keyword.toLowerCase()));
            {
            }
        }
    }

    @Then("the results should end with the {string} keyword")
    public void the_results_should_end_with_the_keyword(String keyword) {
        BrowserUtils.waitFor(2);
        List<String> columnText = BrowserUtils.getElementsText(vehiclesPage.columnText);

        System.out.println("columnText = " + columnText);

        for (String s : columnText) {
            Assert.assertTrue(s.toLowerCase().endsWith(keyword.toLowerCase()));

        }
    }

    /*@Then("the results should not contain the {string} keyword {string}")
    public void theResultsShouldNotContainTheKeyword(String keyword, String subMethod) {

        BrowserUtils.waitFor(2);
        List<String> columnText = BrowserUtils.getElementsText(vehiclesPage.columnText3(subMethod));

        for (String s : columnText) {
            Assert.assertFalse(s.toLowerCase().contains(keyword.toLowerCase()));
            {
            }
        }
    }/*


     */
    @Then("the results should not contain the {string} keyword {string}")
    public void theResultsShouldNotContainTheKeyword(String keyword, String subMethod) {
    BrowserUtils.waitFor(2);
    List<String> columnText = BrowserUtils.getElementsText(vehiclesPage.columnText3(subMethod));

        System.out.println("columnText = " + columnText);

        for (String s : columnText) {
        Assert.assertTrue(s.equals(keyword));

    }

}
    }

