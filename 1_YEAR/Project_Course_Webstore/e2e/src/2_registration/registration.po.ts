import { browser, by, element, ExpectedConditions } from 'protractor';
import { UserUtils } from '../utils/userutils';
export class RegistrationPage {
  public registrationData = UserUtils.getInstance().RegistrationData;
  navigateTo() {
    return browser.get(browser.baseUrl + '/dashboard') as Promise<any>;
  }

  getPageTitle() {
    return browser.getTitle() as Promise<any>;
  }
  waitForElementTextToChange(element, text) {
    browser.wait(ExpectedConditions.textToBePresentInElement(element, text));
  }
  waitForElementToAppear(element) {
    let EC = ExpectedConditions;
    browser.wait(EC.presenceOf(element), 3000);
  }
  waitForElementToDie(element) {
    let EC = ExpectedConditions;
    browser.wait(EC.not(EC.presenceOf(element)), 3000);
  }
  waitForClickablElement(element) {
    browser.driver.wait(ExpectedConditions.visibilityOf(element));
    browser.driver.wait(ExpectedConditions.elementToBeClickable(element));
  }
  clickBurgerButton() {
    let burgerButton = this.getNavBarBurger();
    this.waitForClickablElement(burgerButton);
    return burgerButton.click() as Promise<any>;
  }
  clickLoginButton() {
    let loginButton = this.getLoginButton();
    this.waitForClickablElement(loginButton);
    return loginButton.click() as Promise<any>;
  }
  clickRegistrTab() {
    let registerTab = this.getRegisterTab();
    this.waitForClickablElement(registerTab);
    return registerTab.click() as Promise<any>;
  }
  clickContinueButton() {
    let continueButton = this.getContinueButton();
    this.waitForClickablElement(continueButton);
    return continueButton.click() as Promise<any>;
  }
  clickRegisterButton() {
    let registerButton = this.getRegisterButton();
    this.waitForClickablElement(registerButton);
    return registerButton.click() as Promise<any>;
  }
  logout() {
    let logoutButton = this.getLogoutButton();
    this.waitForClickablElement(logoutButton);
    return logoutButton.click() as Promise<any>;
  }
  register(registrationData: any = this.registrationData) {
    // console.log('Random Email: ' +registrationData.email);
    this.clickRegistrTab().then(() => {
      this.registerPageOne(registrationData).then(() => {
        this.registerPageTwo(registrationData);
        return this.clickRegisterButton() as Promise<any>;
      });
    });
  }
  registerPageTwo(registrationData: any = this.registrationData) {
    element(by.css('input[formControlName=email]')).sendKeys(
      registrationData.email
    );
    element(by.css('input[formControlName=password]')).sendKeys(
      registrationData.password
    );
    element(by.css('input[name=password2]')).sendKeys(
      registrationData.password
    );
    element(by.css('input[formControlName=password]')).click();
  }
  registerPageOne(registrationData: any = this.registrationData) {
    element(by.css('input[formControlName=name]')).sendKeys(
      registrationData.name
    );
    element(by.css('input[formControlName=address]')).sendKeys(
      registrationData.address
    );
    element(by.css('input[formControlName=city]')).sendKeys(
      registrationData.city
    );
    element(by.css('input[formControlName=postal]')).sendKeys(
      registrationData.zipCode
    );
    element(by.css('select[formControlName=country]'))
      .all(by.tagName('option'))
      .get(0)
      .click();
    return this.clickContinueButton();
  }
  isLoginModalActive(): Promise<boolean> {
    return element(by.css('.modal.is-active')).isPresent() as Promise<boolean>;
  }
  getContinueButton() {
    return element(by.id('registerContinue'));
  }
  getRegisterButton() {
    return element(by.id('registerSubmit'));
  }
  getRegisterTab() {
    return element(by.id('registerTab'));
  }
  getLogoutButton() {
    return element(by.id('logout'));
  }
  getLoginModal() {
    return element(by.id('login-modal'));
  }
  getLoginButton() {
    return element(by.id('primary-login'));
  }
  getCustomer() {
    return element(by.id('customerID'));
  }
  getNavBarBurger() {
    return element(by.id('burgerButton'));
  }
  getErrorMessage() {
    return element(by.css('.alert-danger')).getText();
  }
}
