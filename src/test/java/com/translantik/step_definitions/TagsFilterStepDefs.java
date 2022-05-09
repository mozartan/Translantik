package com.translantik.step_definitions;

import com.translantik.pages.BasePage;
import com.translantik.pages.Filters;
import com.translantik.pages.VehiclesPage;
import com.translantik.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class TagsFilterStepDefs extends BasePage {
    Filters filters = new Filters();

    @When("the user selects Is any Of method with Compact option")
    public void the_user_selects_Is_any_Of_method_with_Compact_option() {

        filters.chooseValuesBox.click();
        BrowserUtils.waitFor(1);
        filters.compact.click();
        filters.updateButton.click();

    }

    @Then("the table should include corresponding value")
    public void the_table_should_include_corresponding_value() {

        new VehiclesPage().selectPerPage(100);
        filters.waitUntilLoaderScreenDisappear();
        String expectedResult = "Compact";
        for (WebElement each : filters.listOfTagsColumn) {

            Assert.assertEquals(expectedResult, each.getText());

        }

    }

    @When("the user selects Is  not any Of method with Compact option")
    public void the_user_selects_Is_not_any_Of_method_with_Compact_option() {
        BrowserUtils.waitFor(2);
        filters.isNotAnyOf.click();
        filters.chooseValuesBox.click();
        filters.compact.click();
        filters.updateButton.click();
        filters.waitUntilLoaderScreenDisappear();

    }

    @Then("the table shouldn't include corresponding value")
    public void the_table_shouldn_t_include_corresponding_value() {
        new VehiclesPage().selectPerPage(100);
        filters.waitUntilLoaderScreenDisappear();
        String expectedResult = "Compact";
        for (WebElement each : filters.listOfTagsColumn) {

            Assert.assertNotEquals(expectedResult, each.getText());
        }
    }

    @And("the user selects Is  not any Of method with Compact option and Sedan option")
    public void theUserSelectsIsNotAnyOfMethodWithCompactOptionandSedanOption() {
        BrowserUtils.waitFor(2);
        filters.isNotAnyOf.click();
        filters.chooseValuesBox.click();
        filters.compact.click();
        filters.chooseValuesBox.click();
        BrowserUtils.waitFor(1);
        filters.sedan.click();
        BrowserUtils.waitFor(3);
        filters.updateButton.click();
        filters.waitUntilLoaderScreenDisappear();

    }

    @Then("the table should not include corresponding value")
    public void the_table_should_not_include_corresponding_value() {
        new VehiclesPage().selectPerPage(100);
        filters.waitUntilLoaderScreenDisappear();
        Assert.assertTrue(filters.hasCompactOrSedan(filters.listOfTagsColumn));


    }
}
