package com.translantik.step_definitions;

import com.translantik.pages.AddEventPopUpPage;
import com.translantik.pages.GeneralInformationPage;
import com.translantik.pages.VehiclesPage;
import com.translantik.utilities.BrowserUtils;
import com.translantik.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Add_event_1_Step_defs {

    @When("Store manager click on any vehicle")
    public void store_manager_click_on_any_vehicle() {
        VehiclesPage vehiclesPage = new VehiclesPage();
        BrowserUtils.waitFor(3);
        vehiclesPage.selectAnyRowOfAllCarsTable(2);
    }

    @When("Store manager will see {string} page")
    public void store_manager_will_see_page(String expectedPage) {
        BrowserUtils.waitFor(5);
        GeneralInformationPage generalinform1 = new GeneralInformationPage();
        String actualPage = generalinform1.pageTitle.getText();
        Assert.assertEquals("Verified that :", expectedPage, actualPage);

    }

    @Then("Store manager can see addEvent button")
    public void store_manager_can_see_addEvent_button() {
        BrowserUtils.waitFor(2);
        AddEventPopUpPage addEventPopUpPage = new AddEventPopUpPage();
        Assert.assertTrue(addEventPopUpPage.addEventButton.getSize().getWidth()!=0);
        System.out.println("true = " + true);

    }

    @Then("Store manager can click on addEvent button")
    public void store_manager_can_click_on_addEvent_button() {
        BrowserUtils.waitFor(4);
        AddEventPopUpPage addEventPopUpPage = new AddEventPopUpPage();
        addEventPopUpPage.addEventButton.click();
        BrowserUtils.waitForPageToLoad(4);
    }

    @Then("{string} Page opens")
    public void pageOpens(String expectedTitle) throws InterruptedException {

        BrowserUtils.waitFor(4);
        AddEventPopUpPage addEventPopUpPage = new AddEventPopUpPage();
        String actualTitle = Driver.get().findElement(By.xpath("//span[text()='Add Event']")).getText();
        System.out.println("actualTitle = " + actualTitle);
        Assert.assertEquals("Verify that :", expectedTitle, actualTitle);
        Thread.sleep(10);
        addEventPopUpPage.closePopUp();
    }

    @Then("Compulsory Fields must be shown")
    public void compulsory_Fields_must_be_shown(List<String> expectedField) {
        BrowserUtils.waitFor(10);
        List<WebElement> actualElements = Driver.get().findElements(By.xpath("//em[text()='*']/.."));
        List<String> elementsText = BrowserUtils.getElementsText(actualElements);
        System.out.println("elementsText = " + elementsText);
        List<String> afterManipulation=new ArrayList<>();
        for (String str : elementsText) {
            String text=str.substring(0,str.indexOf("*"));
            afterManipulation.add(text);
        }
        System.out.println("expectedText = " + expectedField);
        System.out.println("afterManipulation = " + afterManipulation);
        Assert.assertEquals(expectedField,afterManipulation);
        AddEventPopUpPage addEventPopUpPage = new AddEventPopUpPage();
        addEventPopUpPage.closePopUp();

    }

    @Then("Store manager should not save event without filling out compulsory {string}")
    public void store_manager_should_not_save_event_without_filling_out_compulsory (String input1) {
        AddEventPopUpPage addEventPopUpPage = new AddEventPopUpPage();
        System.out.println(addEventPopUpPage.sendWithOnlyOneInput(input1));

    }
    @Then("Store manager should not save event without filling out compulsory {string} , {string}, {string}")
    public void store_manager_should_not_save_event_without_filling_out_compulsory(String title, String organizerName, String organizerEmail) throws InterruptedException {
        AddEventPopUpPage addEventPopUpPage = new AddEventPopUpPage();
        addEventPopUpPage.titleBox.sendKeys(title);
        BrowserUtils.waitFor(1);
        addEventPopUpPage.organizerNameBox.sendKeys(organizerName);
        BrowserUtils.waitFor(1);
        addEventPopUpPage.organizerEmailBox.sendKeys(organizerEmail);
        BrowserUtils.waitFor(1);
        addEventPopUpPage.saveButton.click();
        BrowserUtils.waitFor(1);
        Assert.assertFalse(addEventPopUpPage.calendarEventSaved.isDisplayed());

    }

    @Then("{string} message should be displayed")
    public void message_should_be_displayed(String expectedBlankMessage) throws InterruptedException {
        AddEventPopUpPage addEventPopUpPage = new AddEventPopUpPage();
        String actualBlankMessage = addEventPopUpPage.titleBox.getAttribute("validationMessage");
        Assert.assertEquals("Verified that :",expectedBlankMessage,actualBlankMessage);
        System.out.println("actualBlankMessage = " + actualBlankMessage);
        System.out.println("expectedBlankMessage = " + expectedBlankMessage);
        Thread.sleep(2);
        addEventPopUpPage.closePopUp();
   }
}


