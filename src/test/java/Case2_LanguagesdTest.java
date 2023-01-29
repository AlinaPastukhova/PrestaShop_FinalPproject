
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;

public class Case2_LanguagesdTest extends BaseTest {

  @Test
  public void checkLanguagesdTest() {

    MainPage mainPage = new MainPage();
    SoftAssertions softAssertions = new SoftAssertions();

    int expectedSizeLanguagesInSelectDropdown = 44;
    String expectedNamesOfLanguagesOnSelectDropdown = "Українська";

    List<String> actualLanguagesInSelectDropdown = mainPage
        .openMainPage()
        .getTopMenuBlock()
        .clickLanguageSelectorButton()
        .getNamesOfLanguages();

    // Check that 44 languagesd exists in 'Language' dropdown in the top menu
    softAssertions.assertThat(actualLanguagesInSelectDropdown)
        .as("There are " + expectedSizeLanguagesInSelectDropdown + " languages in Drop Down")
        .hasSize(expectedSizeLanguagesInSelectDropdown);

    // Check that 'Українська' language exist in dropdown
    softAssertions.assertThat(actualLanguagesInSelectDropdown)
        .as("We check that " + expectedNamesOfLanguagesOnSelectDropdown
            + " exist in this Drop Down")
        .contains(expectedNamesOfLanguagesOnSelectDropdown);

    softAssertions.assertAll();
  }
}
