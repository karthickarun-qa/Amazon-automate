package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestException;

public  abstract class CommonUtils {
    public static WebDriver driver;
    public WebDriverWait wait;
    public Actions actions;

    public CommonUtils() {
        driver = DriverUtils.getDriver();
    }

    public WebElement getElement(By selector) {
        try {
            return driver.findElement(selector);
        } catch (Exception e) {
            System.out.println(String.format("Element %s does not exist - proceeding", selector));
        }
        return null;
    }

    public void navigateToURL(String URL) {
        try {
            driver.navigate().to(URL);
        } catch (Exception e) {
            System.out.println("FAILURE: URL did not load: " + URL);
            throw new TestException("URL did not load");
        }
    }

    public void click(By selector) {
        WebElement element = getElement(selector);
        actions = new Actions(driver);
        try {
            actions.moveToElement(element).click().perform();
        } catch (Exception e) {
            throw new TestException(String.format("The following element is not clickable: [%s]", selector));
        }
    }


    public void sendKeys(By selector, String value) {
        WebElement element = getElement(selector);
        try {
            element.sendKeys(value);
        } catch (Exception e) {
            throw new TestException(String.format("Error in sending [%s] to the following element: [%s]", value, selector.toString()));
        }
    }

    public void scrollToThenClick(By selector) {
        WebElement element = driver.findElement(selector);
        actions = new Actions(driver);
        try {
            actions.moveToElement(element).click().perform();

        } catch (Exception e) {
            throw new TestException(String.format("The following element is not clickable: [%s]", element.toString()));
        }
    }


    public void submit(By selector){
        WebElement element = getElement(selector);
        element.submit();
    }
}
