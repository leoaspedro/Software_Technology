import { browser, logging } from 'protractor';
import { RegistrationPage } from './registration.po';

describe('Registration Component', () => {
  const invalidCredentials = {
    username: 'test@test.mail',
    password: 'test01',
  };
  let page: RegistrationPage;

  beforeEach(() => {
    page = new RegistrationPage();
    browser.waitForAngularEnabled(false);
  });
  it('should be at the bikeshop homepage', () => {
    page.navigateTo();
    expect(page.getPageTitle()).toEqual('Startpage | Bikeshop');
  });
  // it('should register user John Smith with random email', () => {
  //   page.clickBurgerButton();
  //   page
  //     .clickLoginButton()
  //     .then(() => {
  //       page.register();
  //       let customer = page.getCustomer();
  //       page.waitForElementToAppear(customer);
  //       page.waitForElementTextToChange(customer, page.registrationData.name);
  //       expect(customer.getText()).toBe(page.registrationData.name);
  //     })
  //     .catch(e => {
  //       console.log(e);
  //     });
  // });
  // it('should logout registered user', () => {
  //   page.logout().then(() => {
  //     page.waitForElementToAppear(page.getLoginButton());
  //     expect(page.getLoginButton().isPresent()).toBeTruthy();
  //   });
  // });

  afterEach(async () => {
    // Assert that there are no errors emitted from the browser
    const logs = await browser
      .manage()
      .logs()
      .get(logging.Type.BROWSER);
    expect(logs).not.toContain(
      jasmine.objectContaining({
        level: logging.Level.SEVERE,
      } as logging.Entry)
    );
  });
});
