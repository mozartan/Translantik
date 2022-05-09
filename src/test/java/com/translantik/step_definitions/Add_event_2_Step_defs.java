package com.translantik.step_definitions;

import com.github.javafaker.Faker;
import com.translantik.pages.AddEventPopUpPage;
import com.translantik.pages.GeneralInformationPage;
import com.translantik.pages.VehiclesPage;
import com.translantik.utilities.BrowserUtils;
import com.translantik.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Add_event_2_Step_defs {

AddEventPopUpPage addEventPopUpPage=new AddEventPopUpPage();
GeneralInformationPage generalInformationPage=new GeneralInformationPage();
Faker faker=new Faker();
String titleOfEvent=faker.company().name();

@Given("the user is on the add event pop up")
public void the_user_is_on_the_add_event_pop_up() {
    VehiclesPage vehiclesPage=new VehiclesPage();
    vehiclesPage.selectAnyRowOfAllCarsTable(2);
    BrowserUtils.waitFor(1);
    BrowserUtils.waitForClickablility(generalInformationPage.addEventButton,10);
    generalInformationPage.addEventButton.click();
    BrowserUtils.waitFor(1);
}

@Then("the user should be able to click on any color")
public void theUserShouldBeAbleToClickOnAnyColor() {
    boolean flag=true;

    for (int i = 0; i < addEventPopUpPage.colorBoxes.size(); i++) {

        addEventPopUpPage.colorBoxes.get(i).click();
        System.out.println(i + 1 + ". is box selected ");

        if (!addEventPopUpPage.afterClickColorBox.isDisplayed()) {
            flag = false;
            break;
        }
    }
    Assert.assertTrue(flag);
    addEventPopUpPage.closePopUp();
}

@When("the user click on All-day event")
public void theUserClickOnAllDayEvent() {
    BrowserUtils.waitForClickablility(addEventPopUpPage.allDayEventCheckBox,10);
    System.out.println("before click= " + addEventPopUpPage.allDayEventCheckBox.isSelected());
    BrowserUtils.waitFor(1);
    addEventPopUpPage.allDayEventCheckBox.click();
    BrowserUtils.waitFor(1);
    System.out.println("after click=" + addEventPopUpPage.allDayEventCheckBox.isSelected());
}

@Then("All-day event checkbox should be able to be selected")
public void allDayEventCheckboxShouldBeAbleToBeSelected() {
    System.out.println("allDayEventCheckBox.isSelected() = " + addEventPopUpPage.allDayEventCheckBox.isSelected());
    Assert.assertTrue(addEventPopUpPage.allDayEventCheckBox.isSelected());
    addEventPopUpPage.closePopUp();
}

@When("the user click on Repeat button")
public void theUserClickOnRepeatButton() {
    BrowserUtils.waitForClickablility(addEventPopUpPage.repeatCheckBox,10);
    System.out.println("before click Repeat button = " + addEventPopUpPage.repeatCheckBox.isSelected());
    addEventPopUpPage.repeatCheckBox.click();
    System.out.println("after click Repeat button = " + addEventPopUpPage.repeatCheckBox.isSelected());
    BrowserUtils.waitFor(1);
}

@Then("Repeat checkbox should be able to be selected")
public void repeatCheckboxShouldBeAbleToBeSelected() {
    Assert.assertTrue("repeat checkbox is not selected",addEventPopUpPage.repeatCheckBox.isSelected());
    addEventPopUpPage.closePopUp();
}

@Then("options should be able to same with below")
public void optionsShouldBeAbleToSameWithBelow(List<String> expectedOptions) {
    Select select= new Select(addEventPopUpPage.repeatDropDown);
    List<WebElement> actualOptions = select.getOptions();
    List<String> actualElementsText = BrowserUtils.getElementsText(actualOptions);

    System.out.println("expectedOptions = " + expectedOptions);
    System.out.println("actualElementsText = " + actualElementsText);

    Assert.assertEquals(expectedOptions,actualElementsText);
    addEventPopUpPage.closePopUp();
}

@Then("options which are below should be able to selectable")
public void optionsWhichAreBelowShouldBeAbleToSelectable(List<String> expectedOptions) {

    Select select= new Select(addEventPopUpPage.repeatDropDown);

    for (int i = 0; i < expectedOptions.size(); i++) {
         String expectedOption=expectedOptions.get(i);
        System.out.println("expectedOption = " + expectedOption);
        select.selectByIndex(i);

        String actualOption=select.getFirstSelectedOption().getText();

        System.out.println("actualOption = " + actualOption);
        Assert.assertEquals("not equal",expectedOption,actualOption);
        BrowserUtils.waitFor(1);
    }
    addEventPopUpPage.closePopUp();
}

@Then("Ending options' text should be to as below")
public void endingOptionsTextShouldBeToAsBelow(List<String> expectedOptions) {
    String actualNeverOption = addEventPopUpPage.neverButton.getText();
    System.out.println("actualNeverOption = " + actualNeverOption);
    System.out.println("expectedOptions.get(0) = " + expectedOptions.get(0));
    Assert.assertEquals("first option not equal",expectedOptions.get(0),actualNeverOption);

    String actualAfterOption = addEventPopUpPage.afterButton.getText();
    System.out.println("actualAfterOption = " + actualAfterOption);
    System.out.println("expectedOptions.get(1) = " + expectedOptions.get(1));
    Assert.assertEquals("second option not equal",expectedOptions.get(1),actualAfterOption);

    String actualByOption = addEventPopUpPage.byButton.getText();
    System.out.println("actualByOption = " + actualByOption);
    System.out.println("expectedOptions.get(2) = " + expectedOptions.get(2));
    Assert.assertEquals("third option not equal",expectedOptions.get(2),actualByOption);
    addEventPopUpPage.closePopUp();
}

@Then("following options should be able to clickable")
public void followingOptionsShouldBeAbleToClickable(List<String> expectedOptions) {

    for (String option : expectedOptions) {
        switch (option) {
            case "Never":
                System.out.println("default Never button = " + addEventPopUpPage.neverRadioButton.isSelected());
                addEventPopUpPage.afterRadioButton.click();
                System.out.println("after click any button, then Never button = " + addEventPopUpPage.neverRadioButton.isSelected());
                BrowserUtils.waitFor(1);
                Assert.assertFalse(addEventPopUpPage.neverRadioButton.isSelected());
                addEventPopUpPage.closePopUp();
                break;
            case "After":
                BrowserUtils.waitFor(1);
                generalInformationPage.addEventButton.click();
                BrowserUtils.waitFor(1);
                addEventPopUpPage.repeatCheckBox.click();
                BrowserUtils.waitFor(1);
                System.out.println("before click After button = " + addEventPopUpPage.afterRadioButton.isSelected());
                addEventPopUpPage.afterRadioButton.click();
                System.out.println("after click After button= " + addEventPopUpPage.afterRadioButton.isSelected());
                BrowserUtils.waitFor(1);
                Assert.assertTrue(addEventPopUpPage.afterRadioButton.isSelected());
                addEventPopUpPage.closePopUp();
                break;
            case "By":
                BrowserUtils.waitFor(1);
                generalInformationPage.addEventButton.click();
                BrowserUtils.waitFor(1);
                addEventPopUpPage.repeatCheckBox.click();
                System.out.println("before click By button = " + addEventPopUpPage.byRadioButton.isSelected());
                addEventPopUpPage.byRadioButton.click();
                System.out.println("after click By button = " + addEventPopUpPage.byRadioButton.isSelected());
                BrowserUtils.waitFor(1);
                Assert.assertTrue(addEventPopUpPage.byRadioButton.isSelected());
                addEventPopUpPage.closePopUp();
                break;
        }
    }
}

@When("the user enter compulsary fields and save")
public void theUserEnterCompulsaryFieldsAndSave() {
    BrowserUtils.waitFor(1);
    addEventPopUpPage.titleBox.sendKeys(titleOfEvent);
    System.out.println("title = " + titleOfEvent);
    BrowserUtils.waitFor(1);
    addEventPopUpPage.organizerNameBox.sendKeys(faker.name().fullName());
    BrowserUtils.waitFor(1);
    addEventPopUpPage.organizerEmailBox.sendKeys(faker.internet().emailAddress());
    BrowserUtils.waitFor(1);
    addEventPopUpPage.saveButton.click();
    BrowserUtils.waitFor(1);
}

@Then("the user should see the title of the event at the GeneralInformation page Activity part")
public void theUserShouldSeeTheTitleOfTheEventAtTheGeneralInformationPageActivityPart() throws InterruptedException {
    BrowserUtils.waitFor(1);
    List<String> textOfEvents = BrowserUtils.getElementsText(generalInformationPage.titlesOfEvents);
    BrowserUtils.waitFor(1);
    System.out.println("textOfEvents = " + textOfEvents);

    BrowserUtils.waitFor(1);
    JavascriptExecutor jse = (JavascriptExecutor)Driver.get();
    for (int i = 0; i <10; i++) {
        Thread.sleep(500);
        jse.executeScript("window.scrollBy(0,250)");
    }

    BrowserUtils.waitFor(1);
    for (String event : textOfEvents) {
        if (event.equals(titleOfEvent)){
            System.out.println("added event is = " + event);
            break;
        }
        Assert.assertEquals("title not same",titleOfEvent,event);
        System.out.println("Same title not found");
    }
}
}