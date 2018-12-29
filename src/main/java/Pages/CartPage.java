package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    By sizeButtonBy= By.xpath( "//button[contains(@class, 'variant-picker-button')]");
    By sizeBy = By.cssSelector("#mCSB_1 li a");
    By cartBy =By.id("addToBasketButton");



    public CartPage(WebDriver driver){
        super(driver);

    }


    public void clickSizeButton(){

        waitForElementToBeClickable(sizeButtonBy);
        executeJavascript(clickScript,findElement(sizeButtonBy));

    }

    public void selectSize(){
        findElement(sizeBy).click();

    }
    public void clickAddCartButton(){

        findElement(cartBy).click();

    }


    public void addToCart(){

        clickSizeButton();
        selectSize();
        clickAddCartButton();


    }


}
