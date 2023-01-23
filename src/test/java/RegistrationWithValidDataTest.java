import com.github.javafaker.Faker;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;

public class RegistrationWithValidDataTest extends BaseTest {

  Faker faker = new Faker();

  String firstName = faker.name().firstName();
  String lastName = faker.name().lastName();
  String email = faker.internet().emailAddress();
  String password = faker.internet().password();
  String birthdayDateField = "12/01/1994";

  @Test
  public void checkRegistrationWithValidDataTest() {

    MainPage mainPage = new MainPage();
    SoftAssertions softAssertions = new SoftAssertions();

    String expectedUserName = firstName + " " + lastName;

    String actualUserName = mainPage
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
        .clickSubmitButton()
        .getUserName();

    // Check your name appear near cart button
    softAssertions.assertThat(actualUserName)
        .as("Expected Name " + expectedUserName + " after registration account")
        .isEqualTo(actualUserName);

    softAssertions.assertAll();
  }
}