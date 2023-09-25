package lib.ui;

import org.openqa.selenium.remote.RemoteWebDriver;

public class AuthPageObject extends MainPageObject {
    public AuthPageObject(RemoteWebDriver driver) {
        super(driver);
    }
    protected static String
        LOGIN_FIELD = "xpath://*[contains(@text,'Логин')]",
        LOGIN_FILED_EDIT = "xpath://*[@resource-id='com.riesapp.debug:id/loginTextInput']//*[@resource-id='com.riesapp.debug:id/textFieldEditText']",
        PASSWORD_FIELD = "xpath://*[contains(@text,'Пароль')]",
        PASSWORD_FILED_EDIT = "xpath://*[@resource-id='com.riesapp.debug:id/passwordTextInput']//*[@resource-id='com.riesapp.debug:id/textFieldEditText']",
        LOGIN_BUTTON = "xpath://*[@resource-id='com.riesapp.debug:id/authButton']",
        SEARCH_BUTTON = "xpath://*[@resource-id='com.riesapp.debug:id/searchButton']";


    public void waitForLoginField(){
        this.waitForElementPresent(LOGIN_FIELD, "Cannot see the login field", 7);
    }

    public void fillingLogin(String login){
        this.waitForElementAndClick(LOGIN_FIELD, "The login field was not clicked", 5);
        this.waitForElementAndSendKeys(LOGIN_FILED_EDIT, login, "No login was entered in the login field", 5);
    }

    public void fillingPassword(String password){
        this.waitForElementAndClick(PASSWORD_FIELD, "The password field was not clicked", 5);
        this.waitForElementAndSendKeys(PASSWORD_FILED_EDIT, password, "No password was entered in the password field", 5);
    }

    public void pressLoginButton(){
        this.waitForElementPresent(LOGIN_BUTTON, "Cannot see the login button", 5);
        this.waitForElementAndClick(LOGIN_BUTTON, "The login button has not been clicked", 5);
    }

    public void assertIfObjectTab(){
        this.waitForElementPresent(SEARCH_BUTTON, "Cannot see the search button", 5);
        this.assertElementIsPresent(SEARCH_BUTTON, "The search button was not found");
    }

}

