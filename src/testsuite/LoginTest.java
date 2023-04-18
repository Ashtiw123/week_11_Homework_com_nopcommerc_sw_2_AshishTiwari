package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        //Locating login link and click on login link
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();
        String expectedMessage = "Welcome, Please Sign In!";
        WebElement actualTextElement = driver.findElement(By.xpath("//div[@class='page-title']"));
        String actualMessage = actualTextElement.getText();
        //Cross-checking with automation
        Assert.assertEquals("Not redirected to login", expectedMessage, actualMessage);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();

        WebElement userName = driver.findElement(By.xpath("//input[@id='Email']"));
        userName.sendKeys("AT1@Gmail.com");

        WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
        password.sendKeys("Hello1");

        WebElement login = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
        login.click();

        String expectedMessage = "Log out";
        WebElement actualMessageElement = driver.findElement(By.xpath("//a[contains(text(),'Log out')]"));
        String actualMessage = actualMessageElement.getText();
        Assert.assertEquals("Logout text is not matching", expectedMessage, actualMessage);
    }

    @Test
    public void verifyTheErrorMessage() {
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();

        WebElement userName = driver.findElement(By.xpath("//input[@id='Email']"));
        userName.sendKeys("AT@Gmail.com");

        WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
        password.sendKeys("Hello");

        WebElement login = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
        login.click();

        String expectedMessage = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";
        WebElement actualMessageElement = driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']"));
        String actualMessage = actualMessageElement.getText();
        Assert.assertEquals("Logout error text does not appear", expectedMessage, actualMessage);
    }


    @After
    public void tearDown() {
        closeBrowser();
    }
}