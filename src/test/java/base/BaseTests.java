package base;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import pages.HomePage;

import java.time.Duration;
import java.util.List;


public class BaseTests {
    private WebDriver driver ;
    protected HomePage homePage;
    protected HomePage loggedUserHomePage;
    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver(getChromeOption());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        goHome();
        homePage = new HomePage(driver);
        loggedUserHomePage = login();
    }
    private ChromeOptions getChromeOption(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        //options.setHeadless(true);
        return options;
    }
    @BeforeMethod
    public void goHome(){
        driver.get("https://www.amazon.eg/");
    }


    public HomePage login(){
        var loginPage = homePage.navToLogin();
        loginPage.setUserName("hussiens7s.lm10@gmail.com");
        loginPage.clickContinueButton();
        loginPage.setPassword("Leoshsmessi100");
        return loginPage.clickLoginButton();
    }


//    @AfterClass
//    public void tearDown(){
//        driver.quit();
//    }



}
