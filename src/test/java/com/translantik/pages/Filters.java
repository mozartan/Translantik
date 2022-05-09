package com.translantik.pages;

import com.translantik.utilities.BrowserUtils;
import com.translantik.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Filters extends BasePage {

    @FindBy(xpath = "//i[@class='fa-filter hide-text']")
    public WebElement filtersButton;

    @FindBy(className = "add-filter-button")
    public WebElement manageFiltersButton;

    @FindBy(xpath = "//input[@type='search']")
    public WebElement filterInputBox;

    @FindBy(xpath = "//a[@title='Reset']/i")
    public WebElement resetButton;

    @FindBys({@FindBy(name = "multiselect_0")})
    public List<WebElement> filterNames;

    @FindBys({@FindBy(xpath = "//div[@class='btn filter-criteria-selector oro-drop-opener oro-dropdown-toggle filter-default-value']")})
    public List<WebElement> filteredMenusLocations;

    @FindBy(id = "s2id_autogen2")
    public WebElement chooseValuesBox;

    @FindBy(xpath = "(//div[@class='select2-result-label'])[1]")
    public WebElement compact;

    @FindBy(css = "button[class='btn btn-primary filter-update']")
    public WebElement updateButton;

    @FindBy(xpath = "//td[@data-column-label='Tags']//li")
    public List<WebElement> listOfTagsColumn;

    @FindBy(xpath = "//a[normalize-space()='is not any of']")
    public WebElement isNotAnyOf;

    @FindBy(xpath = "//li[@class='select2-results-dept-0 select2-result select2-result-selectable'][.='Sedan']")
    public WebElement sedan;

    public WebElement filterName(String name) {
        return Driver.get().findElement(By.xpath("//span[contains(text(),'" + name + "')]/../input"));
    }

    public WebElement filterNames(String name) {
        return Driver.get().findElement(By.xpath("//input[@value='" + name + "']"));
    }


    public boolean isClickable(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.get(), 5);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean hasCompactOrSedan(List<WebElement> elements) {
        List<String> elementsText = BrowserUtils.getElementsText(elements);
        for (String each : elementsText) {
            if(each.equals("Compact")||each.equals("Sedan")){
                return false;
            }
        }
        return true;
    }





}
