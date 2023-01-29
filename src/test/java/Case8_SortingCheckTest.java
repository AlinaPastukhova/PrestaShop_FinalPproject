import blocks.ProductBlock;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.AllProductsPage;
import pages.MainPage;

public class Case8_SortingCheckTest extends BaseTest {

  @Test
  public void checkSortingCheckTest() {

    MainPage mainPage = new MainPage();
    AllProductsPage allProductsPage = new AllProductsPage();

    SoftAssertions softAssertions = new SoftAssertions();

    // Sort products as 'Name, A to Z'
    List<ProductBlock> allProductsFromAllProductsPageAfterSortingFromAToZ = mainPage
        .openMainPage()
        .clickAllProductsLink()
        .clickSortButton()
        .clickSortFromAToZButton()
        .getAllProductsFromAllProductsPage();

    List<ProductBlock> sortedProductsFromAToZ = allProductsPage
        .getSortProductsFromAToZ(allProductsFromAllProductsPageAfterSortingFromAToZ);

    // Check that sorting is correct
    softAssertions.assertThat(allProductsFromAllProductsPageAfterSortingFromAToZ)
        .as("We expect that sorting  " + allProductsFromAllProductsPageAfterSortingFromAToZ +
            "is correct to " + sortedProductsFromAToZ)
        .isEqualTo(sortedProductsFromAToZ);

    // Sort products as 'Name, Z to A'
    List<ProductBlock> allProductsFromAllProductsPageAfterSortingFromZToA = allProductsPage
        .clickSortButton()
        .clickSortFromZToAButton()
        .getAllProductsFromAllProductsPage();

    List<ProductBlock> sortedProductsFromZToA = allProductsPage
        .getSortProductsFromZToA(allProductsFromAllProductsPageAfterSortingFromZToA);

    // Check that sorting is correct
    softAssertions.assertThat(allProductsFromAllProductsPageAfterSortingFromZToA)
        .as("We expect that sorting  " + allProductsFromAllProductsPageAfterSortingFromZToA +
            "is correct to " + sortedProductsFromZToA)
        .isEqualTo(sortedProductsFromZToA);

    // Sort products as 'Price, low to high'
    List<ProductBlock> allProductsFromAllProductsPageAfterSortingFromLowToHighPrice = allProductsPage
        .clickSortButton()
        .clickSortFromLowToHighPriceButton()
        .getAllProductsFromAllProductsPage();

    List<ProductBlock> sortedProductsFromLowToHighPrice = allProductsPage
        .getSortProductsFromLowToHighPrice(
            allProductsFromAllProductsPageAfterSortingFromLowToHighPrice);

    // Check that sorting is correct
    softAssertions.assertThat(allProductsFromAllProductsPageAfterSortingFromLowToHighPrice)
        .as("We expect that sorting  "
            + allProductsFromAllProductsPageAfterSortingFromLowToHighPrice +
            "is correct to " + sortedProductsFromLowToHighPrice)
        .isEqualTo(sortedProductsFromLowToHighPrice);

    // Sort products as 'Price, high to low'
    List<ProductBlock> allProductsFromAllProductsPageAfterSortingFromHighToLowPrice = allProductsPage
        .clickSortButton()
        .clickSortFromHighToLowPriceButton()
        .getAllProductsFromAllProductsPage();

    List<ProductBlock> sortedProductsFromHighToLowPrice = allProductsPage
        .getSortFromHighToLowPrice(allProductsFromAllProductsPageAfterSortingFromHighToLowPrice);

    // Check that sorting is correct
    softAssertions.assertThat(allProductsFromAllProductsPageAfterSortingFromHighToLowPrice)
        .as("We expect that sorting  "
            + allProductsFromAllProductsPageAfterSortingFromHighToLowPrice +
            "is correct to " + sortedProductsFromHighToLowPrice)
        .isEqualTo(sortedProductsFromHighToLowPrice);

    softAssertions.assertAll();
  }
}
