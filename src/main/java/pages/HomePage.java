package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;



public class HomePage {
    private WebDriver driver;
    private By navToLoginButton = By.id("nav-link-accountList");
    private By HamMenuButton = By.id("nav-hamburger-menu");
    private By seeAllButton = By.xpath("//a[@class=\"hmenu-item hmenu-compressed-btn\"]");
    private By videoGamesButton = By.xpath("//a[@data-menu-id=\"16\"]");
    private By allVideoGamesButton = By.xpath("//a[text()=\"All Video Games\"]");



    public HomePage(WebDriver driver){
        this.driver = driver;}

    public LoginPage navToLogin(){
        driver.findElement(navToLoginButton).click();
        return new LoginPage(driver);
    }

    public void clickHamMenuButton(){
        driver.findElement(HamMenuButton).click();

    }

    public void clickSeeAllButton(){
        driver.findElement(seeAllButton).click();
    }

    public void moveToVideoGames(){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(videoGamesButton)).perform();
    }

    public void clickVideoGameButton(){
        driver.findElement(videoGamesButton).click();
    }
    public VideoGamesPage clickAllVideoGamesButton(){
        driver.findElement(allVideoGamesButton).click();
        return new VideoGamesPage(driver);
    }

}
