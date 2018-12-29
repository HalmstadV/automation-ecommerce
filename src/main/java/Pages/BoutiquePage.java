package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BoutiquePage extends BasePage {

    By boutiquePageBy = By.className("butik-large-image");
    By pageEndBy = By.id("footer");
    By pageStartBy = By.id("root");
    By productImagesBy = By.cssSelector(".product img");
    By firstProductBy = By.className("product");
    List<WebElement> productImages;


    String scrollToEndScript = "var footer = document.getElementById('footer');\n" +
            "footer.scrollIntoView({block: \"end\", inline: \"end\",behavior: \"smooth\"});\n" +
            "\n" +
            "";
    String scrollToStartScript = "var footer = document.getElementById('root');\n" +
            "footer.scrollIntoView({block: \"end\", inline: \"end\",behavior: \"smooth\"});\n" +
            "\n" +
            "";


    public BoutiquePage(WebDriver driver) {
        super(driver);
    }


    public BoutiquePage goToFirstBoutique() {
        click(boutiquePageBy);
        waitUntilUrlContains("ButikDetay");
        return new BoutiquePage(driver);
    }


    public void scrollProducts() {

        executeJavascript(scrollToEndScript);


    }

    public void scrollBackProducts() {


        executeJavascript(scrollToStartScript);
    }


    public CartPage goToCart() {


        scrollBackProducts();
        WebElement product = findElement(firstProductBy);
        product.click();
        waitUntilPageIsLoaded();
        return new CartPage(driver);
    }


    public void printProductImageInfo() {

        goToFirstBoutique();
        scrollProducts();

        productImages = findElements(productImagesBy);

        for (WebElement image : productImages) {

            Dimension d = image.getSize();
            print(getElementAttribute(image, "src"));
            print("H: " + d.getHeight());
            print("W: " + d.getWidth());
            print("-------------------------------");
        }

        scrollBackProducts();

    }


}
