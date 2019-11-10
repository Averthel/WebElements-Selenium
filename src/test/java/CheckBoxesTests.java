
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CheckBoxesTests {

    WebDriver driver;

    @BeforeMethod
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/checkboxes");

    }


    @Test
    public void checkboxesTest(){
      WebElement checkbox1 =  driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
      WebElement checkbox2 =  driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));

      assertFalse(checkbox1.isSelected());
      assertTrue(checkbox2.isSelected());

      checkbox1.click();
      checkbox2.click();

        assertTrue(checkbox1.isSelected());
        assertFalse(checkbox2.isSelected());

    }

    @AfterMethod
    public void afterTest(){
        driver.close();
        driver.quit();
    }


}
