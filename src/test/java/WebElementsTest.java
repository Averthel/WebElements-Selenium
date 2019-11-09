
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class WebElementsTest {

    public WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://przyklady.javastart.pl/test/full_form.html");
    }

    @Test
    public void typingIntoWebElementTest() {
        WebElement userNameField = driver.findElement(By.id("username"));
        userNameField.sendKeys("Selenium Master");

        String typeUserNameValue = userNameField.getAttribute("value");
        assertEquals(typeUserNameValue, "Selenium Master");

        userNameField.clear();
        typeUserNameValue = userNameField.getAttribute("value");
        assertEquals(typeUserNameValue, "");

    }

    @Test
    public void filePickingTest() {
        WebElement uploadFilePicker = driver.findElement(By.id("upload_file"));
        uploadFilePicker.sendKeys("C:/Users/theco/OneDrive/Pulpit/github-square-social-media-512.png");

    }

    @Test
    public void checkRadioButtonTest() {
        WebElement maleRadioButton = driver.findElement(By.cssSelector("input[value='male']"));
        WebElement femaleRadioButton = driver.findElement(By.cssSelector("input[value='female']"));

        maleRadioButton.click();
        assertTrue(maleRadioButton.isSelected());

        femaleRadioButton.click();
        assertTrue(femaleRadioButton.isSelected());
        assertFalse(maleRadioButton.isSelected());
    }

    @Test
    public void checkboxButtonTest() {
        WebElement pizzaCheckbox = driver.findElement(By.cssSelector("input[value='pizza']"));
        WebElement spaghettiCheckbox = driver.findElement(By.cssSelector("input[value='spaghetti']"));
        WebElement hamburgerCheckbox = driver.findElement(By.cssSelector("input[value='hamburger']"));

        pizzaCheckbox.click();
        spaghettiCheckbox.click();
        hamburgerCheckbox.click();

        assertTrue(pizzaCheckbox.isSelected());
        assertTrue(spaghettiCheckbox.isSelected());
        assertTrue(hamburgerCheckbox.isSelected());

        pizzaCheckbox.click();
        spaghettiCheckbox.click();
        hamburgerCheckbox.click();

        assertFalse(pizzaCheckbox.isSelected());
        assertFalse(spaghettiCheckbox.isSelected());
        assertFalse(hamburgerCheckbox.isSelected());

    }

    @Test
    public void dropDownListingTest() {
        WebElement countryWebElement = driver.findElement(By.id("country"));
        Select countryDropDown = new Select(countryWebElement);

        List<WebElement> options = countryDropDown.getOptions();
        List<String> optionValues = new ArrayList<>();

        for (WebElement option : options) {
            optionValues.add(option.getText());
            System.out.println(option.getText());
        }

        List<String> expectedNamesOfOptions = new ArrayList<>();
        expectedNamesOfOptions.add("Germany");
        expectedNamesOfOptions.add("Poland");
        expectedNamesOfOptions.add("UK");

        assertEquals(optionValues, expectedNamesOfOptions);
    }

    @Test
    public void selectingOptionsFromDropDownTest() {
        WebElement countryWebElement = driver.findElement(By.id("country"));
        Select countryDropDown = new Select(countryWebElement);

        countryDropDown.selectByIndex(1);
        assertEquals(countryDropDown.getFirstSelectedOption().getText(), "Poland");

        countryDropDown.selectByValue("de_DE");
        assertEquals(countryDropDown.getFirstSelectedOption().getText(), "Germany");

        countryDropDown.selectByVisibleText("UK");
        assertEquals(countryDropDown.getFirstSelectedOption().getText(), "UK");
    }

    @Test
    public void checkIfElementsOnPageTest() {
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement emailLabel = driver.findElement(By.cssSelector("span[class='help-block']"));

        System.out.println("Is usernameField displayed: " + usernameField.isDisplayed());
        System.out.println("Is usernameField enabled: " + usernameField.isEnabled());

        System.out.println("Is passwordField displayed: " + passwordField.isDisplayed());
        System.out.println("Is passwordField enabled: " + passwordField.isEnabled());

        System.out.println("Is emailLabel displayed: " + emailLabel.isDisplayed());
        System.out.println("Is emailLabel enabled: " + emailLabel.isEnabled());

        assertTrue(usernameField.isDisplayed());
        assertTrue(passwordField.isDisplayed());
        assertTrue(emailLabel.isDisplayed());

        assertTrue(usernameField.isEnabled());
        assertFalse(passwordField.isEnabled());
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }

}