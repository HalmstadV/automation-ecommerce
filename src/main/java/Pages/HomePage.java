package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;


public class HomePage extends BasePage {


    By loggedOnEmail = By.xpath("//div[contains(text(), 'pikdokenaral@gmail.com')]");
    By categoriesBy = By.xpath("//li[contains(@id,'item')]");
    By categoryImagesBy = By.xpath("//div[@id='main-menu']//img");
    By boutiqueCategory = By.xpath("//a[contains(@href,'/Butik/Liste')]");
    By loggedInPanelBy = By.className("login-container");


    public HomePage(WebDriver driver) {
        super(driver);

    }



    public void printBannerImageInfo(List<WebElement> Images) {


        for (WebElement image : Images) {

            Dimension d = image.getSize();
            print(getElementAttribute(image, "src"));
            print("H: " + d.getHeight());
            print("W: " + d.getWidth());
            print("-------------------------------");

        }

    }


    public void printBannerImageInfo() {


        List<WebElement> Categories = findElements(categoriesBy);
        waitUntilvisibilityOfAllElements(Categories);

        for (WebElement category : Categories) {
            executeJavascript(hoverScript, category);
        }
        List<WebElement> Images = findElements(categoryImagesBy);


        printBannerImageInfo(Images);

    }


    public BoutiquePage goToBoutiqueList() {
        waitUntilVisibilityOfElementLocated(boutiqueCategory);
        executeJavascript(clickScript, findElement(boutiqueCategory));
        waitUntilUrlContains("Butik/Liste");
        return new BoutiquePage(driver);
    }

    public String getUserEmail(WebDriver driver) {


        Actions action = new Actions(driver);
        WebElement loginPanel = findElement(loggedInPanelBy);
        action.moveToElement(loginPanel).build().perform();

        String userEmail = findElement(loggedOnEmail).getText();
        return userEmail;

    }


}
