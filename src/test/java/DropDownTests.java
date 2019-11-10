import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

public class DropDownTests {

    WebDriver driver;

    @BeforeMethod
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/dropdown");

    }

    @Test
    public void checkboxesTest(){
        WebElement dropdownList = driver.findElement(By.id("dropdown"));
        Select dropdownOption = new Select(dropdownList);

        String selectedOption = dropdownOption.getFirstSelectedOption().getText();
        assertEquals(selectedOption, "Please select an option");

        dropdownOption.selectByValue("1");
        assertEquals(dropdownOption.getFirstSelectedOption().getText(), "Option 1");

        dropdownOption.selectByValue("2");
        assertEquals(dropdownOption.getFirstSelectedOption().getText(), "Option 2");

    }

    @AfterMethod
    public void afterTest(){
        driver.close();
        driver.quit();
    }
}
