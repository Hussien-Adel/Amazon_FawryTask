package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.WindowManager;

import java.util.List;

public class ProductDetailsPage {
    private WebDriver driver;
    private By addToCartButton = By.xpath("//input[@value=\"Add to Cart\"]");
    private By productTitle = By.id("productTitle");

    public ProductDetailsPage(WebDriver driver){
        this.driver = driver;}

    public void clickAddToCart(){
        driver.findElement(addToCartButton).click();
    }
    public void addDesiredProductsToCart(List<WebElement> products){

        for (WebElement product : products) {

            getWindowManager().switchToTab(product.getText());

        }
    }
    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }




}
