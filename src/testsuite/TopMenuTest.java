package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TopMenuTest extends BaseTest {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToComputerPageSuccessfully() {
        //Locating and clicking Computer tab on main page
        WebElement computerTab = driver.findElement(By.xpath("//a[@href='/computers']"));
        computerTab.click();
            // Validating "Computer" label
        String expectedMessage = "Computers";
        WebElement actualTextElement = driver.findElement(By.xpath("//h1[contains(text(),'Computers')]"));
        String actualMessage = actualTextElement.getText();
        //Cross-checking with automation
        Assert.assertEquals("User was not redirected to Computers page", expectedMessage, actualMessage);
    }

    @Test
    public void userShouldNavigateToElectronicsPageSuccessfully() {
        //Locating and clicking Electronics tab on main page
        WebElement electronicsTab = driver.findElement(By.xpath("//a[@href='/electronics']"));
        electronicsTab.click();
        // Validating "Electronics" label
        String expectedMessage = "Electronics";
        WebElement actualTextElement = driver.findElement(By.xpath("//h1[contains(text(),'Electronics')]"));
        String actualMessage = actualTextElement.getText();
        //Cross-checking with automation
        Assert.assertEquals("User was not redirected to Electronics page", expectedMessage, actualMessage);
    }

    @Test
    public void userShouldNavigateToApparelPageSuccessfully() {
        //Locating and clicking "Apparel" tab on main page
        WebElement apparelTab = driver.findElement(By.xpath("//a[@href='/apparel']"));
        apparelTab.click();
        // Validating "Apparel" label
        String expectedMessage = "Apparel";
        WebElement actualTextElement = driver.findElement(By.xpath("//h1[contains(text(),'Apparel')]"));
        String actualMessage = actualTextElement.getText();
        //Cross-checking with automation
        Assert.assertEquals("User was not redirected to Apparel page", expectedMessage, actualMessage);
    }

    @Test
    public void userShouldNavigateToDigitalDownloadsPageSuccessfully() {
        //Locating and clicking "Digital-downlaods" tab on main page

        WebElement digitalDownloadsTab = driver.findElement(By.xpath("//a[@href='/digital-downloads']"));
        digitalDownloadsTab.click();
        //Validating "Digital-download" label
        String expectedMessage = "Digital downloads";
        WebElement actualTextElement = driver.findElement(By.xpath("//h1[contains(text(),'Digital downloads')]"));
        String actualMessage = actualTextElement.getText();
        //Cross-checking with automation
        Assert.assertEquals("User was not redirected to Digital Downloads page", expectedMessage, actualMessage);
    }

    @Test
    public void userShouldNavigateToBooksPageSuccessfully() {
        WebElement booksTab = driver.findElement(By.xpath("//a[@href='/books']"));
        booksTab.click();

        String expectedMessage = "Books";
        WebElement actualTextElement = driver.findElement(By.xpath("//h1[contains(text(),'Books')]"));
        String actualMessage = actualTextElement.getText();
        //Cross-checking with automation
        Assert.assertEquals("User was not redirected to Books page", expectedMessage, actualMessage);
    }

    @Test
    public void userShouldNavigateToJewelryPageSuccessfully() {
        WebElement jewelryTab = driver.findElement(By.xpath("//a[@href='/jewelry']"));
        jewelryTab.click();

        String expectedMessage = "Jewelry";
        WebElement actualTextElement = driver.findElement(By.xpath("//h1[contains(text(),'Jewelry')]"));
        String actualMessage = actualTextElement.getText();
        //Cross-checking with automation
        Assert.assertEquals("User was not redirected to Jewelry page", expectedMessage, actualMessage);
    }

    @Test
    public void userShouldNavigateToGiftCardsPageSuccessfully() {
        WebElement giftCardsTab = driver.findElement(By.xpath("//a[@href='/gift-cards']"));
        giftCardsTab.click();

        String expectedMessage = "Gift Cards";
        WebElement actualTextElement = driver.findElement(By.xpath("//h1[contains(text(),'Gift Cards')]"));
        String actualMessage = actualTextElement.getText();
        //Cross-checking with automation
        Assert.assertEquals("User was not redirected to Gift Cards page", expectedMessage, actualMessage);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
