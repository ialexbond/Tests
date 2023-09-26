package Tests;

import lib.CoreTestCase;
import lib.ui.AuthPageObject;
import lib.ui.ObjectPageObject;
import org.junit.jupiter.api.Test;

public class TemplatesTests extends CoreTestCase {
    private static final String
            login = "130522",
            password = "99679218Aa";
    @Test
    public void authTest() {
        AuthPageObject Auth = new AuthPageObject(driver);
        ObjectPageObject Object = new ObjectPageObject(driver);


        Auth.authStart(login, password);
        Object.clickMaterialWallsFilter();
        Object.clickBlocksMaterial("Дерево");
        Object.clickPanelsMaterial("Панели");
        Object.clickDone();
        Object.assertIfMaterialWallsSelected();
    }
}
