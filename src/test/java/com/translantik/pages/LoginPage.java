package com.translantik.pages;

import com.translantik.utilities.ConfigurationReader;
import com.translantik.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class LoginPage extends BasePage {

    @FindBy(id = "prependedInput")
    public WebElement usernameInput;

    @FindBy(id = "prependedInput2")
    public WebElement passwordInput;

    @FindBy(id = "_submit")
    public WebElement loginBtn;

    @FindBy (css = ".btn.btn-primary")
    public List<WebElement> buttons;

    @FindBy (xpath = "//div[@class='alert alert-error']")
    public WebElement alertMessage;

    @FindBy (linkText = "Forgot your password?")
    public WebElement forgotPasswordLink;

    @FindBy (xpath = "//span[@class='custom-checkbox__icon']")
    public WebElement rememberCheckBox;

    @FindBy (xpath = "//span[@class='custom-checkbox__text']")
    public WebElement textOfRememberCheckBox;


    public void loginAsStoreManager(){
        String username= ConfigurationReader.get("store_manager_username");
        String password=ConfigurationReader.get("store_manager_password");

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }
}
