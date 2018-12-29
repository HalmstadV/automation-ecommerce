package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginPage extends BasePage {

    By popupBy = By.xpath("//a[@href='javascript:;']");
    By loginButtonBy = By.className("login-container");
    By emailBy = By.id("email");
    By passwordBy = By.id("password");
    By clickLoginButtonBy = By.cssSelector(".submit-button-container");
    String userEmail = "random-defined-email";
    String userPassword = "random-defined-password";


    public LoginPage(WebDriver driver) {

        super(driver);

    }

    public void closePopup() {
        WebElement popup = findElement(popupBy);
        executeJavascript(clickScript, popup);
    }


    public void openLoginPage() {

        waitUntilVisibilityOfElementLocated(loginButtonBy);
        WebElement logButton = findElement(loginButtonBy);
        executeJavascript(clickScript, logButton);

    }

    public void typeEmail(By by) {
        write(emailBy, userEmail);

    }

    public void typePassword(By by) {

        write(passwordBy, userPassword);
    }

    public HomePage clickLoginButton(By by) {

        click(clickLoginButtonBy);

        return new HomePage(driver);

    }

    public HomePage Login() {
        openLoginPage();
        typeEmail(emailBy);
        typePassword(passwordBy);
        clickLoginButton(clickLoginButtonBy);
        waitUntilUrlContains("login");


        return new HomePage(driver);


    }


}

