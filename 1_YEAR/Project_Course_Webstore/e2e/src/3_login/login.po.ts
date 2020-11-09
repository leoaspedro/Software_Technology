import { browser, by, element, ExpectedConditions } from 'protractor';
import { UserUtils } from '../utils/userutils';

export class LoginPage {
  private registrationData = UserUtils.getInstance().RegistrationData;
  private credentials = {
    username: this.registrationData.email,
    password: this.registrationData.password,
  };
  navigateTo() {
    return browser.get(browser.baseUrl + '/dashboard') as Promise<any>;
  }

  getPageTitle() {
    return browser.getTitle() as Promise<any>;
  }
  waitForElementToAppear(element) {
    let EC = ExpectedConditions;
    browser.wait(EC.presenceOf(element), 3000);
  }
  waitForElementToDie(element) {
    let EC = ExpectedConditions;
    browser.wait(EC.not(EC.presenceOf(element)), 3000);
  }
  clickBurgerButton() {
    let burgerButton = this.getNavBarBurger();
    browser.driver.wait(ExpectedConditions.visibilityOf(burgerButton));
    browser.driver.wait(ExpectedConditions.elementToBeClickable(burgerButton));
    return burgerButton.click() as Promise<any>;
  }
  clickLoginButton() {
    let loginButton = this.getLoginButton();
    browser.driver.wait(ExpectedConditions.visibilityOf(loginButton));
    browser.driver.wait(ExpectedConditions.elementToBeClickable(loginButton));
    return loginButton.click() as Promise<any>;
  }
  logout() {
    let logoutButton = this.getLogoutButton();
    browser.driver.wait(ExpectedConditions.visibilityOf(logoutButton));
    browser.driver.wait(ExpectedConditions.elementToBeClickable(logoutButton));
    return logoutButton.click() as Promise<any>;
  }
  login(credentials: any = this.credentials) {
    element(by.css('input[formControlName=email]')).sendKeys(
      credentials.username
    );
    element(by.css('input[formControlName=password]')).sendKeys(
      credentials.password
    );
    let loginButton = element(by.id('loginForm-login'));
    return loginButton.click() as Promise<any>;
  }
  isLoginModalActive(): Promise<boolean> {
    return element(by.css('.modal.is-active')).isPresent() as Promise<boolean>;
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
    let customerID = element(by.css('customerID'));
    browser.driver.wait(ExpectedConditions.presenceOf(customerID), 5000);
    return customerID;
  }
  getNavBarBurger() {
    return element(by.id('burgerButton'));
  }
  getErrorMessage() {
    return element(by.css('.alert-danger')).getText();
  }
}
