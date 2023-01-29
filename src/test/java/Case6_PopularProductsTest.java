import blocks.ProductBlock;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;

public class Case6_PopularProductsTest extends BaseTest {

  @Test
  public void checkPopularProductsTest() {

    MainPage mainPage = new MainPage();
    SoftAssertions softAssertions = new SoftAssertions();

    int expectedSizePopularProducts = 8;
    double expectedPopularProductsHasPricesBiggerThan = 0.0;

    List<ProductBlock> allProductsFromMainPage = mainPage
        .openMainPage()
        .getAllProductsFromMainPage();

    // Check that 8 products exist in 'POPULAR PRODUCTS' section
    softAssertions.assertThat(allProductsFromMainPage)
        .as("We expect " + expectedSizePopularProducts + "products in 'POPULAR PRODUCTS' section")
        .hasSize(expectedSizePopularProducts);

    // Check that every product has name
    List<String> namesOfPopularProductsFromMainPage = mainPage
        .openMainPage()
        .getNamesOfPopularProductsFromMainPage(allProductsFromMainPage);

    softAssertions.assertThat(namesOfPopularProductsFromMainPage)
        .as("We expect that the name of each product will not be null")
        .doesNotContainNull();

    // Check that every product has price
    List<Double> actualPriceOfPopularProductsFromMainPage = mainPage
        .openMainPage()
        .getPriceOfPopularProductsFromMainPage(allProductsFromMainPage);

    softAssertions.assertThat(actualPriceOfPopularProductsFromMainPage)
        .as("We expect that the price of each product will not be null")
        .doesNotContainNull();

    // Check that all prices bigger than 0.00
    softAssertions.assertThat(actualPriceOfPopularProductsFromMainPage)
        .as("We expect that all prices bigger than "
            + expectedPopularProductsHasPricesBiggerThan)
        .allMatch(aDouble -> aDouble > expectedPopularProductsHasPricesBiggerThan);

    softAssertions.assertAll();
  }
}
