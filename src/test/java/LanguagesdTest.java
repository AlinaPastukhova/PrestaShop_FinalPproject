
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;

public class LanguagesdTest extends BaseTest {

  @Test
  public void checkLanguagesdTest() {

    MainPage mainPage = new MainPage();
    SoftAssertions softAssertions = new SoftAssertions();

    int expectedLanguageSize = 44;
    String expectedLanguageInDropDown = "Українська";

    // Check that 44 languagesd exists in 'Language' dropdown in the top menu
    int actualSizeLanguageSelectDropdown = mainPage.openMainPage()
        .getTopMenuBlock()
        .clickLanguageSelectorButton()
        .getSizeLanguageSelectDropdown();

    softAssertions.assertThat(actualSizeLanguageSelectDropdown)
        .as("There are " + expectedLanguageSize + " languages in Drop Down")
        .isEqualTo(expectedLanguageSize);

    // Check that 'Українська' language exist in dropdown
    String actualLanguageInDropDown = mainPage.openMainPage()
        .getTopMenuBlock()
        .clickLanguageSelectorButton()
        .getLanguageInDropDown();

    softAssertions.assertThat(actualLanguageInDropDown)
        .as("We check that " + expectedLanguageInDropDown + " exist in this Drop Down")
        .contains(expectedLanguageInDropDown);

    softAssertions.assertAll();

  }
}
