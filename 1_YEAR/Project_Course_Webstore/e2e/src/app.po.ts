import { browser, by, element, promise, ExpectedConditions } from 'protractor';

export class AppPage {
  navigateTo() {
    return browser.get(browser.baseUrl) as Promise<any>;
  }

  getPageTitle() {
    return browser.getTitle() as Promise<any>;
  }
}
