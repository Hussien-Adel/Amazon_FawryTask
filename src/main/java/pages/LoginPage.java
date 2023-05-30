package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By emailField = By.id("ap_email");
    private By passwordField = By.id("ap_password");
    private By continueButton = By.id("continue");
    private By loginButton = By.id("signInSubmit");
    public LoginPage(WebDriver driver){
        this.driver = driver;}

    public void setUserName(String username){
        driver.findElement(emailField).sendKeys(username);
    }
    public void setPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickContinueButton(){
        driver.findElement(continueButton).click();

    }
    public HomePage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new HomePage(driver);
    }
}
