package pages;

import enums.Url;
import org.openqa.selenium.By;
import utils.CommonUtils;

public class AmazonPage extends CommonUtils {
    private final By searchBox=By.id("twotabsearchtextbox");
    private final By submit=By.id("nav-search-submit-text");
    private final By noiseCancellingHeadphones=By.xpath("//span[contains(text(),'COWIN E7 Active Noise Cancelling Headphones Blueto')]");
    private final By kidsHeadphone=By.xpath("//span[contains(text(),'Kids Headphones - noot products K11 Foldable Stere')]");
    private final By CART_BUTTON=By.cssSelector("#add-to-cart-button");
    private final By CART_COUNT=By.id("nav-cart-count");


    public void navigateToAmazonPage(){
        String url = Url.BASEURL.getURL();
        navigateToURL(url);
    }

    public void clickCartButton() {
        click(CART_BUTTON);
    }

    public void seachBox(){
        sendKeys(searchBox,"headphones");
        submit(submit);
    }

    public void selectHeadPhones1(){
        scrollToThenClick(noiseCancellingHeadphones);
    }

    public void selectHeadPhones2(){
        scrollToThenClick(kidsHeadphone);
    }

    public void clickAddToCart(){
        click(CART_BUTTON);
    }

    public String getCartItemsCount(){
        String count=getElement(CART_COUNT).getText();
        return count;
    }

}
