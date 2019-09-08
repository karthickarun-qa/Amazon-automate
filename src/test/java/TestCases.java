import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utils.DriverUtils;
import static org.testng.Assert.assertEquals;

public class TestCases extends DriverUtils {
    public String number_of_items_in_cart="2";
    public WebDriver driver;
    AmazonPage ap=null;

    @Test
    public void test_amazonAddBestSellerProducts(){
        ap =new AmazonPage();
        ap.navigateToAmazonPage();
        ap.seachBox();
        ap.selectHeadPhones1();
        ap.clickAddToCart();
        ap.seachBox();
        ap.selectHeadPhones2();
        ap.clickAddToCart();
        ap.getCartItemsCount();
        assertEquals(ap.getCartItemsCount(),number_of_items_in_cart,"Total item in shopping cart: 2");
    }
}
