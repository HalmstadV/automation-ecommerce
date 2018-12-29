package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class BasePage {

    String clickScript = "arguments[0].click();";
    String hoverScript = "var evObj = document.createEvent('MouseEvents');"
            + "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, "
            + "false, false, false, false, 0, null);"
            + "arguments[0].dispatchEvent(evObj);";

    public WebDriver driver;


    public BasePage(WebDriver driver) {

        this.driver = driver;

    }

    public void click(By by) {

        waitForElementToBeClickable(by);
        driver.findElement(by).click();

    }

    public void write(By by, String key) {
        waitUntilVisibilityOfElementLocated(by);

        driver.findElement(by).sendKeys(key);
    }


    public WebElement findElement(By by) {
        waitUntilVisibilityOfElementLocated(by);
        return driver.findElement(by);
    }

    public List<WebElement> findElements(By by) {
        waitUntilVisibilityOfElementLocated(by);
        return driver.findElements(by);

    }

    public void executeJavascript(String script, WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript(script, element);
    }


    public void executeJavascript(String script) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript(script);
    }

    public void waitUntilVisibilityOfElementLocated(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));

    }

    public void waitForElementToBeClickable(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(by));


    }

    public void waitUntilUrlContains(String string) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains(string));
    }

    public void waitUntilvisibilityOfAllElements(List<WebElement> elements) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }


    public void waitUntilPageIsLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState==\"complete\";"));
    }

    public String getElementAttribute(WebElement element, String name) {

        return element.getAttribute(name);


    }

    public String getUrl() {

        return driver.getCurrentUrl();
    }


    public void print(String message) {
        System.out.println(message);
    }


}


