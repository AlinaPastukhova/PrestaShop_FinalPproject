import blocks.ProductBlock;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;

public class Case7_PriceDropCheckTest extends BaseTest {

  @Test
  public void checkPriceDropTest() {

    MainPage mainPage = new MainPage();
    SoftAssertions softAssertions = new SoftAssertions();

    List<ProductBlock> allProductsFromPriceDropPage = mainPage
        .openMainPage()
        .clickPriceDropLink()
        .getAllProductsFromPriceDropPage();

    // Check that every product has old price
    List<Double> oldPriceOfProductsFromPriceDropPage = mainPage
        .openMainPage()
        .clickPriceDropLink()
        .getOldPriceOfProductsFromPriceDropPage(allProductsFromPriceDropPage);

    softAssertions.assertThat(oldPriceOfProductsFromPriceDropPage)
        .as("We expect that every price from " + oldPriceOfProductsFromPriceDropPage
            + " is not null")
        .allMatch(aDouble -> aDouble != null);

    // Check that every product has new price
    List<Double> newPriceOfProductsFromPriceDropPage = mainPage
        .openMainPage()
        .clickPriceDropLink()
        .getNewPriceOfProductsFromPriceDropPage(allProductsFromPriceDropPage);

    softAssertions.assertThat(newPriceOfProductsFromPriceDropPage)
        .as("We expect that every price from " + newPriceOfProductsFromPriceDropPage
            + " is not null")
        .allMatch(aDouble -> aDouble != null);

    // Check that promo price for every product calculates correct
    List<Double> expectedPriceAfterDiscountOfProductsFromPriceDropPage = mainPage
        .openMainPage()
        .clickPriceDropLink()
        .getExpectedPriceDiscountFromPriceDropPage(allProductsFromPriceDropPage);

    softAssertions.assertThat(expectedPriceAfterDiscountOfProductsFromPriceDropPage)
        .as("We expect that New Price  " + newPriceOfProductsFromPriceDropPage
            + " are equal to Expected Price"
            + expectedPriceAfterDiscountOfProductsFromPriceDropPage)
        .isEqualTo(newPriceOfProductsFromPriceDropPage);

    softAssertions.assertAll();
  }

}



