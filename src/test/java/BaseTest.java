import Pages.LoginPage;
import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import static io.github.bonigarcia.wdm.DriverManagerType.*;

public class BaseTest {

    String siteUrl = "https://www.trendyol.com/";
    WebDriver driver;
    DriverManagerType chrome = CHROME;
    DriverManagerType firefox = FIREFOX;
    DriverManagerType opera = OPERA;


    public void maximizeWindow(WebDriver driver) {

        driver.manage().window().maximize();
    }

    public void goToUrl(WebDriver driver, String url) {

        driver.get(url);
    }

    public void closePopup() {


        LoginPage loginPage = new LoginPage(driver);
        loginPage.closePopup();
    }

    public WebDriver chooseDriver(DriverManagerType browser) {

        if (browser.equals(chrome)) {

            WebDriverManager.getInstance(chrome).setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            driver = new ChromeDriver(options);

        } else if (browser.equals(firefox)) {
            WebDriverManager.getInstance(firefox).setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--disable-notifications");
            driver = new FirefoxDriver(options);


        } else if (browser.equals(opera)) {
            WebDriverManager.getInstance(opera).setup();
            OperaOptions options = new OperaOptions();
            options.addArguments("--disable-notifications");
            driver = new OperaDriver(options);


        }
        return driver;
    }

    @BeforeTest
    public void initializeDriver() {

        chooseDriver(chrome);
        maximizeWindow(driver);
        goToUrl(driver, siteUrl);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        closePopup();

    }
}


