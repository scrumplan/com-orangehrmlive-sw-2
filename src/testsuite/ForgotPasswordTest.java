package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordTest extends BaseTest {

    String baseUrl = "https://opensource-demo.orangehrmlive.com/";
    String expectedText = "Forgot Your Password?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToForgotPasswordPageSuccessfully() {
        //click on the ‘Forgot your password’ link , Verify the text ‘Forgot Your Password?’
        WebElement forgotPasswordLink = driver.findElement(By.linkText("Forgot your password?"));
        forgotPasswordLink.click();
        WebElement actualTextElement = driver.findElement(By.xpath("//h1[contains(text(),'Forgot Your Password?')]"));
        String actualText = actualTextElement.getText();
        Assert.assertEquals("Forgot password text not displayed", expectedText, actualText);


    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
