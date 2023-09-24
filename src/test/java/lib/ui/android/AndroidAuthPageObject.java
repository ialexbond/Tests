package lib.ui.android;

import lib.ui.AuthPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidAuthPageObject extends AuthPageObject {
    public AndroidAuthPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    static {
        LOGIN_FIELD = "xpath://*[contains(@text,'Логин')]";
        LOGIN_FILED_EDIT = "xpath://*[@resource-id='com.riesapp.debug:id/loginTextInput']//*[@resource-id='com.riesapp.debug:id/textFieldEditText']";
        PASSWORD_FIELD = "xpath://*[contains(@text,'Пароль')]";
        PASSWORD_FILED_EDIT = "xpath://*[@resource-id='com.riesapp.debug:id/passwordTextInput']//*[@resource-id='com.riesapp.debug:id/textFieldEditText']";
        LOGIN_BUTTON = "xpath://*[@resource-id='com.riesapp.debug:id/authButton']";
        SEARCH_BUTTON = "xpath://*[@resource-id='com.riesapp.debug:id/searchButton']";
    }
}
