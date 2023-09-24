package lib;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class CoreTestCase extends Platform{

    @Test
    public void goTest () throws InterruptedException {
        Thread.sleep(7000);
        WebElement loginField = driver.findElement(By.xpath("//*[contains(@text,'Логин')]"));
        loginField.click();
        WebElement loginFieldEdit = driver.findElement(By.xpath("//*[@resource-id='com.riesapp.debug:id/loginTextInput']//*[@resource-id='com.riesapp.debug:id/textFieldEditText']"));
        loginFieldEdit.sendKeys("18858");
        WebElement passwordField = driver.findElement(By.xpath("//*[contains(@text,'Пароль')]"));
        passwordField.click();
        WebElement passwordFieldEdit = driver.findElement(By.xpath("//*[@resource-id='com.riesapp.debug:id/passwordTextInput']//*[@resource-id='com.riesapp.debug:id/textFieldEditText']"));
        passwordFieldEdit.sendKeys("Test20232");
        WebElement buttonAuth = driver.findElement(By.id("com.riesapp.debug:id/authButton"));
        buttonAuth.click();
        Thread.sleep(1000);
    }
}
