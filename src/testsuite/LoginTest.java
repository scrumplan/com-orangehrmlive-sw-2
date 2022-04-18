package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseUrl = "https://opensource-demo.orangehrmlive.com/";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void verifyUserShouldLoginSuccessfullyWithValidCredentials(){

        String expectedMessage= "Welcome mahesh";

        //enter username
        WebElement userNameField = driver.findElement(By.id("txtUsername"));
        userNameField.sendKeys("Admin");

        //enter password
        WebElement passwordField = driver.findElement(By.name("txtPassword"));
        passwordField.sendKeys("admin123");

        //click on login button
        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        loginButton.click();

        //Verify the ‘Welcome mahesh’ text is display
        WebElement actualMessageElement = driver.findElement(By.xpath("//a[@id='welcome']"));
        String actualMessage = actualMessageElement.getText();
        Assert.assertEquals("Welcome message not displayed",expectedMessage,actualMessage);

    }
    @After
    public  void tearDown(){
        closeBrowser();
    }




}
