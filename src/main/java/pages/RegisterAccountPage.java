package pages;

import org.openqa.selenium.By;

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



  public RegisterAccountPage clickMrsSocialTitleButton() {
    BasePage.waitUntilPresents(mrsSocialTitleButton, 10);
    BasePage.find(mrsSocialTitleButton).click();
    return this;
  }

    public RegisterAccountPage inputFirstNameField(String firstName) {
    BasePage.scrollToElement(driver, firstNameField);
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
    BasePage.find(offersCheckBox).click();
    return this;
  }

  public RegisterAccountPage clickCustomerPrivacyCheckBox() {
    BasePage.find(customerPrivacyCheckBox).click();
    return this;
  }

  public RegisterAccountPage clickNewsLetterCheckBox() {
    BasePage.find(newsLetterCheckBox).click();
    return this;
  }

  public RegisterAccountPage clickPrivacyPolicyCheckBox() {
    BasePage.find(privacyPolicyCheckBox).click();
    return this;
  }

  public UserAccountPage clickSubmitButton() {
    BasePage.find(submitButton).click();
    return new UserAccountPage();
  }




}
