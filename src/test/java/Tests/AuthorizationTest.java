package Tests;

import lib.CoreTestCase;
import lib.ui.AuthPageObject;
import org.junit.jupiter.api.Test;

public class AuthorizationTest extends CoreTestCase {

    private static final String
    login = "130522",
    password = "99679218Aa";
    @Test
    public void authTest() {
        AuthPageObject Auth = new AuthPageObject(driver);

        Auth.waitForLoginField();
        Auth.fillingLogin(login);
        Auth.fillingPassword(password);
        Auth.pressLoginButton();
        Auth.assertIfObjectTab();
    }
}
