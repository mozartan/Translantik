package com.translantik.step_definitions;

import com.translantik.pages.BasePage;
import com.translantik.pages.Filters;
import com.translantik.pages.VehiclesPage;
import com.translantik.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.tr.Ve;
import org.junit.Assert;
import org.openqa.selenium.WebElement;


public class FilterMenuStepDefs extends BasePage {

    Filters filters = new Filters();
    int flag;

    @Then("filter button is hidden")
    public void filter_button_is_hidden() {
        Assert.assertFalse(filters.manageFiltersButton.isDisplayed());
    }

    @When("the user clicks on filter button")
    public void theUserClicksOnFilterButton() {
        BrowserUtils.waitForClickablility(filters.filtersButton,10);
        filters.filtersButton.click();
    }

    @Then("manage filter button is visible")
    public void manageFilterButtonIsVisible() {
        Assert.assertTrue(filters.manageFiltersButton.isDisplayed());
    }

    @When("the user clicks on manage filter button")
    public void theUserClicksOnManageFilterButton() {
        filters.manageFiltersButton.click();
    }

    @Then("all names under manage filters menu are clickable")
    public void allNamesUnderManageFiltersMenuAreClickable() {
        for (WebElement filterType : filters.filterNames) {
            Assert.assertTrue(filters.isClickable(filterType));
        }
    }

    @Then("user enters filter name on the filter input box and corresponding name is displayed")
    public void userEntersFilterNameOnTheFilterInputBoxAndCorrespondingNameIsDisplayed() {

        for (WebElement filterType : filters.filterNames) {
            String name = filterType.getAttribute("title");
            filters.filterInputBox.sendKeys(name);
            BrowserUtils.waitFor(1);
            Assert.assertTrue(filters.filterName(name).isDisplayed());
            filters.filterInputBox.clear();
        }
    }

    @And("the user clicks {int} filters")
    public void theUserClicksFilters(int num) {
        flag = num;
        for (int i = 0; i < num; i++) {
            String name = filters.filterNames.get(i).getAttribute("title");
            filters.filterName(name).click();
            BrowserUtils.waitFor(1);
        }
    }

    @Then("filtered names are displayed on the filter menu place")
    public void filteredNamesAreDisplayedOnTheFilterMenuPlace() {
        Assert.assertEquals(flag, filters.filteredMenusLocations.size());
    }

    @And("the user clicks reset button")
    public void theUserClicksResetButton() {
        filters.resetButton.click();
        BrowserUtils.waitFor(1);
    }

    @Then("all filters are gone")
    public void allFiltersAreGone() {
        for (int i = 0; i < flag; i++) {
            Assert.assertFalse(filters.filteredMenusLocations.get(i).isDisplayed());
        }
    }
}
