
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;

public class NewsLetterLabelTest extends BaseTest {

  @Test
  public void checkInformationNearTheNewsLetterLabelTest() {

    MainPage mainPage = new MainPage();
    SoftAssertions softAssertions = new SoftAssertions();

    String expectedTextNearTheEmailField = "Get our latest news and special sales";
    String expectedTextUnderTheEmailField = "You may unsubscribe at any moment. For that purpose,"
        + " please find my contact info in the legal notice.";
    String expectedRegisterOnSubscribeButton = "uppercase";

    // On the button of the page check that text near the email field equals 'Get our latest news and special sales'
    String actualTextNearTheEmailField = mainPage
        .openMainPage()
        .getNewsLetterLabelBlock()
        .getTextNearTheEmailField();

    softAssertions.assertThat(actualTextNearTheEmailField)
        .as("On the button of the page text near the email field must be "
            + expectedTextNearTheEmailField)
        .isEqualTo(expectedTextNearTheEmailField);

    // On the button of the page check that text under email field contains
    // 'You may unsubscribe at any moment. For that purpose, please find my contact info in the legal notice.'
    String actualTextUnderTheEmailField = mainPage
        .openMainPage()
        .getNewsLetterLabelBlock()
        .getTextUnderTheEmailField();

    softAssertions.assertThat(actualTextUnderTheEmailField)
        .as("On the button of the page text under the email field must be "
            + expectedTextUnderTheEmailField)
        .isEqualTo(expectedTextUnderTheEmailField);

    // Check that all characters on 'SUBSCRIBE' button in upper case
    String actualCaseOnSubscribeButton = mainPage
        .openMainPage()
        .getNewsLetterLabelBlock()
        .getRegisterOnSubscribeButton();

    softAssertions.assertThat(actualCaseOnSubscribeButton)
        .as("All characters on 'SUBSCRIBE' button must be in upper case "
            + expectedRegisterOnSubscribeButton)
        .isEqualTo(expectedRegisterOnSubscribeButton);

    softAssertions.assertAll();
  }
}
