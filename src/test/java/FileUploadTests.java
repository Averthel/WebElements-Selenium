import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

public class FileUploadTests {

    WebDriver driver;

    @BeforeMethod
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/upload");

    }

    @Test
    public void fileUploadTest(){
        WebElement uploadedFile = driver.findElement(By.id("file-upload"));
        uploadedFile.sendKeys("C:/Users/theco/OneDrive/Pulpit/github-square-social-media-512.png");

        WebElement uploadButton = driver.findElement(By.id("file-submit"));
        uploadButton.click();

        WebElement fileName = driver.findElement(By.id("uploaded-files"));
        String myFile = fileName.getText();

        assertEquals(myFile, "github-square-social-media-512.png");

    }

    @AfterMethod
    public void afterTest(){
        driver.close();
        driver.quit();
    }
}
