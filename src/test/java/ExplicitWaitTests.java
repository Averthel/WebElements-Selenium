import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.junit.Assert.*;

public class ExplicitWaitTests {

    private WebDriver driver;
    private WaitUntil waitUntil;


    @BeforeMethod
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        waitUntil = new WaitUntil(driver);
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/dynamic_controls");
    }

    @Test
    public void waitForDisappearingElement(){
        WebElement checkbox = driver.findElement(By.cssSelector("input[id='checkbox']"));

        assertFalse(checkbox.isSelected());
        assertTrue(checkbox.isDisplayed());

        WebElement removeButton = driver.findElement(By.id("btn"));
        removeButton.click();

        waitUntil.isInvisibility(checkbox);
        WebElement messageLabel = waitUntil.visibilityOfElementLocated(By.id("message"));

        assertEquals(messageLabel.getText(), "It's gone!");
    }

    @Test
    public void waitForPresenceOfTheElement(){
        WebElement checkbox = driver.findElement(By.cssSelector("input[id='checkbox']"));

        assertFalse(checkbox.isSelected());
        assertTrue(checkbox.isDisplayed());

        WebElement removeOrAddButton = driver.findElement(By.id("btn"));
        removeOrAddButton.click();

        waitUntil.isInvisibility(checkbox);
        WebElement messageLabel = waitUntil.visibilityOfElementLocated(By.id("message"));

        assertEquals(messageLabel.getText(), "It's gone!");

        removeOrAddButton.click();

        checkbox = waitUntil.visibilityOfElementLocated(By.cssSelector("input[id='checkbox']"));

        assertFalse(checkbox.isSelected());
        assertTrue(checkbox.isDisplayed());


    }

    @AfterMethod
    public void afterTest(){
        driver.close();
        driver.quit();
    }
}
