package base;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import utils.WindowManager;

import java.util.List;

public class VideoGameTests extends BaseTests{
    @Test
    public void addToCartTest() {

        loggedUserHomePage.clickHamMenuButton();
        loggedUserHomePage.clickSeeAllButton();
        loggedUserHomePage.moveToVideoGames();
        loggedUserHomePage.clickVideoGameButton();
        var videoGamePage = loggedUserHomePage.clickAllVideoGamesButton();
        videoGamePage.checkFreeShipping();
        videoGamePage.clickNewButton();
        videoGamePage.clickDropDown();
        videoGamePage.clickHighToLowOption();
        List<WebElement> prices = videoGamePage.getDesiredProducts();
        videoGamePage.openDesiredProductsInNewTap(prices);
        videoGamePage.openTaps(prices);


    }

}
