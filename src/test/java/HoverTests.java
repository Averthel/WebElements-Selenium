import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.junit.Assert.*;

public class HoverTests {

    WebDriver driver;

    @BeforeMethod
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/hovers");

    }

    @Test
    public void hoverTest(){
        WebElement firstAvatar = driver.findElement(By.xpath("//*[@id='content']/div/div[1]/img"));
        WebElement secondAvatar =  driver.findElement(By.xpath("//*[@id='content']/div/div[2]/img"));
        WebElement thirdAvatar =  driver.findElement(By.xpath("//*[@id='content']/div/div[3]/img"));

        Actions action = new Actions(driver);

        action.moveToElement(firstAvatar).perform();

        WebElement firstAvatarSignature = driver.findElement(By.xpath("//div/div[1]/div/h5"));
        WebElement secondAvatarSignature = driver.findElement(By.xpath("//div/div[2]/div/h5"));
        WebElement thirdAvatarSignature = driver.findElement(By.xpath("//div/div[3]/div/h5"));

        assertTrue(firstAvatarSignature.isDisplayed());
        assertFalse(secondAvatarSignature.isDisplayed());
        assertFalse(thirdAvatarSignature.isDisplayed());
        assertEquals(firstAvatarSignature.getText(), "name: user1");
        assertEquals(secondAvatarSignature.getText(), "");
        assertEquals(thirdAvatarSignature.getText(), "");

        action.moveToElement(secondAvatar).perform();

        assertFalse(firstAvatarSignature.isDisplayed());
        assertTrue(secondAvatarSignature.isDisplayed());
        assertFalse(thirdAvatarSignature.isDisplayed());
        assertEquals(firstAvatarSignature.getText(), "");
        assertEquals(secondAvatarSignature.getText(), "name: user2");
        assertEquals(thirdAvatarSignature.getText(), "");

        action.moveToElement(thirdAvatar).perform();

        assertFalse(firstAvatarSignature.isDisplayed());
        assertFalse(secondAvatarSignature.isDisplayed());
        assertTrue(thirdAvatarSignature.isDisplayed());
        assertEquals(firstAvatarSignature.getText(), "");
        assertEquals(secondAvatarSignature.getText(), "");
        assertEquals(thirdAvatarSignature.getText(), "name: user3");

    }


    @AfterMethod
    public void afterTest(){
        driver.close();
        driver.quit();
    }
}
