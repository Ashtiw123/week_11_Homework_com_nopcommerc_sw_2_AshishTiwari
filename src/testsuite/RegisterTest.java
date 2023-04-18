package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToRegisterPageSuccessfully() {
        //Locating register link and click on register link
        WebElement registerLink = driver.findElement(By.xpath("//a[contains(text(),'Register')]"));
        registerLink.click();
        String expectedMessage = "Register";
        WebElement actualTextElement = driver.findElement(By.xpath("//h1[contains(text(),'Register')]"));
        String actualMessage = actualTextElement.getText();
        //Cross-checking with automation
        Assert.assertEquals("Not redirected to Registration page", expectedMessage, actualMessage);
    }

    @Test
    public void userSholdRegisterAccountSuccessfully() {
        //Locating register link and click on register link
        
        WebElement registerLink = driver.findElement(By.xpath("//a[contains(text(),'Register')]"));
        registerLink.click();

        WebElement genderButton = driver.findElement(By.xpath("//input[@id='gender-male']"));
        genderButton.click();

        WebElement firstName = driver.findElement(By.xpath("//input[@id='FirstName']"));
        firstName.sendKeys("Hello");

        WebElement lastName = driver.findElement(By.xpath("//input[@id='LastName']"));
        lastName.sendKeys("There");

        WebElement emailField = driver.findElement(By.xpath("//input[@id='Email']"));
        emailField.sendKeys("hellothere1@gmail.com");

        Select drpDay = new Select(driver.findElement(By.name("DateOfBirthDay")));
        drpDay.selectByVisibleText("10");

        Select drpMonth = new Select(driver.findElement(By.name("DateOfBirthMonth")));
        drpMonth.selectByVisibleText("May");

        Select drpYear = new Select(driver.findElement(By.name("DateOfBirthYear")));
        drpYear.selectByVisibleText("1987");

        WebElement passwordField = driver.findElement(By.xpath("//input[@id='Password']"));
        passwordField.sendKeys("Hello1234");

        WebElement confirmPasswordField = driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
        confirmPasswordField.sendKeys("Hello1234");

        WebElement registerButton = driver.findElement(By.xpath("//button[@id='register-button']"));
        registerButton.click();


        String expectedMessage = "Your registration completed";
        WebElement actualMessageElement = driver.findElement(By.xpath("//div[contains(text(),'Your registration completed')]"));
        String actualMessage = actualMessageElement.getText();
        Assert.assertEquals("Registration was not completed successfully", expectedMessage, actualMessage);
    }


    @After
    public void tearDown() {
        closeBrowser();
    }
}
