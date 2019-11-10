import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUntil {

    private WebDriverWait webDriverWait;

    public WaitUntil(WebDriver driver) {
        webDriverWait = new WebDriverWait(driver, 10);
    }

    public void isInvisibility(WebElement webElement ){
        webDriverWait.until(ExpectedConditions.invisibilityOf(webElement));
    }

    public WebElement visibilityOfElementLocated(By by){
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }


}
