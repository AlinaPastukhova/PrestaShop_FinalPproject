import blocks.MainMenuBlock.MainMenuCategories;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;

public class CategoriesTest extends BaseTest {

  @Test
  public void checkCategoriesTest() {

    MainPage mainPage = new MainPage();
    SoftAssertions softAssertions = new SoftAssertions();

    String expectedNameOfMenDropdown = "MEN";
    String expectedNameOfWomenDropdown = "WOMEN";
    String expectedNameOfStationeryDropdown = "STATIONERY";
    String expectedNameOfHomeAccessoriesDropdown = "HOME ACCESSORIES";
    int expectedSizeCategoriesOfArtSubMenu = 0;

    List<String> actualNamesCategoriesClothesSubMenu = mainPage
        .openMainPage()
        .getMainMenuBlock()
        .hoverToMainManuButton(MainMenuCategories.CLOTHES)
        .getNameOfClothesSubMenu();

    // Check that 'MEN' and 'WOMEN' sub menu items appears
    softAssertions.assertThat(actualNamesCategoriesClothesSubMenu)
        .as("We expected categories "
            + expectedNameOfMenDropdown
            + expectedNameOfWomenDropdown
            + " of Clothes dropdown")
        .contains(expectedNameOfMenDropdown,
            expectedNameOfWomenDropdown);

    List<String> actualNamesCategoriesAccessoriesSubMenu = mainPage
        .openMainPage()
        .getMainMenuBlock()
        .hoverToMainManuButton(MainMenuCategories.ACCESSORIES)
        .getNameOfAccessoriesSubMenu();

    // Check that 'STATIONERY' and 'HOME ACCESSORIES' sub menu items appears
    softAssertions.assertThat(actualNamesCategoriesAccessoriesSubMenu)
        .as("We expected categories "
            + expectedNameOfStationeryDropdown
            + expectedNameOfHomeAccessoriesDropdown
            + " of Accessories dropdown")
        .contains(expectedNameOfStationeryDropdown,
            expectedNameOfHomeAccessoriesDropdown);

    // Check that not any sub category appears
    List<String> actualSizeCategoriesArtSubMenu = mainPage
        .openMainPage()
        .getMainMenuBlock()
        .hoverToMainManuButton(MainMenuCategories.ART)
        .getNameOfArtSubMenu();

    softAssertions.assertThat(actualSizeCategoriesArtSubMenu)
        .as("We expected size categories " + expectedSizeCategoriesOfArtSubMenu
            + " of Art dropdown")
        .hasSize(expectedSizeCategoriesOfArtSubMenu);

    softAssertions.assertAll();
  }

}
