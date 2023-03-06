import com.motivitylabs.Automation.LumaBasePage;
import com.motivitylabs.DataManager.ReadingDatafromJson;
import com.motivitylabs.Pages.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class LumaTest extends LumaBasePage {
    HomePage homePage;
    SignInPage signInPage;
    WelcomePage welcomePage;
    PLPPages plpPages;
    WishListPage wishListPage;
    CheckoutPage checkoutPage;
    ReadingDatafromJson reader;
    SoftAssert softAssert;

    @BeforeClass
    public void initializePages() {
        reader = new ReadingDatafromJson();
        homePage = new HomePage(driver);
        signInPage = new SignInPage(driver);
        reader = new ReadingDatafromJson();
        welcomePage = new WelcomePage(driver);
        plpPages = new PLPPages(driver);
        wishListPage = new WishListPage(driver);
        checkoutPage = new CheckoutPage(driver);
        softAssert = new SoftAssert();


    }

    @Test
    public void VerifySignIn() throws InterruptedException, FileNotFoundException {

        homePage.clickOnSignIn();

        signInPage.signIn(reader.ReadingData("email"), reader.ReadingData("password"));
        welcomePage.goingtoPLP();
        String expectedText = reader.ReadingData("text");
        String actualText = plpPages.checkingTheCart();
        softAssert.assertEquals(expectedText, actualText);
        plpPages.gettingHighestPriceItem();
        String productTitle = plpPages.gettingName();
        String productTitle1 = wishListPage.getProductName();
        softAssert.assertEquals(productTitle, productTitle1);
        wishListPage.addingToCart();
        String expectedMessage = reader.ReadingData("text");
        String actualMessage = wishListPage.messageInWishlist();
        softAssert.assertEquals(expectedMessage, actualMessage);
        wishListPage.proceedToCheckOut();
        checkoutPage.shippingAddress(reader.ReadingData("street"), reader.ReadingData("city"), reader.ReadingData("state"), reader.ReadingData("zipcode"), reader.ReadingData("mobile"));
        String actualAddress = checkoutPage.gettingAddress();
        String expectedAddress = reader.ReadingData("text");
        softAssert.assertEquals(actualAddress, expectedAddress);
        checkoutPage.placingOrder();
        Boolean status = checkoutPage.verifyingOrderNumber();
        softAssert.assertTrue(status);
        ArrayList actualList = checkoutPage.clickOnOrderNUmber();
        ArrayList<String> expectedArryList = new ArrayList<>();
        expectedArryList.add(reader.ReadingData("currentDate"));
        expectedArryList.add(reader.ReadingData("price"));
        softAssert.assertEquals(actualList, expectedArryList);

    }
}
