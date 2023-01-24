import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;

public class CategoriesTest extends BaseTest {

  @Test
  public void checkCategoriesTest() {

    MainPage mainPage = new MainPage();
    SoftAssertions softAssertions = new SoftAssertions();

    String expectedNameOfMenDropdownSubMenu = "MEN";
    String expectedNameOfWomenDropdownSubMenu = "WOMEN";
    String expectedNameOfStationeryDropdownSubMenu = "STATIONERY";
    String expectedNameOfHomeAccessoriesDropdownSubMenu = "HOME ACCESSORIES";

    List<String> actualNamesClothesSubMenu = mainPage
        .openMainPage()
        .getMainMenuBlock()
        .hoverToClothesButton()
        .getNameOfClothesSubMenu();

    // Check that 'MEN' and 'WOMEN' sub menu items appears
    softAssertions.assertThat(actualNamesClothesSubMenu)
        .as("We expected categories "
            + expectedNameOfMenDropdownSubMenu
            + expectedNameOfWomenDropdownSubMenu
            + " of Clothes dropdown SubMenu")
        .contains(expectedNameOfMenDropdownSubMenu,
            expectedNameOfWomenDropdownSubMenu);

    List<String> actualNamesAccessoriesSubMenu = mainPage
        .openMainPage()
        .getMainMenuBlock()
        .hoverToAccessoriesButton()
        .getNameOfAccessoriesSubMenu();

    // Check that 'STATIONERY' and 'HOME ACCESSORIES' sub menu items appears
    softAssertions.assertThat(actualNamesAccessoriesSubMenu)
        .as("We expected categories "
            + expectedNameOfStationeryDropdownSubMenu
            + expectedNameOfHomeAccessoriesDropdownSubMenu
            + " of Accessories dropdown SubMenu")
        .contains(expectedNameOfStationeryDropdownSubMenu,
            expectedNameOfHomeAccessoriesDropdownSubMenu);

    softAssertions.assertAll();
  }

}
