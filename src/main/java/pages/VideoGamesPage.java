package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.WindowManager;

import java.util.ArrayList;
import java.util.List;

public class VideoGamesPage {
    private WebDriver driver;
    private By freeShippingCheckbox = By.xpath("//a[contains(@href,\"shipping\") and @tabindex ]");
    private By newButton = By.xpath("//span[@data-csa-c-content-id=\"p_n_condition-type/28071525031\"]");
    private By dropDownButton = By.id("a-autoid-0-announce");
    private By highToLowOption = By.id("s-result-sort-select_2");

    private By productPrices = By.xpath("//a[@class=\"a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal\"]//ancestor::div[@class=\"a-section a-spacing-small a-spacing-top-small\"]//span[@class=\"a-price-whole\" ]");


    public VideoGamesPage(WebDriver driver){
        this.driver = driver;}


    public void checkFreeShipping(){
        driver.findElement(freeShippingCheckbox).click();

    }

    public void clickNewButton(){
        driver.findElement(newButton).click();

    }
    public void clickDropDown() {
        driver.findElement(dropDownButton).click();
    }

    public void clickHighToLowOption() {
        driver.findElement(highToLowOption).click();
    }

    public List<String> getProductPrices() {
        List<WebElement> prices = driver.findElements(productPrices);
        List<String> pricesList=new ArrayList<>();
        for (WebElement element : prices) {
            pricesList.add(element.getText());
        }
        return pricesList;
    }
    public List<WebElement> getDesiredProducts() {
        List<String> prices = getProductPrices();
        List<String> desiredPrices = new ArrayList<>();
        List<WebElement> desiredProducts = new ArrayList<>();
        for (String element : prices) {
            if (Integer.parseInt(element.replace(",","")) <= 15000)
            {
                desiredPrices.add(element);
            }
            System.out.println(desiredPrices);
        }
        for (String price : desiredPrices) {
            String xpathLocator = String.format("//span[@class=\"a-price-whole\" and text()=\"%s\"]//ancestor::div[@class=\"a-section a-spacing-small a-spacing-top-small\"]//a[@class=\"a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal\"]//span ", price);
            WebElement product = driver.findElement(By.xpath(xpathLocator));
            System.out.println(product.getText());
            desiredProducts.add(product);
        }

        return desiredProducts;
    }


    public void openDesiredProductsInNewTap(List<WebElement> products){

        for (WebElement product : products) {

            Actions actions = new Actions(driver);
            actions.keyDown(Keys.CONTROL)
                    .click(product)
                    .build().perform();
            //getWindowManager().switchToTab(product.getText());

        }
    }

    public void openTaps(List<WebElement> products){

        for (WebElement product : products) {

            getWindowManager().switchToTab(product.getText());
            driver.findElement(By.xpath("//input[@value=\"Add to Cart\"]")).click();
        }

    }


    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }



}
