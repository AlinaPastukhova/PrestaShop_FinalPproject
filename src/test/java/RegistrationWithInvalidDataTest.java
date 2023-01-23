import com.github.javafaker.Faker;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.RegisterAccountPage;

public class RegistrationWithInvalidDataTest extends BaseTest {

  Faker faker = new Faker();

  String firstName = "James8";
  String lastName = faker.name().lastName();
  String email = faker.internet().emailAddress();
  String password = faker.internet().password();
  String birthdayDateField = "12/01/1994";

  @Test
  public void checkRegistrationWithInvalidDataTest() {

    MainPage mainPage = new MainPage();
    SoftAssertions softAssertions = new SoftAssertions();

    // "rgba(255, 76, 76, 1)" = red color
    String expectedHighlightedWhenError = "rgba(255, 76, 76, 1)";
    String expectedTextUnderErrorField = "Invalid name";

    mainPage
        .openMainPage()
        .getTopMenuBlock()
        .clickSignInButton()
        .clickCreateAccountLink()
        .clickMrsSocialTitleButton()
        .inputFirstNameField(firstName)
        .inputLastNameField(lastName)
        .inputEmailField(email)
        .inputPasswordField(password)
        .inputBirthDateField(birthdayDateField)
        .clickOffersCheckBox()
        .clickCustomerPrivacyCheckBox()
        .clickNewsLetterCheckBox()
        .clickPrivacyPolicyCheckBox()
        .clickWithErrorSubmitButton();

    RegisterAccountPage registerAccountPage = new RegisterAccountPage();

    String actualHighlightedWhenError = registerAccountPage.highlightedColorWhenError();

    // Check that 'First name' highlighted in red
    softAssertions.assertThat(actualHighlightedWhenError)
        .as("Expected that 'First name' highlighted in " + expectedHighlightedWhenError
            + " when error in the field")
        .isEqualTo(expectedHighlightedWhenError);

    // Check that pop-up with text 'Invalid name' appear under field
    List<String> actualTextUnderErrorField = registerAccountPage.getTextUnderErrorField();

    softAssertions.assertThat(actualTextUnderErrorField)
        .as("Expected text under error field " + expectedTextUnderErrorField)
        .isEqualTo(expectedTextUnderErrorField);

    softAssertions.assertAll();
  }
}