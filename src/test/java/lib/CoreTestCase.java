package lib;

import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CoreTestCase {

    protected RemoteWebDriver driver;

    @BeforeEach
    @Step("Run driver and session")
    public void setUp() throws Exception {
        driver = Platform.getInstance().getDriver();
    }

    @AfterEach
    @Step("Run Remove and session")
    public void tearDown() {
        driver.quit();
    }
}
