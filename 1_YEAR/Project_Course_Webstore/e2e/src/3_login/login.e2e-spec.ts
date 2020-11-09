import { browser, logging } from 'protractor';
import { LoginPage } from './login.po';

describe('Login Component', () => {
  const invalidCredentials = {
    username: 'test@test.mail',
    password: 'test01',
  };
  let page: LoginPage;

  beforeEach(() => {
    page = new LoginPage();
    browser.waitForAngularEnabled(false);
  });
  it('should be at the bikeshop homepage', () => {
    page.navigateTo();
    expect(page.getPageTitle()).toEqual('Startpage | Bikeshop');
  });
  // it('should login a valid user', () => {
  //   page.clickBurgerButton();
  //   page
  //     .clickLoginButton()
  //     .then(() => {
  //       page
  //         .login()
  //         .then(() => {
  //           page.waitForElementToDie(page.getLoginButton());
  //           expect(page.getLoginButton().isPresent()).toBeFalsy();
  //         })
  //         .catch(e => {
  //           console.log(e);
  //         });
  //     })
  //     .catch(e => {
  //       console.log(e);
  //     });
  // });
  // it('should logout a valid user', () => {
  //   page.logout().then(() => {
  //     page.waitForElementToAppear(page.getLoginButton());
  //     expect(page.getLoginButton().isPresent()).toBeTruthy();
  //   });
  // });
  // it('should not login a user with invalid credentials', () => {
  //   page
  //     .clickLoginButton()
  //     .then(() => {
  //       page
  //         .login(invalidCredentials)
  //         .then(() => {
  //           //TODO: Enable line bellow after invalid login stack trace fixed
  //           //page.waitForElementToDie(page.getLoginButton());
  //           expect(page.getLoginButton().isPresent()).toBeTruthy();
  //         })
  //         .catch(e => {
  //           console.log(e);
  //         });
  //     })
  //     .catch(e => {
  //       console.log(e);
  //     });
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
