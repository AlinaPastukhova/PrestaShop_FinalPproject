package pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterAccountPage extends BasePage {

  // Create an account
  private final By mrsSocialTitleButton = By.xpath("//input[@id='field-id_gender-2']");
  private final By firstNameField = By.xpath("//input[@id='field-firstname']");
  private final By lastNameField = By.xpath("//input[@id='field-lastname']");
  private final By emailField = By.xpath("//input[@id='field-email']");
  private final By passwordField = By.xpath("//input[@id='field-password']");
  private final By birthDateField = By.xpath("//input[@id='field-birthday']");
  private final By offersCheckBox = By.xpath("//input[@name='optin']");
  private final By customerPrivacyCheckBox = By.xpath("//input[@name='customer_privacy']");
  private final By newsLetterCheckBox = By.xpath("//input[@name='newsletter']");
  private final By privacyPolicyCheckBox = By.xpath("//input[@name='psgdpr']");
  private final By submitButton = By.xpath("//button[@type='submit']");
  private final By errorMessage = By.xpath("//li[@class='alert alert-danger']");


  public RegisterAccountPage clickMrsSocialTitleButton() {
    waitUntilPresents(mrsSocialTitleButton, 10);
    find(mrsSocialTitleButton).click();
    return this;
  }

  public RegisterAccountPage inputFirstNameField(String firstName) {
    scrollToElement(driver, firstNameField);
    find(firstNameField).sendKeys(firstName);
    return this;
  }

  public RegisterAccountPage inputLastNameField(String lastName) {
    find(lastNameField).sendKeys(lastName);
    return this;
  }

  public RegisterAccountPage inputEmailField(String email) {
    find(emailField).sendKeys(email);
    return this;
  }

  public RegisterAccountPage inputPasswordField(String password) {
    find(passwordField).sendKeys(password);
    return this;
  }

  public RegisterAccountPage inputBirthDateField(String birthDate) {
    find(birthDateField).sendKeys(birthDate);
    return this;
  }

  public RegisterAccountPage clickOffersCheckBox() {
    find(offersCheckBox).click();
    return this;
  }

  public RegisterAccountPage clickCustomerPrivacyCheckBox() {
    find(customerPrivacyCheckBox).click();
    return this;
  }

  public RegisterAccountPage clickNewsLetterCheckBox() {
    find(newsLetterCheckBox).click();
    return this;
  }

  public RegisterAccountPage clickPrivacyPolicyCheckBox() {
    find(privacyPolicyCheckBox).click();
    return this;
  }

  public UserAccountPage clickSubmitButton() {
    find(submitButton).click();
    return new UserAccountPage();
  }

  public RegisterAccountPage clickSubmitButtonWithError() {
    find(submitButton).click();
    return this;
  }

  public String getHighlightedColorWhenError() {
    waitRefreshed(firstNameField, 10);
    waitUntilPresents(firstNameField, 10);
    String highlighted = find(firstNameField).getCssValue("outline-color");
    return highlighted;
  }

  public List<String> getTextUnderFieldWithError() {
    List<String> errorText = new ArrayList<>();
    List<WebElement> elements = driver.findElements(errorMessage);
    for (WebElement element : elements) {
      String text = element.getText();
      errorText.add(text);
    }
    return errorText;
  }
}
